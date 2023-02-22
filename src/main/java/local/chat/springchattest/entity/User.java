package local.chat.springchattest.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
    @NotBlank(message = "Nickname can't be blank")
    @Size(min = 3,
            max = 30,
            message = "Nickname must be between 3 and 30 symbols")
    private String nickname;

    @Column(name = "password")
    @Size(min = 6,
            max = 50,
            message = "Password must be between 6 and 50 symbols")
    private byte[] password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "authority_id")
    private Authority authority;

    public User(int id, String nickname, @Size(min = 6,
            max = 50,
            message = "Password must be between 6 and 50 symbols") byte[] password, Authority authority) {
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
                ", authority=" + authority +
                '}';
    }
}
