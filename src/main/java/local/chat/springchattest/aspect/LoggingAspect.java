package local.chat.springchattest.aspect;

import local.chat.springchattest.controller.CommonModel;
import local.chat.springchattest.entity.Log;
import local.chat.springchattest.entity.User;
import local.chat.springchattest.information.AuthenticatedUser;
import local.chat.springchattest.service.logs.LogsService;
import local.chat.springchattest.service.users.UsersService;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
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

    @Before("execution(public String showIndexPage())")
    public void beforeShowIndexPageAdvice() {
        if (AuthenticatedUser.isThisUserAuthenticated()) {
            Log log = new Log();
            User user = (User) CommonModel.getCommonModels().get("user");

            log.setUser(usersService.getUserById(user.getId()));
            log.setTimestamp(new Date());
            log.setActionName("Enter to a page");
            log.setActionDescription("Enter to page with url:/");

            logsService.saveLog(log);
        }
    }
}
