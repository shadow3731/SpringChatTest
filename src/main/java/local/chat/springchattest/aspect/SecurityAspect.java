package local.chat.springchattest.aspect;

import local.chat.springchattest.controller.CommonModel;
import local.chat.springchattest.entity.Log;
import local.chat.springchattest.entity.Message;
import local.chat.springchattest.entity.User;
import local.chat.springchattest.factory.UserFactory;
import local.chat.springchattest.information.AuthenticatedUser;
import local.chat.springchattest.service.chats.RoomsService;
import local.chat.springchattest.service.logs.LogsService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Aspect
@Order(20)
public class SecurityAspect {

    private RoomsService roomsService;
    private LogsService logsService;
    private UserFactory userFactory;

    @Autowired
    public void setRoomsService(RoomsService roomsService) {
        this.roomsService = roomsService;
    }

    @Autowired
    public void setLogsService(LogsService logsService) {
        this.logsService = logsService;
    }

    @Autowired
    public void setUserFactory(UserFactory userFactory) {
        this.userFactory = userFactory;
    }

    @Pointcut("execution(public * local.chat.springchattest.controller.*.show*(..))")
    private void allShowMethodsFromControllers() {}

    @Pointcut("execution(public * local.chat.springchattest.controller.*.add*(..))")
    private void allAddMethodsFromControllers() {}

    @Pointcut("execution(public * local.chat.springchattest.controller.*.edit*(..))")
    private void allEditMethodsFromControllers() {}

    @Pointcut("execution(public * local.chat.springchattest.controller.*.delete*(..))")
    private void allDeleteMethodsFromControllers() {}

    @Around("allShowMethodsFromControllers() || " +
            "allAddMethodsFromControllers() || " +
            "allEditMethodsFromControllers() || " +
            "allDeleteMethodsFromControllers()")
    public String afterReturningSecurityAdvice(ProceedingJoinPoint proceedingJoinPoint)
            throws Throwable {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint
                .getSignature();
        Object[] arguments = proceedingJoinPoint.getArgs();
        //User user = (User) CommonModel.getCommonModels().get("user");
        User user = userFactory.getCurrentUser();
        Message message;
        String pageName = "login";
        Log log = new Log();

        log.setUser(user);
        log.setTimestamp(new Date());
        log.setActionName("Commit an inaccessible action");
        log.setActionDescription("Redirect to a default page");

        switch (methodSignature.getName()) {
            case "showIndexPage", "showChatPage",
                    "addMessage", "showUsersPage",
                    "showEditMessagePage", "editMessage" -> {
                if (user.getAuthority() == null) {
                    return "redirect:/login";
                }
            } case "showAuthenticationPage", "addAuthentication",
                    "showRegistrationPage", "addRegistration" -> {
                if (user.getAuthority() != null) {
                    logsService.saveLog(log);
                    return "redirect:/";
                }
            } case "showAdminRoomPage", "showLogsPage",
                    "deleteMessage" -> {
                if (user.getAuthority() == null) {
                    return "redirect:/login";
                } else if (user.getAuthority() != null && user.getAuthority().getId() < 2) {
                    logsService.saveLog(log);
                    return "redirect:/";
                }
            }
        }

        try {
            pageName = (String) proceedingJoinPoint.proceed();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (methodSignature.getName().equals("showEditMessagePage") ||
                methodSignature.getName().equals("editMessage")) {
            Date serverTime = (Date) CommonModel
                    .getCommonModels().get("serverDateTime");
            message = roomsService.getMessageById((int) arguments[1]);

            if (user.getId() != message.getUser().getId() ||
                    message.getEditDeadlineMills() < serverTime.getTime()) {
                logsService.saveLog(log);
                return "redirect:/rooms/" + arguments[0] +
                        "/messages";
            }
        }

        return pageName;
    }


}
