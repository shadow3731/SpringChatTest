package local.chat.springchattest.aspect;

import local.chat.springchattest.controller.CommonModel;
import local.chat.springchattest.entity.User;
import local.chat.springchattest.information.AuthenticatedUser;
import local.chat.springchattest.service.users.UsersService;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

@Component
@Aspect
@Order(11)
public class OnlineAspect {

    private UsersService usersService;

    @Autowired
    public void setUsersService(UsersService usersService) {
        this.usersService = usersService;
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
    public void beforeOnlineAspect() {
        if (AuthenticatedUser.isThisUserAuthenticated()) {
            User user = (User) CommonModel.getCommonModels().get("user");
            user.setLastActionAt(new Date());
            user.setLastActionAtInMills(user.getLastActionAt().getTime());
            usersService.saveUser(user);

            Map<String, Object> modelsMap = CommonModel.getCommonModels();
            modelsMap.replace("totalOnline", usersService.countAllUsersOnline());
            CommonModel.setCommonModels(modelsMap);
        }
    }
}
