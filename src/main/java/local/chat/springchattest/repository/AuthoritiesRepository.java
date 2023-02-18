package local.chat.springchattest.repository;

import local.chat.springchattest.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthoritiesRepository extends JpaRepository<Authority, Integer> {

    Optional<Authority> findById(int id);
}
