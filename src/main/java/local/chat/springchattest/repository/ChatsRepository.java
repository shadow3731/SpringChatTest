package local.chat.springchattest.repository;

import local.chat.springchattest.entity.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatsRepository extends JpaRepository<Chat, Integer> {

    List<Chat> findAllByRoomId(int roomId);
}
