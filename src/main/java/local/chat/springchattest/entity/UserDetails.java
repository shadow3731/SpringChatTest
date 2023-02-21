package local.chat.springchattest.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users_details")
@NoArgsConstructor
@Getter
@Setter
public class UserDetails {

    @Id
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "email")
    private String email;

    @Column(name = "country")
    private String country;

    @Column(name = "age")
    private int age;

    public UserDetails(User user, String email, String country, int age) {
        this.user = user;
        this.email = email;
        this.country = country;
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserDetails{" +
                "user=" + user +
                ", email='" + email + '\'' +
                ", country='" + country + '\'' +
                ", age=" + age +
                '}';
    }
}
