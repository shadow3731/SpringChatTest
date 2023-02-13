package local.chat.springchattest.controller.index;

import local.chat.springchattest.dao.SiteLanguagesMapDAO;
import local.chat.springchattest.dao.UserDAO;
import local.chat.springchattest.entity.User;
import local.chat.springchattest.entity.site.SiteLanguagesMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {

    private UserDAO userDAO;
    private SiteLanguagesMapDAO siteLanguagesMapDAO;

    @Autowired
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Autowired
    public void setSiteLanguagesMapDAO(SiteLanguagesMapDAO siteLanguagesMapDAO) {
        this.siteLanguagesMapDAO = siteLanguagesMapDAO;
    }

    @GetMapping("/")
    public String showIndex(@RequestParam(value = "id") int id,
                            Model model) {
        User user = userDAO.getUser(id);
        SiteLanguagesMap languagesMap = siteLanguagesMapDAO
                .getLanguageMap(user
                        .getSiteConfiguration()
                        .getLanguagesConfiguration()
                        .getLanguageCode());
        model.addAttribute("languages", user
                .getSiteConfiguration()
                .getLanguagesConfiguration()
                .getLanguage());
        model.addAttribute("languageMap", languagesMap);
        return "index";
    }
}
