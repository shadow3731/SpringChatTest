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

    long countAllLogs();

    long countAllLogsByUserId(int userId);

    long countAllLogsByUserNickname(String userNickname);

    long countAllLogsByUserIdAndUserNickname(int userId, String userNickname);

    long countAllLogsFrom(Date from);

    long countAllLogsTill(Date till);

    long countAllLogsBetween(Date from, Date till);

    long countAllLogsByUserIdFrom(int userId, Date from);

    long countAllLogsByUserIdTill(int userId, Date till);

    long countAllLogsByUserIdBetween(int userId, Date from, Date till);

    long countAllLogsByUserNicknameFrom(String userNickname, Date from);

    long countAllLogsByUserNicknameTill(String userNickname, Date till);

    long countAllLogsByUserNicknameBetween(String userNickname, Date from, Date till);

    long countAllLogsByUserIdAndUserFrom(int userId, String userNickname, Date from);

    long countAllLogsByUserIdAndUserTill(int userId, String userNickname, Date till);

    long countAllLogsByUserIdAndUserBetween(int userId, String userNickname, Date from, Date till);

    void saveLog(Log log);
}
