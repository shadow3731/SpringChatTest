package local.chat.springchattest.controller;

import local.chat.springchattest.entity.Chat;
import local.chat.springchattest.service.chats.ChatsService;
import local.chat.springchattest.service.users.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
public class ChatController {

    private final UsersService usersService;
    private final ChatsService chatsService;

    public ChatController(@Autowired UsersService usersService,
                          @Autowired ChatsService chatsService) {
        this.usersService = usersService;
        this.chatsService = chatsService;
    }

    @GetMapping("/rooms/{id}")
    public String showChatPage(@PathVariable("id") int id,
                              Model model) {
        model.addAttribute("roomId",
                "Chat room " + id);
        model.addAttribute("messages",
                chatsService.getAllMessagesFromRoom(id));
        model.addAttribute("chat", new Chat());
        return "rooms";
    }

    @PostMapping("/rooms/{id}")
    public String addMessage(@PathVariable("id") int id,
                           @ModelAttribute Chat chat,
                           BindingResult bindingResult) {
        chat.setRoomId(id);
        chat.setTimestamp(new Date());
        chatsService.saveMessage(chat);
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
