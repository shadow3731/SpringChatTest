package local.chat.springchattest.controller;

import jakarta.validation.Valid;
import local.chat.springchattest.entity.Message;
import local.chat.springchattest.entity.User;
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
        if (CommonModel.isThisUserAuthenticated()) {
            model.addAttribute("roomId", roomId);
            model.addAttribute("messages",
                    roomsService.getAllMessagesFromRoom(roomId));
            model.addAttribute("newMessage", new Message());
            return "rooms";
        } else {
            return "redirect:/login";
        }
    }

    @PostMapping("/rooms/{id}/messages")
    public String addMessage(@PathVariable("id") int roomId,
                             @ModelAttribute("newMessage") @Valid Message message,
                             BindingResult bindingResult,
                             Model model) {
        if (CommonModel.isThisUserAuthenticated()) {
            if (bindingResult.hasErrors()) {
                model.addAttribute("roomId", roomId);
                model.addAttribute("messages",
                        roomsService.getAllMessagesFromRoom(roomId));
                model.addAttribute("newMessage", new Message());
                return "rooms";
            }

            message.setRoomId(roomId);
            message.setTimestamp(new Date());

            User user = (User) CommonModel.getCommonModels().get("user");
            message.setUser(usersService.getUserById(user.getId()));

            roomsService.saveMessage(message);
            return "redirect:/rooms/" + roomId + "/messages";
        } else {
            return "redirect:/login";
        }
    }

    @ModelAttribute
    public void addCommonInfo(Model model) {
        model.addAllAttributes(CommonModel.getCommonModels());
    }
}
