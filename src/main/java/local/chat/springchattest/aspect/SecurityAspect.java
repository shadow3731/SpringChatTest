package local.chat.springchattest.aspect;

import local.chat.springchattest.information.AuthenticatedUser;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(20)
public class SecurityAspect {

    @Pointcut("execution(public * local.chat.springchattest.controller.*.show*(..))")
    private void allShowMethodsFromControllers() {}

    @Around("allShowMethodsFromControllers()")
    public String afterReturningSecurityAdvice(ProceedingJoinPoint proceedingJoinPoint)
            throws Throwable {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint
                .getSignature();
        String pageName = "login";

        try {
            pageName = (String) proceedingJoinPoint.proceed();
        } catch (Exception e) {
            e.printStackTrace();
        }

        switch (methodSignature.getName()) {
            case "showIndexPage", "showChatPage",
                    "showEditMessagePage", "showUsersPage" -> {
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
            }
        }

        return pageName;
    }


}
