package local.chat.springchattest.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "messages")
@NoArgsConstructor
@Getter
@Setter
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "room_id")
    private int roomId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private User user;

    @Column(name = "timestamp")
    private Date timestamp;

    @Column(name = "message")
    @NotBlank
    @Size(min = 2,
            max = 1500,
            message = "Message must be between 2 and 1500 symbols in length")
    private String message;

    public Message(int id, int roomId, User user, Date timestamp, String message) {
        this.id = id;
        this.roomId = roomId;
        this.user = user;
        this.timestamp = timestamp;
        this.message = message;
    }

    @Override
    public String toString() {
        return "Chat{" +
                "id=" + id +
                ", roomId=" + roomId +
                ", user=" + user +
                ", timestamp=" + timestamp +
                ", message='" + message + '\'' +
                '}';
    }
}
