package local.chat.springchattest.repository;

import local.chat.springchattest.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface LogsRepository extends JpaRepository<Log, Long> {

    List<Log> findAllByIdBetween(long initId, long endId);

    List<Log> findAllByUser_IdAndIdBetween(int userId, long initId, long endId);

    List<Log> findAllByUser_NicknameAndIdBetween(String userNickname, long initId, long endId);

    List<Log> findAllByUser_IdAndUser_NicknameAndIdBetween(int userId, String userNickname, long initId, long endId);

    List<Log> findAllByTimestampAfterAndIdBetween(Date from, long initId, long endId);

    List<Log> findAllByTimestampBeforeAndIdBetween(Date till, long initId, long endId);

    List<Log> findAllByTimestampBetweenAndIdBetween(Date from, Date till, long initId, long endId);

    List<Log> findAllByUser_IdAndTimestampAfterAndIdBetween(int userId, Date from, long initId, long endId);

    List<Log> findAllByUser_IdAndTimestampBeforeAndIdBetween(int userId, Date till, long initId, long endId);

    List<Log> findAllByUser_IdAndTimestampBetweenAndIdBetween(int userId, Date from, Date till, long initId, long endId);

    List<Log> findAllByUser_NicknameAndTimestampAfterAndIdBetween(String userNickname, Date from, long initId, long endId);

    List<Log> findAllByUser_NicknameAndTimestampBeforeAndIdBetween(String userNickname, Date till, long initId, long endId);

    List<Log> findAllByUser_NicknameAndTimestampBetweenAndIdBetween(String userNickname, Date from, Date till, long initId, long endId);

    List<Log> findAllByUser_IdAndUser_NicknameAndTimestampAfterAndIdBetween(int userId, String userNickname, Date from, long initId, long endId);

    List<Log> findAllByUser_IdAndUser_NicknameAndTimestampBeforeAndIdBetween(int userId, String userNickname, Date till, long initId, long endId);

    List<Log> findAllByUser_IdAndUser_NicknameAndTimestampBetweenAndIdBetween(int userId, String userNickname, Date from, Date till, long initId, long endId);

    long countAllByUser_Id(int userId);

    long countAllByUser_Nickname(String userNickname);

    long countAllByUser_IdAndUser_Nickname(int userId, String userNickname);

    long countAllByTimestampAfter(Date from);

    long countAllByTimestampBefore(Date till);

    long countAllByTimestampBetween(Date from, Date till);

    long countAllByUser_IdAndTimestampAfter(int userId, Date from);

    long countAllByUser_IdAndTimestampBefore(int userId, Date till);

    long countAllByUser_IdAndTimestampBetween(int userId, Date from, Date till);

    long countAllByUser_NicknameAndTimestampAfter(String userNickname, Date from);

    long countAllByUser_NicknameAndTimestampBefore(String userNickname, Date till);

    long countAllByUser_NicknameAndTimestampBetween(String userNickname, Date from, Date till);

    long countAllByUser_IdAndUser_NicknameAndTimestampAfter(int userId, String userNickname, Date from);

    long countAllByUser_IdAndUser_NicknameAndTimestampBefore(int userId, String userNickname, Date till);

    long countAllByUser_IdAndUser_NicknameAndTimestampBetween(int userId, String userNickname, Date from, Date till);
}
