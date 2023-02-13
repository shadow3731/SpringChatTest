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
}
