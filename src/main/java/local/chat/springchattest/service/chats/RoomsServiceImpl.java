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
    public List<Message> getAllNotDeletedMessagesFromRoom(int roomId, boolean isDeleted) {
        return roomsRepository.findAllByRoomIdAndDeletedEquals(roomId, isDeleted);
    }

    @Override
    public Message getMessageById(int id) {
        return roomsRepository.findById(id).orElse(null);
    }

    @Override
    public int countAllMessages() {
        return (int) roomsRepository.count();
    }

    @Override
    public void saveMessage(Message message) {
        roomsRepository.save(message);
    }
}
