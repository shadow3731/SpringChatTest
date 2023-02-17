package local.chat.springchattest.controller;

import local.chat.springchattest.service.users.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class IndexController {

    private final UsersService usersService;

    public IndexController(@Autowired UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/")
    public String showIndexPage() {
        if (CommonModel.isThisUserAuthenticated()) {
            return "index";
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("/users")
    public String showUsersPage(Model model) {
        if (CommonModel.isThisUserAuthenticated()) {
            model.addAttribute("users",
                    usersService.getAllUsers());
            return "users";
        } else {
            return "redirect:/login";
        }

    }

    @ModelAttribute
    public void addCommonInfo(Model model) {
        model.addAllAttributes(CommonModel.getCommonModels());
    }
}
