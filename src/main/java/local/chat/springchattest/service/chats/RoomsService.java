package local.chat.springchattest.service.chats;

import local.chat.springchattest.entity.Room;

import java.util.List;

public interface RoomsService {

    List<Room> getAllMessagesFromRoom(int roomId);

    void saveMessage(Room room);
}
