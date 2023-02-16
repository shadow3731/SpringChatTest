package local.chat.springchattest.repository;

import local.chat.springchattest.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthoritiesRepository extends JpaRepository<Authority, Integer> {
}
