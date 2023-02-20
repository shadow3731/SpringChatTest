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

    @GetMapping("/rooms/{id}/messages")
    public String showChatPage(@PathVariable("id") int roomId,
                              Model model) {
        model.addAttribute("roomId", roomId);
        model.addAttribute("messages",
                roomsService.getAllNotDeletedMessagesFromRoom(roomId, false));
        model.addAttribute("newMessage", new Message());
        return "rooms/rooms";
    }

    @PostMapping("/rooms/{id}/messages")
    public String addMessage(@PathVariable("id") int roomId,
                             @ModelAttribute("newMessage") @Valid Message message,
                             BindingResult bindingResult,
                             Model model) {
        if (AuthenticatedUser.isThisUserAuthenticated()) {
            if (bindingResult.hasErrors()) {
                model.addAttribute("roomId", roomId);
                model.addAttribute("messages",
                        roomsService.getAllNotDeletedMessagesFromRoom(roomId, false));
                model.addAttribute("newMessage", new Message());
                return "rooms/rooms";
            }

            message.setId(roomsService.countAllMessages() + 1);
            message.setRoomId(roomId);
            message.setTimestamp(new Date());
            message.setDeleted(false);

            User user = (User) CommonModel.getCommonModels().get("user");
            message.setUser(usersService.getUserById(user.getId()));

            roomsService.saveMessage(message);
            return "redirect:/rooms/" + roomId + "/messages";
        } else {
            return "redirect:/login";
        }
    }

    @ModelAttribute
    public void getCommonInfo(Model model) {
        model.addAllAttributes(CommonModel.getCommonModels());
    }
}
