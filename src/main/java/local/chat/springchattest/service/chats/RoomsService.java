package local.chat.springchattest.service.chats;

import local.chat.springchattest.entity.Message;

import java.util.List;

public interface RoomsService {

    List<Message> getAllMessagesFromRoom(int roomId);

    void saveMessage(Message message);
}
