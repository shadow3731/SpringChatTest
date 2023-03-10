package local.chat.springchattest.service.chats;

import local.chat.springchattest.entity.Message;

import java.util.List;

public interface RoomsService {

    List<Message> getAllNotDeletedMessagesFromRoom(int roomId, boolean isDeleted);

    Message getMessageById(int id);

    int countAllMessages();

    void saveMessage(Message message);
}
