package local.chat.springchattest.service.logs;

import local.chat.springchattest.entity.Log;

import java.util.Date;
import java.util.List;

public interface LogsService {

    List<Log> getAllLogsByIdBetween(long initId, long endId);

    List<Log> getAllLogsByUserIdAndByIdBetween(int id, long initId, long endId);

    List<Log> getAllLogsByUserNicknameAndByIdBetween(String nickname, long initId, long endId);

    List<Log> getAllLogsByUserIdAndUserNicknameAndByIdBetween(int id, String nickname, long initId, long endId);

    List<Log> getAllLogsFromAndByIdBetween(Date from, long initId, long endId);

    List<Log> getAllLogsTillAndByIdBetween(Date till, long initId, long endId);

    List<Log> getAllLogsBetweenAndByIdBetween(Date from, Date till, long initId, long endId);

    List<Log> getAllLogsByUserIdFromAndByIdBetween(int id, Date from, long initId, long endId);

    List<Log> getAllLogsByUserIdTillAndByIdBetween(int id, Date till, long initId, long endId);

    List<Log> getAllLogsByUserIdBetweenAndByIdBetween(int id, Date from, Date till, long initId, long endId);

    List<Log> getAllLogsByUserNicknameFromAndByIdBetween(String nickname, Date from, long initId, long endId);

    List<Log> getAllLogsByUserNicknameTillAndByIdBetween(String nickname, Date till, long initId, long endId);

    List<Log> getAllLogsByUserNicknameBetweenAndByIdBetween(String nickname, Date from, Date till, long initId, long endId);

    List<Log> getAllLogsByUserIdAndUserNicknameFromAndByIdBetween(int id, String nickname, Date from, long initId, long endId);

    List<Log> getAllLogsByUserIdAndUserNicknameTillAndByIdBetween(int id, String nickname, Date till, long initId, long endId);

    List<Log> getAllLogsByUserIdAndUserNicknameBetweenAndByIdBetween(int id, String nickname, Date from, Date till, long initId, long endId);

    void saveLog(Log log);
}
