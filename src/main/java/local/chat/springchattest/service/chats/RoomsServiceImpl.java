package local.chat.springchattest.service.chats;

import local.chat.springchattest.entity.Room;
import local.chat.springchattest.repository.RoomsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomsServiceImpl implements RoomsService {

    private RoomsRepository roomsRepository;

    public RoomsServiceImpl(@Autowired RoomsRepository roomsRepository) {
        this.roomsRepository = roomsRepository;
    }

    @Override
    public List<Room> getAllMessagesFromRoom(int roomId) {
        return roomsRepository.findAllByRoomId(roomId);
    }

    @Override
    public void saveMessage(Room room) {
        roomsRepository.save(room);
    }
}
