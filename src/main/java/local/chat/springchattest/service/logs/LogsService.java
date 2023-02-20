package local.chat.springchattest.service.logs;

import local.chat.springchattest.entity.Log;

import java.util.Date;
import java.util.List;

public interface LogsService {

    List<Log> getAllLogs();

    List<Log> getAllLogsByUserId(int id);

    List<Log> getAllLogsByUserNickname(String nickname);

    List<Log> getAllLogsByUserIdAndUserNickname(int id, String nickname);

    List<Log> getAllLogsFrom(Date from);

    List<Log> getAllLogsTill(Date till);

    List<Log> getAllLogsBetween(Date from, Date till);

    List<Log> getAllLogsByUserIdFrom(int id, Date from);

    List<Log> getAllLogsByUserIdTill(int id, Date till);

    List<Log> getAllLogsByUserIdBetween(int id, Date from, Date till);

    List<Log> getAllLogsByUserNicknameFrom(String nickname, Date from);

    List<Log> getAllLogsByUserNicknameTill(String nickname, Date till);

    List<Log> getAllLogsByUserNicknameBetween(String nickname, Date from, Date till);

    List<Log> getAllLogsByUserIdAndUserNicknameFrom(int id, String nickname, Date from);

    List<Log> getAllLogsByUserIdAndUserNicknameTill(int id, String nickname, Date till);

    List<Log> getAllLogsByUserIdAndUserNicknameBetween(int id, String nickname, Date from, Date till);

    void saveLog(Log log);
}
