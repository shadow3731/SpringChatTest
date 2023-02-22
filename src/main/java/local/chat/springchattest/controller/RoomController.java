package local.chat.springchattest.controller;

import jakarta.validation.Valid;
import local.chat.springchattest.entity.Message;
import local.chat.springchattest.entity.User;
import local.chat.springchattest.information.AuthenticatedUser;
import local.chat.springchattest.service.chats.RoomsService;
import local.chat.springchattest.service.users.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
public class RoomController {

    private RoomsService roomsService;
    private UsersService usersService;

    @Autowired
    public void setRoomsService(RoomsService roomsService) {
        this.roomsService = roomsService;
    }

    @Autowired
    public void setUsersService(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/rooms/{roomId}/messages")
    public String showChatPage(@PathVariable("roomId") int roomId,
                              Model model) {
        List<Message> messageList = roomsService
                .getAllNotDeletedMessagesFromRoom(roomId, false);
        for (Message m : messageList) {
            m.setEditDeadlineMills(m.
                    getTimestamp().getTime() + 120000);
        }

        Date serverDateTime = (Date) CommonModel
                .getCommonModels().get("serverDateTime");

        model.addAttribute("roomId", roomId);
        model.addAttribute("messages", messageList);
        model.addAttribute("newMessage", new Message());
        model.addAttribute("user",
                CommonModel.getCommonModels().get("user"));
        model.addAttribute("serverDateTimeInMills",
                serverDateTime.getTime());
        return "rooms/rooms";
    }

    @PostMapping("/rooms/{roomId}/messages")
    public String addMessage(@PathVariable("roomId") int roomId,
                             @ModelAttribute("newMessage") @Valid Message message,
                             BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "redirect:/rooms/" + roomId + "/messages";
        }

        message.setId(roomsService.countAllMessages() + 1);
        message.setRoomId(roomId);
        message.setTimestamp(new Date());
        message.setDeleted(false);

        User user = (User) CommonModel.getCommonModels().get("user");
        message.setUser(usersService.getUserById(user.getId()));

        roomsService.saveMessage(message);
        return "redirect:/rooms/" + roomId + "/messages";
    }

    @GetMapping("/rooms/{roomId}/messages/{id}")
    public String showEditMessagePage(@PathVariable("roomId") int roomId,
                                      @PathVariable("id") int id,
                                      Model model) {
        Message message = roomsService.getMessageById(id);
        if (message != null) {
            message.setEditDeadlineMills(message.
                    getTimestamp().getTime() + 120000);
            model.addAttribute("thisMessage", message);
        } else {
            return "redirect:/rooms/" + roomId + "/messages";
        }

        return "/rooms/edit";
    }

    @PostMapping("/rooms/{roomId}/messages/{id}")
    public String editMessage(@PathVariable("roomId") int roomId,
                              @PathVariable("id") int id,
                              @ModelAttribute("thisMessage") @Valid Message message,
                              BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "redirect:/rooms/" + roomId + "/messages/" + id;
        }

        Message DBMessage = roomsService.getMessageById(id);
        DBMessage.setMessage(message.getMessage());
        roomsService.saveMessage(DBMessage);
        return "redirect:/rooms/" + roomId + "/messages";
    }

    @PostMapping("/rooms/{roomId}/messages/{id}/delete")
    public String deleteMessage(@PathVariable("roomId") int roomId,
                                @PathVariable("id") int id) {
        Message message = roomsService.getMessageById(id);
        if (message != null) {
            message.setDeleted(true);
            roomsService.saveMessage(message);
        }

        return "redirect:/rooms/" + roomId + "/messages";
    }

    @ModelAttribute
    public void getCommonInfo(Model model) {
        model.addAllAttributes(CommonModel.getCommonModels());
    }
}
