package local.chat.springchattest.service.chats;

import local.chat.springchattest.entity.Message;
import local.chat.springchattest.repository.RoomsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomsServiceImpl implements RoomsService {

    private final RoomsRepository roomsRepository;

    public RoomsServiceImpl(@Autowired RoomsRepository roomsRepository) {
        this.roomsRepository = roomsRepository;
    }

    @Override
    public List<Message> getAllMessagesFromRoom(int roomId) {
        return roomsRepository.findAllByRoomId(roomId);
    }

    @Override
    public void saveMessage(Message message) {
        roomsRepository.save(message);
    }
}
