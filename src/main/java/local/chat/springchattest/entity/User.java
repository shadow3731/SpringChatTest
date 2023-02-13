package local.chat.springchattest.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "users")
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

    @Column(name = "registration_at")
    private Date registrationAt;

    @Column(name = "last_online_at")
    private Date lastOnlineAt;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "configuration_site_id")
    private Site siteConfiguration;

    public User() {
    }

    public User(int id, String nickname, char[] password, String authority, Date registrationAt, Date lastOnlineAt, Site siteConfiguration) {
        this.id = id;
        this.nickname = nickname;
        this.password = password;
        this.authority = authority;
        this.registrationAt = registrationAt;
        this.lastOnlineAt = lastOnlineAt;
        this.siteConfiguration = siteConfiguration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public Date getRegistrationAt() {
        return registrationAt;
    }

    public void setRegistrationAt(Date registrationAt) {
        this.registrationAt = registrationAt;
    }

    public Date getLastOnlineAt() {
        return lastOnlineAt;
    }

    public void setLastOnlineAt(Date lastOnlineAt) {
        this.lastOnlineAt = lastOnlineAt;
    }

    public Site getSiteConfiguration() {
        return siteConfiguration;
    }

    public void setSiteConfiguration(Site siteConfiguration) {
        this.siteConfiguration = siteConfiguration;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", authority='" + authority + '\'' +
                ", registrationAt=" + registrationAt +
                ", lastOnlineAt=" + lastOnlineAt +
                ", siteConfiguration=" + siteConfiguration +
                '}';
    }
}
