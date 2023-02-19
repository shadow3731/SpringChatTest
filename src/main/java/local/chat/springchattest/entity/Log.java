package local.chat.springchattest.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "logs")
@NoArgsConstructor
@Getter
@Setter
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "timestamp")
    private Date timestamp;

    @Column(name = "action")
    private String actionName;

    @Column(name = "description")
    private String actionDescription;

    public Log(int id, User user, Date timestamp, String actionName, String actionDescription) {
        this.id = id;
        this.user = user;
        this.timestamp = timestamp;
        this.actionName = actionName;
        this.actionDescription = actionDescription;
    }

    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", user=" + user +
                ", timestamp=" + timestamp +
                ", actionName='" + actionName + '\'' +
                ", actionDescription='" + actionDescription + '\'' +
                '}';
    }
}
