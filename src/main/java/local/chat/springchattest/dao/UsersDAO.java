package local.chat.springchattest.dao;

import local.chat.springchattest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersDAO extends JpaRepository<User, Integer> {

    int countAll();
}
