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
    public void saveLog(Log log) {
        logsRepository.save(log);
    }

}
