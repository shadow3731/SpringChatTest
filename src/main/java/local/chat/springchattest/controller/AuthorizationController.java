package local.chat.springchattest.controller;

import local.chat.springchattest.service.users.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Date;

@Controller
public class AuthorizationController {

    private final UsersService usersService;

    public AuthorizationController(@Autowired UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/login")
    public String showAuthorizationPage() {
        return "login";
    }

    @ModelAttribute
    public void addCommonInfo(Model model) {
        model.addAttribute("totalUsers",
                usersService.countAllUsers());
        model.addAttribute("serverDateTime",
                new Date());
    }
}
