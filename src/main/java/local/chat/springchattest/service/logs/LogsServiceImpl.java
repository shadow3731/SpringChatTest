package local.chat.springchattest.service.logs;

import local.chat.springchattest.entity.Log;
import local.chat.springchattest.repository.LogsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class LogsServiceImpl implements LogsService {

    private LogsRepository logsRepository;

    @Autowired
    public void setLogsRepository(LogsRepository logsRepository) {
        this.logsRepository = logsRepository;
    }


    @Override
    public List<Log> getAllLogsByIdBetween(long initId, long endId) {
        return logsRepository.findAllByIdBetween(initId, endId);
    }

    @Override
    public List<Log> getAllLogsByUserIdAndByIdBetween(int id, long initId, long endId) {
        return logsRepository.findAllByUser_IdAndIdBetween(id, initId, endId);
    }

    @Override
    public List<Log> getAllLogsByUserNicknameAndByIdBetween(String nickname, long initId, long endId) {
        return logsRepository.findAllByUser_NicknameAndIdBetween(nickname, initId, endId);
    }

    @Override
    public List<Log> getAllLogsByUserIdAndUserNicknameAndByIdBetween(int id, String nickname, long initId, long endId) {
        return logsRepository.findAllByUser_IdAndUser_NicknameAndIdBetween(id, nickname, initId, endId);
    }

    @Override
    public List<Log> getAllLogsFromAndByIdBetween(Date from, long initId, long endId) {
        return logsRepository.findAllByTimestampAfterAndIdBetween(from, initId, endId);
    }

    @Override
    public List<Log> getAllLogsTillAndByIdBetween(Date till, long initId, long endId) {
        return logsRepository.findAllByTimestampBeforeAndIdBetween(till, initId, endId);
    }

    @Override
    public List<Log> getAllLogsBetweenAndByIdBetween(Date from, Date till, long initId, long endId) {
        return logsRepository.findAllByTimestampBetweenAndIdBetween(from, till, initId, endId);
    }

    @Override
    public List<Log> getAllLogsByUserIdFromAndByIdBetween(int id, Date from, long initId, long endId) {
        return logsRepository.findAllByUser_IdAndTimestampAfterAndIdBetween(id, from, initId, endId);
    }

    @Override
    public List<Log> getAllLogsByUserIdTillAndByIdBetween(int id, Date till, long initId, long endId) {
        return logsRepository.findAllByUser_IdAndTimestampBeforeAndIdBetween(id, till, initId, endId);
    }

    @Override
    public List<Log> getAllLogsByUserIdBetweenAndByIdBetween(int id, Date from, Date till, long initId, long endId) {
        return logsRepository.findAllByUser_IdAndTimestampBetweenAndIdBetween(id, from, till, initId, endId);
    }

    @Override
    public List<Log> getAllLogsByUserNicknameFromAndByIdBetween(String nickname, Date from, long initId, long endId) {
        return logsRepository.findAllByUser_NicknameAndTimestampAfterAndIdBetween(nickname, from, initId, endId);
    }

    @Override
    public List<Log> getAllLogsByUserNicknameTillAndByIdBetween(String nickname, Date till, long initId, long endId) {
        return logsRepository.findAllByUser_NicknameAndTimestampBeforeAndIdBetween(nickname, till, initId, endId);
    }

    @Override
    public List<Log> getAllLogsByUserNicknameBetweenAndByIdBetween(String nickname, Date from, Date till, long initId, long endId) {
        return logsRepository.findAllByUser_NicknameAndTimestampBetweenAndIdBetween(nickname, from, till, initId, endId);
    }

    @Override
    public List<Log> getAllLogsByUserIdAndUserNicknameFromAndByIdBetween(int id, String nickname, Date from, long initId, long endId) {
        return logsRepository.findAllByUser_IdAndUser_NicknameAndTimestampAfterAndIdBetween(id, nickname, from, initId, endId);
    }

    @Override
    public List<Log> getAllLogsByUserIdAndUserNicknameTillAndByIdBetween(int id, String nickname, Date till, long initId, long endId) {
        return logsRepository.findAllByUser_IdAndUser_NicknameAndTimestampBeforeAndIdBetween(id, nickname, till, initId, endId);
    }

    @Override
    public List<Log> getAllLogsByUserIdAndUserNicknameBetweenAndByIdBetween(int id, String nickname, Date from, Date till, long initId, long endId) {
        return logsRepository.findAllByUser_IdAndUser_NicknameAndTimestampBetweenAndIdBetween(id, nickname, from, till, initId, endId);
    }

    @Override
    public long countAllLogs() {
        return logsRepository.count();
    }

    @Override
    public long countAllLogsByUserId(int userId) {
        return logsRepository.countAllByUser_Id(userId);
    }

    @Override
    public long countAllLogsByUserNickname(String userNickname) {
        return logsRepository.countAllByUser_Nickname(userNickname);
    }

    @Override
    public long countAllLogsByUserIdAndUserNickname(int userId, String userNickname) {
        return logsRepository.countAllByUser_IdAndUser_Nickname(userId, userNickname);
    }

    @Override
    public long countAllLogsFrom(Date from) {
        return logsRepository.countAllByTimestampAfter(from);
    }

    @Override
    public long countAllLogsTill(Date till) {
        return logsRepository.countAllByTimestampBefore(till);
    }

    @Override
    public long countAllLogsBetween(Date from, Date till) {
        return logsRepository.countAllByTimestampBetween(from, till);
    }

    @Override
    public long countAllLogsByUserIdFrom(int userId, Date from) {
        return logsRepository.countAllByUser_IdAndTimestampAfter(userId, from);
    }

    @Override
    public long countAllLogsByUserIdTill(int userId, Date till) {
        return logsRepository.countAllByUser_IdAndTimestampBefore(userId, till);
    }

    @Override
    public long countAllLogsByUserIdBetween(int userId, Date from, Date till) {
        return logsRepository.countAllByUser_IdAndTimestampBetween(userId, from, till);
    }

    @Override
    public long countAllLogsByUserNicknameFrom(String userNickname, Date from) {
        return logsRepository.countAllByUser_NicknameAndTimestampAfter(userNickname, from);
    }

    @Override
    public long countAllLogsByUserNicknameTill(String userNickname, Date till) {
        return logsRepository.countAllByUser_NicknameAndTimestampBefore(userNickname, till);
    }

    @Override
    public long countAllLogsByUserNicknameBetween(String userNickname, Date from, Date till) {
        return logsRepository.countAllByUser_NicknameAndTimestampBetween(userNickname, from, till);
    }

    @Override
    public long countAllLogsByUserIdAndUserFrom(int userId, String userNickname, Date from) {
        return logsRepository.countAllByUser_IdAndUser_NicknameAndTimestampAfter(userId, userNickname, from);
    }

    @Override
    public long countAllLogsByUserIdAndUserTill(int userId, String userNickname, Date till) {
        return logsRepository.countAllByUser_IdAndUser_NicknameAndTimestampBefore(userId, userNickname, till);
    }

    @Override
    public long countAllLogsByUserIdAndUserBetween(int userId, String userNickname, Date from, Date till) {
        return logsRepository.countAllByUser_IdAndUser_NicknameAndTimestampBetween(userId, userNickname, from, till);
    }

    @Override
    public void saveLog(Log log) {
        logsRepository.save(log);
    }

}
