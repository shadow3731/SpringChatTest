package local.chat.springchattest.entity;

import jakarta.persistence.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Entity
@Table(name = "users_site_configuration")
public class Site {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "language_id")
    private int language_id;

    public Site() {
    }

    public Site(int id, int language_id) {
        this.id = id;
        this.language_id = language_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLanguage_id() {
        return language_id;
    }

    public void setLanguage_id(int language_id) {
        this.language_id = language_id;
    }

    @Override
    public String toString() {
        return "Site{" +
                "id=" + id +
                ", language_id=" + language_id +
                '}';
    }
}
