package local.chat.springchattest.aspect;

import local.chat.springchattest.factory.UserFactory;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class InitializerAspect {

    private UserFactory userFactory;

    @Autowired
    public void setUserFactory(UserFactory userFactory) {
        this.userFactory = userFactory;
    }

    @Before("execution(* local.chat.springchattest.controller.*.*(..))")
    public void createUser() {
        if (userFactory.getCurrentUser() == null) {
            userFactory.createUser();
            System.out.println(userFactory);
        }
    }
}
