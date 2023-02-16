package local.chat.springchattest.controller;

import jakarta.validation.Valid;
import local.chat.springchattest.entity.User;
import local.chat.springchattest.service.users.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.Date;

@Controller
public class AuthenticationController {

    private final UsersService usersService;

    public AuthenticationController(@Autowired UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/login")
    public String showAuthenticationPage(@ModelAttribute("user") User user) {
        Authentication authentication = SecurityContextHolder
                .getContext().getAuthentication();
        if (authentication == null ||
                authentication instanceof AnonymousAuthenticationToken) {
            return "login";
        }

        return "redirect:/";
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
                !BCrypt.checkpw(user.getPassword(),
                        Arrays.toString(DBUser.getPassword()))) {
            model.addAttribute("badCredentials",
                    "Bad credentials");
        }

        user.setPassword(null);
        return "redirect:/";
    }

    @ModelAttribute
    public void addCommonInfo(Model model) {
        model.addAttribute("totalUsers",
                usersService.countAllUsers());
        model.addAttribute("serverDateTime",
                new Date());
    }
}
