package local.chat.springchattest.factory;

import local.chat.springchattest.entity.User;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UserFactory {

    private final ThreadLocal<User> currentUser = new ThreadLocal<>();

    public void createUser() {
        User user = new User();
        currentUser.set(user);
    }

    public User getCurrentUser() {
        return currentUser.get();
    }

    public void removeCurrentUser() {
        currentUser.remove();
    }
}
