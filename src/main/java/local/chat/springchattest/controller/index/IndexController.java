package local.chat.springchattest.controller.index;

import local.chat.springchattest.dao.SiteDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {

    private SiteDAO siteDAO;

    @Autowired
    public void setSiteDAO(SiteDAO siteDAO) {
        this.siteDAO = siteDAO;
    }

    @GetMapping("/")
    public String showIndex(@RequestParam(value = "lang", required = false) String lang,
                            Model model) {
        model.addAttribute("languages", siteDAO.getConfigurations(lang));
        model.addAttribute("languagesMap", );
        return "index";
    }
}
