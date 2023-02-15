package local.chat.springchattest.controller;

import local.chat.springchattest.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;

@Controller
public class ChatController {

    private UsersService usersService;

    @Autowired
    public void setUsersService(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/")
    public String showIndexPage() {
        return "index";
    }

    @GetMapping("/rooms/{id}")
    public String enterToChat(@PathVariable("id") int id,
                              Model model) {
        model.addAttribute("roomId",
                "Chat room " + id);
        return "rooms";
    }

    @GetMapping("/users")
    public String showUsersPage(Model model) {
        model.addAttribute("users",
                usersService.getAllUsers());
        return "users";
    }

    @ModelAttribute
    public void addCommonInfo(Model model) {
        model.addAttribute("totalUsers",
                usersService.countAllUsers());
        model.addAttribute("serverDateTime",
                new Date());
    }
}
