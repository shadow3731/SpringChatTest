package local.chat.springchattest.entity.site;

import jakarta.persistence.*;

@Entity
@Table(name = "site_configuration_languages")
public class SiteLanguagesConfiguration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "language")
    private String language;

    @Column(name = "code")
    private String languageCode;

    @OneToOne(mappedBy = "languagesConfiguration",
            cascade = CascadeType.ALL)
    private UserSiteConfiguration siteConfiguration;

    public SiteLanguagesConfiguration() {
    }

    public SiteLanguagesConfiguration(int id, String language, String languageCode, UserSiteConfiguration siteConfiguration) {
        this.id = id;
        this.language = language;
        this.languageCode = languageCode;
        this.siteConfiguration = siteConfiguration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    public UserSiteConfiguration getSiteConfiguration() {
        return siteConfiguration;
    }

    public void setSiteConfiguration(UserSiteConfiguration siteConfiguration) {
        this.siteConfiguration = siteConfiguration;
    }

    @Override
    public String toString() {
        return "SiteLanguagesConfiguration{" +
                "id=" + id +
                ", language='" + language + '\'' +
                ", languageCode='" + languageCode + '\'' +
                ", siteConfiguration=" + siteConfiguration +
                '}';
    }
}
