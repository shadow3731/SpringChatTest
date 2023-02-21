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
    public List<Log> getAllLogs() {
        return logsRepository.findAll();
    }

    @Override
    public List<Log> getAllLogsByUserId(int id) {
        return logsRepository.findAllByUser_Id(id);
    }

    @Override
    public List<Log> getAllLogsByUserNickname(String nickname) {
        return logsRepository.findAllByUser_Nickname(nickname);
    }

    @Override
    public List<Log> getAllLogsByUserIdAndUserNickname(int id, String nickname) {
        return logsRepository.findAllByUser_IdAndUser_Nickname(id, nickname);
    }

    @Override
    public List<Log> getAllLogsFrom(Date from) {
        return logsRepository.findAllByTimestampAfter(from);
    }

    @Override
    public List<Log> getAllLogsTill(Date till) {
        return logsRepository.findAllByTimestampBefore(till);
    }

    @Override
    public List<Log> getAllLogsBetween(Date from, Date till) {
        return logsRepository.findAllByTimestampBetween(from, till);
    }

    @Override
    public List<Log> getAllLogsByUserIdFrom(int id, Date from) {
        return logsRepository.findAllByUser_IdAndTimestampAfter(id, from);
    }

    @Override
    public List<Log> getAllLogsByUserIdTill(int id, Date till) {
        return logsRepository.findAllByUser_IdAndTimestampBefore(id, till);
    }

    @Override
    public List<Log> getAllLogsByUserIdBetween(int id, Date from, Date till) {
        return logsRepository.findAllByUser_IdAndTimestampBetween(id, from, till);
    }

    @Override
    public List<Log> getAllLogsByUserNicknameFrom(String nickname, Date from) {
        return logsRepository.findAllByUser_NicknameAndTimestampAfter(nickname, from);
    }

    @Override
    public List<Log> getAllLogsByUserNicknameTill(String nickname, Date till) {
        return logsRepository.findAllByUser_NicknameAndTimestampBefore(nickname, till);
    }

    @Override
    public List<Log> getAllLogsByUserNicknameBetween(String nickname, Date from, Date till) {
        return logsRepository.findAllByUser_NicknameAndTimestampBetween(nickname, from, till);
    }

    @Override
    public List<Log> getAllLogsByUserIdAndUserNicknameFrom(int id, String nickname, Date from) {
        return logsRepository.findAllByUser_IdAndUser_NicknameAndTimestampAfter(id, nickname, from);
    }

    @Override
    public List<Log> getAllLogsByUserIdAndUserNicknameTill(int id, String nickname, Date till) {
        return logsRepository.findAllByUser_IdAndUser_NicknameAndTimestampBefore(id, nickname, till);
    }

    @Override
    public List<Log> getAllLogsByUserIdAndUserNicknameBetween(int id, String nickname, Date from, Date till) {
        return logsRepository.findAllByUser_IdAndUser_NicknameAndTimestampBetween(id, nickname, from, till);
    }

    @Override
    public void saveLog(Log log) {
        logsRepository.save(log);
    }

}
