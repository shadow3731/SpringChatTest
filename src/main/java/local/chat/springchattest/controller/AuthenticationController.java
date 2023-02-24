package local.chat.springchattest.controller;

import jakarta.validation.Valid;
import local.chat.springchattest.entity.User;
import local.chat.springchattest.factory.UserFactory;
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
    private UserFactory userFactory;

    @Autowired
    public void setUsersService(UsersService usersService) {
        this.usersService = usersService;
    }

    @Autowired
    public void setAuthoritiesService(AuthoritiesService authoritiesService) {
        this.authoritiesService = authoritiesService;
    }

    @Autowired
    public void setUserFactory(UserFactory userFactory) {
        this.userFactory = userFactory;
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
        System.out.println(userFactory.getCurrentUser());
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

        userFactory.getCurrentUser().setId(DBUser.getId());
        userFactory.getCurrentUser().setPassword(null);
        userFactory.getCurrentUser().setAuthority(DBUser.getAuthority());

        changeCommonModel();



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

        userFactory.getCurrentUser().setPassword(EncryptionUtils.encrypt(user.getPassword()));
        userFactory.getCurrentUser().setAuthority(authoritiesService.getAuthorityById(1));

        usersService.saveUser(user);

        userFactory.getCurrentUser().setPassword(null);
        userFactory.getCurrentUser().setId(usersService.getUserByNickname(user.getNickname()).getId());

        changeCommonModel();

        return "redirect:/";
    }

    @GetMapping("/logout")
    public String showLogoutPage() {
        Map<String, Object> modelsMap = CommonModel.getCommonModels();
        modelsMap.remove("onlineUsers");
        modelsMap.remove("totalUsers");
        CommonModel.setCommonModels(modelsMap);

        userFactory.removeCurrentUser();

        return "redirect:/login";
    }

    @ModelAttribute
    public void getCommonInfo(Model model) {
        model.addAllAttributes(CommonModel.getCommonModels());
        model.addAttribute("user", userFactory.getCurrentUser());
    }

    private void changeCommonModel() {
        Map<String, Object> modelsMap = CommonModel.getCommonModels();
        modelsMap.put("totalOnline", usersService.countAllUsersOnline());
        modelsMap.put("totalUsers", usersService.countAllUsers());
        CommonModel.setCommonModels(modelsMap);
    }
}
