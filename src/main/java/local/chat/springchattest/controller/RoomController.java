package local.chat.springchattest.controller;

import local.chat.springchattest.entity.Room;
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

    private final UsersService usersService;
    private final RoomsService roomsService;

    public RoomController(@Autowired UsersService usersService,
                          @Autowired RoomsService roomsService) {
        this.usersService = usersService;
        this.roomsService = roomsService;
    }

    @GetMapping("/rooms/{id}")
    public String showChatPage(@PathVariable("id") int id,
                              Model model) {
        model.addAttribute("roomId",
                "Chat room " + id);
        model.addAttribute("messages",
                roomsService.getAllMessagesFromRoom(id));
        model.addAttribute("chat", new Room());
        return "rooms";
    }

    @PostMapping("/rooms/{id}")
    public String addMessage(@PathVariable("id") int id,
                           @ModelAttribute Room room,
                           BindingResult bindingResult) {
        room.setRoomId(id);
        room.setTimestamp(new Date());
        roomsService.saveMessage(room);
        return "redirect:/rooms/" + id;
    }

    @ModelAttribute
    public void addCommonInfo(Model model) {
        model.addAttribute("totalUsers",
                usersService.countAllUsers());
        model.addAttribute("serverDateTime",
                new Date());
    }
}
