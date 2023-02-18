package local.chat.springchattest.controller;

import jakarta.validation.Valid;
import local.chat.springchattest.entity.User;
import local.chat.springchattest.service.authorities.AuthoritiesService;
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

    private UsersService usersService;
    private AuthoritiesService authoritiesService;

    @Autowired
    public void setUsersService(UsersService usersService) {
        this.usersService = usersService;
    }

    @Autowired
    public void setAuthoritiesService(AuthoritiesService authoritiesService) {
        this.authoritiesService = authoritiesService;
    }

    @GetMapping("/login")
    public String showAuthenticationPage() {
        if (CommonModel.isThisUserAuthenticated()) {
            return "redirect:/";
        } else {
            return "login";
        }
    }

    @PostMapping("/login")
    public String checkAuthentication(@ModelAttribute("user") @Valid User user,
                                      BindingResult bindingResult,
                                      Model model) {
        if (!CommonModel.isThisUserAuthenticated()) {
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

            Map<String, Object> modelsMap = CommonModel.getCommonModels();
            modelsMap.replace("user", user);
            modelsMap.put("totalUsers", usersService.countAllUsers());
            CommonModel.setCommonModels(modelsMap);
        }

        return "redirect:/";
    }

    @GetMapping("/register")
    public String showRegistrationPage() {
        if (CommonModel.isThisUserAuthenticated()) {
            return "redirect:/";
        } else {
            return "register";
        }
    }

    @PostMapping("/register")
    public String checkRegistration(@ModelAttribute("user") @Valid User user,
                                    BindingResult bindingResult,
                                    Model model) {
        if (!CommonModel.isThisUserAuthenticated()) {
            if (bindingResult.hasErrors()) {
                return "register";
            }

            User DBUser = usersService.getUserByNickname(user.getNickname());
            if (DBUser != null) {
                model.addAttribute("existingUser",
                        "This user already exists");
                return "register";
            }

            user.setAuthority(authoritiesService.getAuthorityById(1));
            usersService.saveUser(user);
            user.setPassword(null);


            Map<String, Object> modelsMap = CommonModel.getCommonModels();
            modelsMap.replace("user", user);
            modelsMap.put("totalUsers", usersService.countAllUsers());
            CommonModel.setCommonModels(modelsMap);
        }

        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout() {
        Map<String, Object> modelsMap = CommonModel.getCommonModels();
        modelsMap.replace("user", new User());
        modelsMap.remove("totalUsers");
        CommonModel.setCommonModels(modelsMap);
        return "redirect:/login";
    }

    @ModelAttribute
    public void addCommonInfo(Model model) {
        model.addAllAttributes(CommonModel.getCommonModels());
    }
}
