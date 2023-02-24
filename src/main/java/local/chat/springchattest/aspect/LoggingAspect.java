package local.chat.springchattest.aspect;

import local.chat.springchattest.entity.Log;
import local.chat.springchattest.entity.Message;
import local.chat.springchattest.entity.User;
import local.chat.springchattest.factory.UserFactory;
import local.chat.springchattest.information.LogsListRequest;
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
    private UserFactory userFactory;

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

    @Pointcut("execution(public * local.chat.springchattest.controller.AuthenticationController.*(..))")
    private void allMethodsFromAuthenticationController() {}

    @Pointcut("execution(public * local.chat.springchattest.controller.AuthenticationController.showLogoutPage(..))")
    private void showLogoutPageMethodFromAuthenticationController() {}

    @Pointcut("allShowMethodsFromControllers() || " +
            "allAddMethodsFromControllers() || " +
            "allEditMethodsFromControllers() || " +
            "allDeleteMethodsFromControllers() && " +
            "(!allMethodsFromAuthenticationController() || " +
            "showLogoutPageMethodFromAuthenticationController())")
    private void allMethodsFromControllersExceptAuthenticationController() {}

    @Before("allMethodsFromControllersExceptAuthenticationController()")
    public void beforeLoggerAdvice(JoinPoint joinPoint) {
        //if (AuthenticatedUser.isThisUserAuthenticated()) {
        if (userFactory.getCurrentUser() != null &&
                userFactory.getCurrentUser().getAuthority() != null) {
            MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
            Object[] arguments = joinPoint.getArgs();
            Log log = new Log();
            //User user = (User) CommonModel.getCommonModels().get("user");
            User user = userFactory.getCurrentUser();
            Message message;

            log.setUser(usersService.getUserById(user.getId()));
            log.setTimestamp(new Date());

            if (methodSignature.getName().startsWith("show")) {
                log.setActionName("Enter to a page");
            } else if (methodSignature.getName().startsWith("add")) {
                log.setActionName("Add a data");
            } else if (methodSignature.getName().startsWith("edit")) {
                log.setActionName("Edit a data");
            } else if (methodSignature.getName().startsWith("delete")) {
                log.setActionName("Delete a data");
            }

            switch (methodSignature.getName()) {
                case "showIndexPage" -> log.setActionDescription("Enter to page with url GET:/");
                case "showAuthenticationPage" -> log.setActionDescription("Enter to page with url GET:/login");
                case "showRegistrationPage" -> log.setActionDescription("Enter to page with url GET:/register");
                case "showLogoutPage" -> log.setActionDescription("Enter to page with url GET:/logout");
                case "showChatPage" -> log.setActionDescription("Enter to page with url GET:/rooms/" + arguments[0] + "/messages");
                case "showEditMessagePage" -> log.setActionDescription("Enter to page with url GET:/rooms/" + arguments[0] + "/messages/" + arguments[1]);
                case "showAdminRoomPage" -> log.setActionDescription("Enter to page with url GET:/admin");
                case "showLogsPage" -> {
                    LogsListRequest logsListRequest = (LogsListRequest) arguments[1];
                    log.setActionName("Enter to a page");
                    log.setActionDescription("Enter to page with url GET:/admin/logs" +
                            "?pageId=" + logsListRequest.getPageId() +
                            "&userId=" + logsListRequest.getUserId() +
                            "&userNickname=" + logsListRequest.getUserNickname() +
                            "&from=" + logsListRequest.getFrom() +
                            "&till=" + logsListRequest.getTill() +
                            "&action=" + arguments[0]);
                }
                case "showUsersPage" -> log.setActionDescription("Enter to page with url GET:/users");
                case "addMessage" -> {
                    message = (Message) arguments[1];
                    log.setActionDescription("Add message [" + message.getMessage() +
                            "] with url POST:/rooms/" + arguments[0] + "/messages");
                } case "editMessage" -> {
                    Message oldMessage = roomsService.getMessageById((int) arguments[1]);
                    message = (Message) arguments[2];
                    log.setActionDescription("Edit message [" + oldMessage.getMessage() +
                            "] to [" + message.getMessage() + "] with url POST:/rooms/" +
                            arguments[0] + "/messages/" + arguments[1]);
                } case "deleteMessage" -> {
                    message = roomsService.getMessageById((int) arguments[1]);
                    log.setActionDescription("Delete message [" + message.getMessage() +
                            "] with url POST:/rooms/" + arguments[0] + "/messages/" +
                            arguments[1] + "/delete");
                }
            }

            logsService.saveLog(log);
        }
    }
}
