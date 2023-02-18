package local.chat.springchattest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class AdminController {

    @GetMapping("/admin")
    public String getAdminRoomPage() {
        if (CommonModel.isThisUserAuthenticated() &&
                CommonModel.getThisUserIdAuthority() > 1) {
            return "admin";
        } else {
            return "redirect:/";
        }
    }

    @ModelAttribute
    public void addCommonInfo(Model model) {
        model.addAllAttributes(CommonModel.getCommonModels());
    }
}
