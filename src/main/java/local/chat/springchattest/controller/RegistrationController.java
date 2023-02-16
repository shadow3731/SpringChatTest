package local.chat.springchattest.controller;

import jakarta.validation.Valid;
import local.chat.springchattest.entity.User;
import local.chat.springchattest.service.users.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    private UsersService usersService;

    @Autowired
    public void setUsersService(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/registration")
    public String showRegistrationPage(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    /*@PostMapping("/registration")
    public String addUser(@ModelAttribute("userForm") @Valid User user,
                          BindingResult bindingResult,
                          Model model) {
        if (bindingResult.hasErrors()) {
            return "registration";
        }

        if (!usersService.saveUser(user)) {
            model.addAttribute("nicknameError",
                    "This username already exists");
            return "registration";
        }

        return "redirect:/";
    }*/
}
