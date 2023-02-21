package local.chat.springchattest.operation;

import local.chat.springchattest.entity.Log;
import local.chat.springchattest.service.logs.LogsService;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Component
@NoArgsConstructor
public class LogsReader {

    public List<Log> returnLogs(LogsService logsService, String id, String nickname, String from, String till) throws ParseException {
        if (isBlank(id)) {
            if (isBlank(nickname)) {
                if (isBlank(from)) {
                    if (isBlank(till)) {
                        return logsService.getAllLogs();
                    } else {
                        Date tillDate = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(till.replace("T", " "));
                        return logsService.getAllLogsTill(tillDate);
                    }
                } else {
                    Date fromDate = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(from.replace("T", " "));
                    if (isBlank(till)) {
                        return logsService.getAllLogsFrom(fromDate);
                    } else {
                        Date tillDate = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(till.replace("T", " "));
                        return logsService.getAllLogsBetween(fromDate, tillDate);
                    }
                }
            } else {
                if (isBlank(from)) {
                    if (isBlank(till)) {
                        return logsService.getAllLogsByUserNickname(nickname);
                    } else {
                        Date tillDate = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(till.replace("T", " "));
                        return logsService.getAllLogsByUserNicknameTill(nickname, tillDate);
                    }
                } else {
                    Date fromDate = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(from.replace("T", " "));
                    if (isBlank(till)) {
                        return logsService.getAllLogsByUserNicknameFrom(nickname, fromDate);
                    } else {
                        Date tillDate = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(till.replace("T", " "));
                        return logsService.getAllLogsByUserNicknameBetween(nickname, fromDate, tillDate);
                    }
                }
            }
        } else {
            if (isBlank(nickname)) {
                if (isBlank(from)) {
                    if (isBlank(till)) {
                        return logsService.getAllLogsByUserId(Integer.parseInt(id));
                    } else {
                        Date tillDate = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(till.replace("T", " "));
                        return logsService.getAllLogsByUserIdTill(Integer.parseInt(id), tillDate);
                    }
                } else {
                    Date fromDate = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(from.replace("T", " "));
                    if (isBlank(till)) {
                        return logsService.getAllLogsByUserIdFrom(Integer.parseInt(id), fromDate);
                    } else {
                        Date tillDate = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(till.replace("T", " "));
                        return logsService.getAllLogsByUserIdBetween(Integer.parseInt(id), fromDate, tillDate);
                    }
                }
            } else {
                if (isBlank(from)) {
                    if (isBlank(till)) {
                        return logsService.getAllLogsByUserIdAndUserNickname(Integer.parseInt(id), nickname);
                    } else {
                        Date tillDate = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(till.replace("T", " "));
                        return logsService.getAllLogsByUserIdAndUserNicknameTill(Integer.parseInt(id), nickname, tillDate);
                    }
                } else {
                    Date fromDate = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(from.replace("T", " "));
                    if (isBlank(till)) {
                        return logsService.getAllLogsByUserIdAndUserNicknameFrom(Integer.parseInt(id), nickname, fromDate);
                    } else {
                        Date tillDate = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(till.replace("T", " "));
                        return logsService.getAllLogsByUserIdAndUserNicknameBetween(Integer.parseInt(id), nickname, fromDate, tillDate);
                    }
                }
            }
        }
    }

    private boolean isBlank(String object) {
        return  object == null || Objects.equals(object, "");
    }
}
