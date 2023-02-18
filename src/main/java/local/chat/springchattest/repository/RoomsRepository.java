package local.chat.springchattest.repository;

import local.chat.springchattest.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomsRepository extends JpaRepository<Message, Integer> {

    List<Message> findAllByRoomId(int roomId);
}
