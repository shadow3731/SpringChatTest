package local.chat.springchattest.service.users;

import local.chat.springchattest.repository.UsersRepository;
import local.chat.springchattest.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {

    private UsersRepository usersRepository;

    @Autowired
    public void setUsersDAO(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return usersRepository.findAll();
    }

    @Override
    public int countAllUsers() {
        return usersRepository.findAll().size();
    }
}
