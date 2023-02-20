package local.chat.springchattest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class IndexController {

    @GetMapping("/")
    public String showIndexPage() {
        return "index";
    }

    @ModelAttribute
    public void addCommonInfo(Model model) {
        model.addAllAttributes(CommonModel.getCommonModels());
    }
}
