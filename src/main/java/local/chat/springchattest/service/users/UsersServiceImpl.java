package local.chat.springchattest.service.users;

import local.chat.springchattest.repository.UsersRepository;
import local.chat.springchattest.entity.User;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
public class UsersServiceImpl implements UsersService {

    private UsersRepository usersRepository;

    @Autowired
    public void setUsersRepository(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return usersRepository.findAll();
    }

    @Override
    public int countAllUsers() {
        return (int) usersRepository.count();
    }

    @Override
    public User getUserById(int id) {
        return usersRepository.findById(id).orElse(null);
    }

    @Override
    public User getUserByNickname(String nickname) {
        return usersRepository.findByNickname(nickname).orElse(null);
    }

    @Override
    public void saveUser(User user) {
        usersRepository.save(user);
    }
}
