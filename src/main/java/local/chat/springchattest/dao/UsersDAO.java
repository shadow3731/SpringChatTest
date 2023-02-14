package local.chat.springchattest.dao;

import local.chat.springchattest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsersDAO extends JpaRepository<User, Integer> {

    List<User> findAll();
}
