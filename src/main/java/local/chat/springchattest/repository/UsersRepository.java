package local.chat.springchattest.repository;

import jakarta.transaction.Transactional;
import local.chat.springchattest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Integer> {

    List<User> findAll();

    Optional<User> findById(Integer integer);

    Optional<User> findByNickname(String nickname);

    int countAllByLastActionAtAfter(Date from);

    @Modifying
    @Transactional
    @Query("update User u set u.lastActionAt=:timestamp where u.id=:id")
    void updateLastActionAtById(@Param("id") int id,
                                @Param("timestamp") Date timestamp);
}
