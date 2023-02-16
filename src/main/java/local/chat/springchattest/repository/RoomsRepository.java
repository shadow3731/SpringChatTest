package local.chat.springchattest.repository;

import local.chat.springchattest.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomsRepository extends JpaRepository<Room, Integer> {

    List<Room> findAllByRoomId(int roomId);
}
