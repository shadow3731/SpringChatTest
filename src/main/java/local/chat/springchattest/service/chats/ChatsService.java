package local.chat.springchattest.service.chats;

import local.chat.springchattest.entity.Chat;

import java.util.List;

public interface ChatsService {

    List<Chat> getAllMessagesFromRoom(int roomId);

    void saveMessage(Chat chat);
}
