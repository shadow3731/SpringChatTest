package local.chat.springchattest.repository;

import local.chat.springchattest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Integer> {

    List<User> findAll();

    Optional<User> findById(Integer integer);

    Optional<User> findByNickname(String nickname);
}
