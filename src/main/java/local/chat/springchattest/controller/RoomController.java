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

    @GetMapping("/rooms/{roomId}/messages")
    public String showChatPage(@PathVariable("roomId") int roomId,
                              Model model) {
        model.addAttribute("roomId", roomId);
        model.addAttribute("messages",
                roomsService.getAllNotDeletedMessagesFromRoom(roomId, false));
        model.addAttribute("newMessage", new Message());
        model.addAttribute("user",
                CommonModel.getCommonModels().get("user"));
        return "rooms/rooms";
    }

    @PostMapping("/rooms/{roomId}/messages")
    public String addMessage(@PathVariable("roomId") int roomId,
                             @ModelAttribute("newMessage") @Valid Message message,
                             BindingResult bindingResult) {
        if (AuthenticatedUser.isThisUserAuthenticated()) {
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
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("/rooms/{roomId}/messages/{id}")
    public String showEditMessagePage(@PathVariable("roomId") int roomId,
                                      @PathVariable("id") int id,
                                      Model model) {
        Message message = roomsService.getMessageById(id);
        if (message != null) {
            model.addAttribute("thisMessage", message);
        } else {
            return "redirect:/rooms/" + roomId + "/messages";
        }

        return "/rooms/edit";
    }

    /*@PatchMapping("/rooms/{roomId}/messages/{messageId}")
    public String editMessage(@PathVariable("roomId") int roomId,
                              @PathVariable("messageId") int id,
                              @ModelAttribute("thisMessage") @Valid Message message) {
        if (AuthenticatedUser.isThisUserAuthenticated()) {

        } else {
            return "redirect:/login"
        }
    }*/

    @ModelAttribute
    public void getCommonInfo(Model model) {
        model.addAllAttributes(CommonModel.getCommonModels());
    }
}
