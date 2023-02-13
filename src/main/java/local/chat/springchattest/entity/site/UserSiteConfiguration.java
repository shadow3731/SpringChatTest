package local.chat.springchattest.entity.site;

import jakarta.persistence.*;

import java.util.Map;

@Entity
@Table(name = "users_site_configuration")
public class UserSiteConfiguration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToOne
    @JoinColumn(name = "language_id")
    private SiteLanguagesConfiguration languagesConfiguration;

    public UserSiteConfiguration() {
    }
}
