package local.chat.springchattest.aspect;

import local.chat.springchattest.controller.CommonModel;
import local.chat.springchattest.entity.Message;
import local.chat.springchattest.entity.User;
import local.chat.springchattest.information.AuthenticatedUser;
import local.chat.springchattest.service.chats.RoomsService;
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

    @Autowired
    public void setRoomsService(RoomsService roomsService) {
        this.roomsService = roomsService;
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
        User user = (User) CommonModel.getCommonModels().get("user");
        Message message;
        String pageName = "login";

        switch (methodSignature.getName()) {
            case "showIndexPage", "showChatPage",
                    "addMessage", "showUsersPage",
                    "showEditMessagePage", "editMessage" -> {
                if (!AuthenticatedUser.isThisUserAuthenticated()) {
                    return "redirect:/login";
                }
            } case "showAuthenticationPage", "addAuthentication",
                    "showRegistrationPage", "addRegistration" -> {
                if (AuthenticatedUser.isThisUserAuthenticated()) {
                    return "redirect:/";
                }
            } case "showAdminRoomPage", "showLogsPage",
                    "deleteMessage" -> {
                if (!AuthenticatedUser.isThisUserAuthenticated() ||
                        AuthenticatedUser.getThisUserIdAuthority() < 2) {
                    return "redirect:/login";
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
                return "redirect:/rooms/" + arguments[0] +
                        "/messages";
            }
        }

        return pageName;
    }


}
