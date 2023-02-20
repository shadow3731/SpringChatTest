package local.chat.springchattest.controller;

import local.chat.springchattest.information.AuthenticatedUser;
import local.chat.springchattest.service.users.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class UserController {

    private UsersService usersService;

    @Autowired
    public void setUsersService(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/users")
    public String showUsersPage(Model model) {
        if (AuthenticatedUser.isThisUserAuthenticated()) {
            model.addAttribute("users",
                    usersService.getAllUsers());
            return "users/users";
        } else {
            return "redirect:/login";
        }
    }

    @ModelAttribute
    public void getCommonInfo(Model model) {
        model.addAllAttributes(CommonModel.getCommonModels());
    }
}
