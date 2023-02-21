package local.chat.springchattest.aspect;

import local.chat.springchattest.controller.CommonModel;
import local.chat.springchattest.entity.Log;
import local.chat.springchattest.entity.Message;
import local.chat.springchattest.entity.User;
import local.chat.springchattest.information.AuthenticatedUser;
import local.chat.springchattest.service.chats.RoomsService;
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

    private RoomsService roomsService;

    @Autowired
    public void setLogsService(LogsService logsService) {
        this.logsService = logsService;
    }

    @Autowired
    public void setUsersService(UsersService usersService) {
        this.usersService = usersService;
    }

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

    @Pointcut("execution(public * local.chat.springchattest.controller.AuthenticationController.*(..))")
    private void allShowMethodsFromAuthenticationController() {}

    @Pointcut("execution(public * local.chat.springchattest.controller.AuthenticationController.showLogoutPage(..))")
    private void showLogoutPageMethodFromAuthenticationController() {}

    @Pointcut("allShowMethodsFromControllers() || " +
            "allAddMethodsFromControllers() || " +
            "allEditMethodsFromControllers() && " +
            "(!allShowMethodsFromAuthenticationController() || " +
            "showLogoutPageMethodFromAuthenticationController())")
    private void allMethodsFromControllersExceptAuthenticationController() {}

    @Before("allMethodsFromControllersExceptAuthenticationController()")
    public void beforeLoggerAdvice(JoinPoint joinPoint) {
        if (AuthenticatedUser.isThisUserAuthenticated()) {
            MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
            Object[] arguments = joinPoint.getArgs();
            Log log = new Log();
            User user = (User) CommonModel.getCommonModels().get("user");
            Message message;

            log.setUser(usersService.getUserById(user.getId()));
            log.setTimestamp(new Date());

            switch (methodSignature.getName()) {
                case "showIndexPage" -> {
                    log.setActionName("Enter to a page");
                    log.setActionDescription("Enter to page with url GET:/");
                } case "showAuthenticationPage" -> {
                    if (AuthenticatedUser.isThisUserAuthenticated()) {
                        log.setActionName("Redirect from an inaccessible page");
                        log.setActionDescription("Redirect to default page");
                    }
                } case "showLogoutPage" -> {
                    log.setActionName("Enter to a page");
                    log.setActionDescription("Enter to page with url GET:/logout");
                } case "showChatPage" -> {
                    log.setActionName("Enter to a page");
                    log.setActionDescription("Enter to page with url GET:/rooms/" +
                            arguments[0] + "/messages");
                } case "addMessage" -> {
                    message = (Message) arguments[1];
                    log.setActionName("Add a message");
                    log.setActionDescription("Add message [" + message.getMessage() +
                            "] with url POST:/rooms/" + arguments[0] + "/messages");
                } case "showEditMessagePage" -> {
                    log.setActionName("Enter to a page");
                    log.setActionDescription("Enter to page with url GET:/rooms/" +
                            arguments[0] + "/messages/" + arguments[1]);
                } case "editMessage" -> {
                    Message oldMessage = roomsService.getMessageById((int) arguments[1]);
                    message = (Message) arguments[2];
                    log.setActionName("Edit a message");
                    log.setActionDescription("Edit message [" + oldMessage.getMessage() +
                            "] to [" + message.getMessage() + "] with url POST:/rooms/" +
                            arguments[0] + "/messages/" + arguments[1]);
                } case "showAdminRoomPage" -> {
                    log.setActionName("Enter to a page");
                    log.setActionDescription("Enter to page with url GET:/admin");
                } case "showLogsPage" -> {
                    log.setActionName("Enter to a page");
                    log.setActionDescription("Enter to page with url GET:/admin/logs" +
                            "?id=" + arguments[0] +
                            "&nickname=" + arguments[1] +
                            "&from=" + arguments[2] +
                            "&till=" + arguments[3]);
                } case "showUsersPage" -> {
                    log.setActionName("Enter to a page");
                    log.setActionDescription("Enter to page with url GET:/users");
                }
            }

            logsService.saveLog(log);
        }
    }
}
