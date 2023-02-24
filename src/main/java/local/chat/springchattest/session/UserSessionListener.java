package local.chat.springchattest.session;

import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;
import local.chat.springchattest.entity.User;
import local.chat.springchattest.factory.UserFactory;

public class UserSessionListener implements HttpSessionListener {

    private UserFactory userFactory;

    public UserSessionListener(UserFactory userFactory) {
        this.userFactory = userFactory;
    }

    @Override
    public void sessionCreated(HttpSessionEvent sessionEvent) {
        System.out.println("session created");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent sessionEvent) {
        User user = (User) sessionEvent.getSession().getAttribute("user");
        System.out.println("User " + user.getNickname() + " disconnected");
        userFactory.removeCurrentUser();
    }
}
