package local.chat.springchattest.service.users;

import local.chat.springchattest.entity.User;

import java.util.Date;
import java.util.List;

public interface UsersService {

    List<User> getAllUsers();

    int countAllUsers();

    User getUserById(int id);

    User getUserByNickname(String nickname);

    int countAllUsersOnline();

    void saveUser(User user);

    void setLastActionAtByUserId(int id, Date timestamp);
}
