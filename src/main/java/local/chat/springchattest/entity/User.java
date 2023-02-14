package local.chat.springchattest.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "password")
    private char[] password;

    @Column(name = "authority")
    private String authority;

    public User(int id, String nickname, char[] password, String authority) {
        this.id = id;
        this.nickname = nickname;
        this.password = password;
        this.authority = authority;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", authority='" + authority + '\'' +
                '}';
    }
}
