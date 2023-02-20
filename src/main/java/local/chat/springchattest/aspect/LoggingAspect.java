package local.chat.springchattest.aspect;

import local.chat.springchattest.controller.CommonModel;
import local.chat.springchattest.entity.Log;
import local.chat.springchattest.entity.User;
import local.chat.springchattest.information.AuthenticatedUser;
import local.chat.springchattest.service.logs.LogsService;
import local.chat.springchattest.service.users.UsersService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Aspect
@Order(10)
public class LoggingAspect {

    private LogsService logsService;
    private UsersService usersService;

    @Autowired
    public void setLogsService(LogsService logsService) {
        this.logsService = logsService;
    }

    @Autowired
    public void setUsersService(UsersService usersService) {
        this.usersService = usersService;
    }

    @Pointcut("execution(public * local.chat.springchattest.controller.*.show*(..))")
    private void allShowMethodsFromControllers() {}

    @Pointcut("execution(public * local.chat.springchattest.controller.AuthenticationController.show*(..))")
    private void allShowMethodsFromAuthenticationController() {}

    @Pointcut("execution(public * local.chat.springchattest.controller.AuthenticationController.showLogoutPage(..))")
    private void showLogoutPageMethodFromAuthenticationController() {}

    @Pointcut("allShowMethodsFromControllers() && (!allShowMethodsFromAuthenticationController() || showLogoutPageMethodFromAuthenticationController())")
    private void allShowMethodsFromControllersExceptAuthenticationController() {}

    @Before("allShowMethodsFromControllersExceptAuthenticationController()")
    public void beforeShowPagesAdvice(JoinPoint joinPoint) {
        if (AuthenticatedUser.isThisUserAuthenticated()) {
            MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
            Log log = new Log();
            User user = (User) CommonModel.getCommonModels().get("user");

            log.setUser(usersService.getUserById(user.getId()));
            log.setTimestamp(new Date());
            log.setActionName("Enter to a page");

            String action = "Enter to page with url GET:";
            Object[] arguments = joinPoint.getArgs();

            switch (methodSignature.getName()) {
                case "showIndexPage" -> log.setActionDescription(action + "/");
                case "showLogoutPage" -> log.setActionDescription(action + "/logout");
                case "showChatPage" -> log.setActionDescription(action + "/rooms/" + arguments[0] + "/messages");
                case "showAdminRoomPage" -> log.setActionDescription(action + "/admin");
                case "showLogsPage" -> log.setActionDescription(action +
                        "/admin/logs?id=" + arguments[0] +
                        "&nickname=" + arguments[1] +
                        "&from=" + arguments[2] +
                        "&till=" + arguments[3]);
                case "showUsersPage" -> log.setActionDescription(action + "/users");
            }

            logsService.saveLog(log);
        }
    }
}