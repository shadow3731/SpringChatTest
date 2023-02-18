package local.chat.springchattest.controller;

import jakarta.validation.Valid;
import local.chat.springchattest.entity.Message;
import local.chat.springchattest.entity.User;
import local.chat.springchattest.service.chats.RoomsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
public class RoomController {

    private RoomsService roomsService;

    @Autowired
    public void setRoomsService(RoomsService roomsService) {
        this.roomsService = roomsService;
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
            message.setUser((User) CommonModel.getCommonModels().get("user"));
            message.setTimestamp(new Date());
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
