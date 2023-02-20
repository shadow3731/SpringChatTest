package local.chat.springchattest.controller;

import local.chat.springchattest.information.AuthenticatedUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class IndexController {

    @GetMapping("/")
    public String showIndexPage() {
        if (AuthenticatedUser.isThisUserAuthenticated()) {
            return "index";
        } else {
            return "redirect:/login";
        }
    }

    @ModelAttribute
    public void getCommonInfo(Model model) {
        model.addAllAttributes(CommonModel.getCommonModels());
    }
}
