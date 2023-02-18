package local.chat.springchattest.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "authorities")
@NoArgsConstructor
@Getter
@Setter
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "codename")
    private String codename;

    @Column(name = "name")
    private String name;

    public Authority(int id, String codename, String name) {
        this.id = id;
        this.codename = codename;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Authority{" +
                "id=" + id +
                ", codename='" + codename + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
