package local.chat.springchattest.repository;

import local.chat.springchattest.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface LogsRepository extends JpaRepository<Log, Long> {

    List<Log> findAll();

    List<Log> findAllByUser_Id(int userId);

    List<Log> findAllByUser_Nickname(String userNickname);

    List<Log> findAllByUser_IdAndUser_Nickname(int userId, String userNickname);

    List<Log> findAllByTimestampAfter(Date from);

    List<Log> findAllByTimestampBefore(Date till);

    List<Log> findAllByTimestampBetween(Date from, Date till);

    List<Log> findAllByUser_IdAndTimestampAfter(int userId, Date from);

    List<Log> findAllByUser_IdAndTimestampBefore(int userId, Date till);

    List<Log> findAllByUser_IdAndTimestampBetween(int userId, Date from, Date till);

    List<Log> findAllByUser_NicknameAndTimestampAfter(String userNickname, Date from);

    List<Log> findAllByUser_NicknameAndTimestampBefore(String userNickname, Date till);

    List<Log> findAllByUser_NicknameAndTimestampBetween(String userNickname, Date from, Date till);

    List<Log> findAllByUser_IdAndUser_NicknameAndTimestampAfter(int userId, String userNickname, Date from);

    List<Log> findAllByUser_IdAndUser_NicknameAndTimestampBefore(int userId, String userNickname, Date till);

    List<Log> findAllByUser_IdAndUser_NicknameAndTimestampBetween(int userId, String userNickname, Date from, Date till);
}
