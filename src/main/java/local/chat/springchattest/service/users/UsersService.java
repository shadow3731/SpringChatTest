package local.chat.springchattest.service.users;

import local.chat.springchattest.entity.User;

import java.util.List;

public interface UsersService {

    List<User> getAllUsers();

    int countAllUsers();
}
