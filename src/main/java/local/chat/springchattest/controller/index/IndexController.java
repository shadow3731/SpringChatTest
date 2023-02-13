package local.chat.springchattest.controller.index;

import local.chat.springchattest.dao.UserDAO;
import local.chat.springchattest.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {

    private UserDAO userDAO;

    @Autowired
    public void setSiteDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @GetMapping("/")
    public String showIndex(@RequestParam(value = "id") int id,
                            Model model) {
        User user = userDAO.getUser(id);
        model.addAttribute("languages", user
                .getSiteConfiguration()
                .getLanguagesConfiguration()
                .getLanguage());
        return "index";
    }
}
