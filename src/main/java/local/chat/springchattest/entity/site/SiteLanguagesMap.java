package local.chat.springchattest.entity.site;

import jakarta.persistence.*;

import java.util.Map;

@Entity
@Table(name = "site_configuration_languages_texts")
public class SiteLanguagesMap {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @ElementCollection(fetch = FetchType.LAZY)
    private Map<String, String> languagesMap;

    public SiteLanguagesMap() {
    }

    public SiteLanguagesMap(Map<String, String> languagesMap) {
        this.languagesMap = languagesMap;
    }

    public SiteLanguagesMap(int id, String name, Map<String, String> languagesMap) {
        this.id = id;
        this.name = name;
        this.languagesMap = languagesMap;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, String> getLanguagesMap() {
        return languagesMap;
    }

    public void setLanguagesMap(Map<String, String> languagesMap) {
        this.languagesMap = languagesMap;
    }

    @Override
    public String toString() {
        return "SiteLanguagesMap{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", languagesMap=" + languagesMap +
                '}';
    }
}
