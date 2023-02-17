package local.chat.springchattest.controller;

import jakarta.validation.Valid;
import local.chat.springchattest.entity.User;
import local.chat.springchattest.service.users.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Objects;

@Controller
public class AuthenticationController {

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
                !Objects.equals(user.getPassword(), DBUser.getPassword())) {
            model.addAttribute("badCredentials",
                    "Bad credentials");
            return "login";
        }

        user.setPassword(null);
        user.setAuthority(DBUser.getAuthority());
        changeModelMap(user);

        return "redirect:/";
    }

    @ModelAttribute
    public void addCommonInfo(Model model) {
        model.addAllAttributes(CommonModel.getCommonModels());
    }

    private void changeModelMap(User user) {
        Map<String, Object> modelsMap = CommonModel.getCommonModels();
        modelsMap.replace("user", user);
        modelsMap.put("totalUsers", usersService.countAllUsers());
        CommonModel.setCommonModels(modelsMap);
    }
}
