package local.chat.springchattest.controller;

import jakarta.validation.Valid;
import local.chat.springchattest.entity.User;
import local.chat.springchattest.information.AuthenticatedUser;
import local.chat.springchattest.operation.EncryptionUtils;
import local.chat.springchattest.service.authorities.AuthoritiesService;
import local.chat.springchattest.service.users.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
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
        return "authentication/login";
    }

    @PostMapping("/login")
    public String addAuthentication(@ModelAttribute("user") @Valid User user,
                                      BindingResult bindingResult,
                                      Model model)
            throws Exception {
        if (bindingResult.hasErrors()) {
            return "authentication/login";
        }

        User DBUser = usersService.getUserByNickname(user.getNickname());
        if (DBUser == null ||
                !Objects.equals(user.getNickname(), DBUser.getNickname()) ||
                !Arrays.equals(EncryptionUtils.encrypt(user.getPassword()),
                        DBUser.getPassword())) {
            model.addAttribute("badCredentials",
                    "Bad credentials");
            return "authentication/login";
        }

        user.setId(DBUser.getId());
        user.setPassword(null);
        user.setAuthority(DBUser.getAuthority());

        Map<String, Object> modelsMap = CommonModel.getCommonModels();
        modelsMap.replace("user", user);
        modelsMap.put("totalUsers", usersService.countAllUsers());
        CommonModel.setCommonModels(modelsMap);

        return "redirect:/";
    }

    @GetMapping("/register")
    public String showRegistrationPage() {
        return "authentication/register";
    }

    @PostMapping("/register")
    public String addRegistration(@ModelAttribute("user") @Valid User user,
                                    BindingResult bindingResult,
                                    Model model)
            throws Exception {
        if (bindingResult.hasErrors()) {
            return "authentication/register";
        }

        User DBUser = usersService.getUserByNickname(user.getNickname());
        if (DBUser != null) {
            model.addAttribute("existingUser",
                    "This user already exists");
            return "authentication/register";
        }

        user.setPassword(EncryptionUtils.encrypt(user.getPassword()));
        user.setAuthority(authoritiesService.getAuthorityById(1));
        usersService.saveUser(user);

        user.setPassword(null);
        user.setId(usersService.getUserByNickname(user.getNickname()).getId());

        Map<String, Object> modelsMap = CommonModel.getCommonModels();
        modelsMap.replace("user", user);
        modelsMap.put("totalUsers", usersService.countAllUsers());
        CommonModel.setCommonModels(modelsMap);

        return "redirect:/";
    }

    @GetMapping("/logout")
    public String showLogoutPage() {
        Map<String, Object> modelsMap = CommonModel.getCommonModels();
        modelsMap.replace("user", new User());
        modelsMap.remove("totalUsers");
        CommonModel.setCommonModels(modelsMap);
        return "redirect:/login";
    }

    @ModelAttribute
    public void getCommonInfo(Model model) {
        model.addAllAttributes(CommonModel.getCommonModels());
    }
}
