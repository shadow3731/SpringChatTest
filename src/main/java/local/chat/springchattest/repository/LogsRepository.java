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
}
