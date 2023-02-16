package local.chat.springchattest.repository;

import local.chat.springchattest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsersRepository extends JpaRepository<User, Integer> {

    List<User> findAll();

    User findUserById(int id);

    User findUserByNickname(String nickname);
}
