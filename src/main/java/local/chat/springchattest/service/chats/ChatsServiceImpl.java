package local.chat.springchattest.service.chats;

import local.chat.springchattest.repository.ChatsRepository;
import local.chat.springchattest.entity.Chat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatsServiceImpl implements ChatsService {

    private ChatsRepository chatsRepository;

    @Autowired
    public void setChatsDAO(ChatsRepository chatsRepository) {
        this.chatsRepository = chatsRepository;
    }

    @Override
    public List<Chat> getAllMessagesFromRoom(int roomId) {
        return chatsRepository.findAllByRoomId(roomId);
    }

    @Override
    public void saveMessage(Chat chat) {
        chatsRepository.save(chat);
    }
}
