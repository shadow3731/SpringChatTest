package local.chat.springchattest.entity.site;

import jakarta.persistence.*;

@Entity
@Table(name = "users_site_configuration")
public class UserSiteConfiguration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "language_id")
    private SiteLanguagesConfiguration languagesConfiguration;

    public UserSiteConfiguration() {
    }

    public UserSiteConfiguration(int id, SiteLanguagesConfiguration languagesConfiguration) {
        this.id = id;
        this.languagesConfiguration = languagesConfiguration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SiteLanguagesConfiguration getLanguagesConfiguration() {
        return languagesConfiguration;
    }

    public void setLanguagesConfiguration(SiteLanguagesConfiguration languagesConfiguration) {
        this.languagesConfiguration = languagesConfiguration;
    }

    @Override
    public String toString() {
        return "UserSiteConfiguration{" +
                "id=" + id +
                ", languagesConfiguration=" + languagesConfiguration +
                '}';
    }
}
