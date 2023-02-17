package local.chat.springchattest.controller;

import jakarta.validation.Valid;
import local.chat.springchattest.entity.User;
import local.chat.springchattest.service.users.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Objects;

@Controller
public class AuthenticationController {

    private User thisUser = new User();
    private final UsersService usersService;

    public AuthenticationController(@Autowired UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/login")
    public String showAuthenticationPage() {
        return "login";
    }

    @PostMapping("/login")
    public String checkAuthentication(@ModelAttribute("user") @Valid User user,
                                      BindingResult bindingResult,
                                      Model model) {
        if (bindingResult.hasErrors()) {
            return "login";
        }

        User DBUser = usersService.getUserByNickname(user.getNickname());
        if (DBUser == null ||
                !Objects.equals(user.getNickname(), DBUser.getNickname()) ||
                !BCrypt.checkpw(user.getPassword(),
                        DBUser.getPassword())) {
            model.addAttribute("badCredentials",
                    "Bad credentials");
        }

        thisUser = user;
        thisUser.setPassword(null);
        return "redirect:/";
    }

    @ModelAttribute
    public void addCommonInfo(Model model) {
        model.addAttribute("user", thisUser);
        model.addAttribute("totalUsers",
                usersService.countAllUsers());
        model.addAttribute("serverDateTime",
                new Date());
    }
}
