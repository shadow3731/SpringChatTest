package local.chat.springchattest.information;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@Getter
@Setter
public class LogsListRequest {

    private final int LOGS_AMOUNT_ON_PAGE = 50;
    private long pageId = 1;
    private String userId;
    private String userNickname;
    private String from;
    private String till;

    public LogsListRequest(int pageId, String userId, String userNickname, String from, String till) {
        this.pageId = pageId;
        this.userId = userId;
        this.userNickname = userNickname;
        this.from = from;
        this.till = till;
    }

    @Override
    public String toString() {
        return "LogsList{" +
                "pageId=" + pageId +
                ", userId=" + userId +
                ", userNickname='" + userNickname + '\'' +
                ", from=" + from +
                ", till=" + till +
                '}';
    }
}
