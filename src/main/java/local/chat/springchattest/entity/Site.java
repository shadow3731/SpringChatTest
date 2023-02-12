package local.chat.springchattest.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
@Scope("prototype")
public class Site {

    private String language;
    private HashMap<String, String> languageMap;

    public Site() {
    }

    public Site(String language) {
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public HashMap<String, String> getLanguageMap() {
        return languageMap;
    }

    public void setLanguageMap(HashMap<String, String> languageMap) {
        this.languageMap = languageMap;
    }
}
