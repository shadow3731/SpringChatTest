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

    @Around("allShowMethodsFromControllers()")
    public String afterReturningSecurityAdvice(ProceedingJoinPoint proceedingJoinPoint)
            throws Throwable {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint
                .getSignature();
        Object[] arguments = proceedingJoinPoint.getArgs();
        User user = (User) CommonModel.getCommonModels().get("user");
        Message message;
        String pageName = "login";

        try {
            pageName = (String) proceedingJoinPoint.proceed();
        } catch (Exception e) {
            e.printStackTrace();
        }

        switch (methodSignature.getName()) {
            case "showIndexPage", "showChatPage",
                    "showUsersPage" -> {
                if (!AuthenticatedUser.isThisUserAuthenticated()) {
                    pageName = "redirect:/login";
                }
            } case "showAuthenticationPage",
                    "showRegistrationPage" -> {
                if (AuthenticatedUser.isThisUserAuthenticated()) {
                    pageName = "redirect:/";
                }
            } case "showAdminRoomPage", "showLogsPage" -> {
                if (!AuthenticatedUser.isThisUserAuthenticated() ||
                        AuthenticatedUser.getThisUserIdAuthority() < 2) {
                    pageName = "redirect:/login";
                }
            } case "showEditMessagePage" -> {
                if (!AuthenticatedUser.isThisUserAuthenticated()) {
                    pageName = "redirect:/login";
                } else {
                    Date serverTime = (Date) CommonModel
                            .getCommonModels().get("serverDateTime");
                    message = roomsService.getMessageById((int) arguments[1]);

                    if (user.getId() != message.getUser().getId() ||
                            message.getEditDeadlineMills() < serverTime.getTime()) {
                        pageName = "redirect:/rooms/" + arguments[0] +
                                "/messages";
                    }
                }
            }
        }

        return pageName;
    }


}
