package local.chat.springchattest.service;

import local.chat.springchattest.dao.UsersDAO;
import local.chat.springchattest.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {

    private UsersDAO usersDAO;

    @Autowired
    public void setUsersDAO(UsersDAO usersDAO) {
        this.usersDAO = usersDAO;
    }

    @Override
    public List<User> getAllUsers() {
        return usersDAO.findAll();
    }

    @Override
    public int countAllUsers() {
        return usersDAO.findAll().size();
    }
}
