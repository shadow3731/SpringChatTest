package local.chat.springchattest.entity;

import jakarta.persistence.Entity;

@Entity
public class Site {

    private String language;

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
}
