package local.chat.springchattest.aspect;

import local.chat.springchattest.controller.CommonModel;
import local.chat.springchattest.entity.User;
import local.chat.springchattest.factory.UserFactory;
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
@Order(15)
public class OnlineAspect {

    private UsersService usersService;
    private UserFactory userFactory;

    @Autowired
    public void setUsersService(UsersService usersService) {
        this.usersService = usersService;
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
    public void beforeOnlineAspect() {
        //if (AuthenticatedUser.isThisUserAuthenticated()) {
        if (userFactory.getCurrentUser() != null &&
                userFactory.getCurrentUser().getAuthority() != null) {
            //User user = (User) CommonModel.getCommonModels().get("user");
            User user = userFactory.getCurrentUser();
            user.setLastActionAt(new Date());
            user.setLastActionAtInMills(user.getLastActionAt().getTime());
            usersService
                    .setLastActionAtByUserId(user.getId(), user.getLastActionAt());

            Map<String, Object> modelsMap = CommonModel.getCommonModels();
            modelsMap.replace("totalOnline", usersService.countAllUsersOnline());
            CommonModel.setCommonModels(modelsMap);
        }
    }
}
