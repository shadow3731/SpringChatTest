package local.chat.springchattest.repository;

import local.chat.springchattest.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface RoomsRepository extends JpaRepository<Message, Integer> {

    @Query("select m from Message m where m.roomId=:roomId and m.isDeleted=:isDeleted")
    List<Message> findAllByRoomIdAndDeletedEquals(int roomId, boolean isDeleted);

    Optional<Message> findById(int id);
}
