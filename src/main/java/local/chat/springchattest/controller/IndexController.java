package local.chat.springchattest.controller;

import local.chat.springchattest.service.users.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Date;

@Controller
public class IndexController {

    private final UsersService usersService;

    public IndexController(@Autowired UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/")
    public String showIndexPage() {
        return "index";
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
