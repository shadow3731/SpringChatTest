package local.chat.springchattest.operation;

import local.chat.springchattest.entity.Log;
import local.chat.springchattest.information.LogsListRequest;
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

    public List<Log> returnLogs(LogsListRequest logsListRequest,
                                LogsService logsService)
            throws ParseException {
        long endLogId = logsListRequest.getPageId() * logsListRequest.getLOGS_AMOUNT_ON_PAGE();
        long initLogId = endLogId - logsListRequest.getLOGS_AMOUNT_ON_PAGE() + 1;

        if (isBlank(logsListRequest.getUserId())) {
            if (isBlank(logsListRequest.getUserNickname())) {
                if (isBlank(logsListRequest.getFrom())) {
                    if (isBlank(logsListRequest.getTill())) {
                        return logsService.getAllLogsByIdBetween(initLogId, endLogId);
                    } else {
                        Date tillDate = new SimpleDateFormat("yyyy-MM-dd HH:mm")
                                .parse(logsListRequest.getTill().replace("T", " "));
                        return logsService.getAllLogsTillAndByIdBetween(tillDate, initLogId, endLogId);
                    }
                } else {
                    Date fromDate = new SimpleDateFormat("yyyy-MM-dd HH:mm")
                            .parse(logsListRequest.getFrom().replace("T", " "));
                    if (isBlank(logsListRequest.getTill())) {
                        return logsService.getAllLogsFromAndByIdBetween(fromDate, initLogId, endLogId);
                    } else {
                        Date tillDate = new SimpleDateFormat("yyyy-MM-dd HH:mm")
                                .parse(logsListRequest.getTill().replace("T", " "));
                        return logsService.getAllLogsBetweenAndByIdBetween(fromDate, tillDate, initLogId, endLogId);
                    }
                }
            } else {
                if (isBlank(logsListRequest.getFrom())) {
                    if (isBlank(logsListRequest.getTill())) {
                        return logsService.getAllLogsByUserNicknameAndByIdBetween(logsListRequest.getUserNickname(), initLogId, endLogId);
                    } else {
                        Date tillDate = new SimpleDateFormat("yyyy-MM-dd HH:mm")
                                .parse(logsListRequest.getTill().replace("T", " "));
                        return logsService.getAllLogsByUserNicknameTillAndByIdBetween(logsListRequest.getUserNickname(), tillDate, initLogId, endLogId);
                    }
                } else {
                    Date fromDate = new SimpleDateFormat("yyyy-MM-dd HH:mm")
                            .parse(logsListRequest.getFrom().replace("T", " "));
                    if (isBlank(logsListRequest.getTill())) {
                        return logsService.getAllLogsByUserNicknameFromAndByIdBetween(logsListRequest.getUserNickname(), fromDate, initLogId, endLogId);
                    } else {
                        Date tillDate = new SimpleDateFormat("yyyy-MM-dd HH:mm")
                                .parse(logsListRequest.getTill().replace("T", " "));
                        return logsService.getAllLogsByUserNicknameBetweenAndByIdBetween(logsListRequest.getUserNickname(), fromDate, tillDate, initLogId, endLogId);
                    }
                }
            }
        } else {
            if (isBlank(logsListRequest.getUserNickname())) {
                if (isBlank(logsListRequest.getFrom())) {
                    if (isBlank(logsListRequest.getTill())) {
                        return logsService.getAllLogsByUserIdAndByIdBetween(Integer
                                .parseInt(logsListRequest.getUserId()), initLogId, endLogId);
                    } else {
                        Date tillDate = new SimpleDateFormat("yyyy-MM-dd HH:mm")
                                .parse(logsListRequest.getTill().replace("T", " "));
                        return logsService.getAllLogsByUserIdTillAndByIdBetween(Integer
                                .parseInt(logsListRequest.getUserId()), tillDate, initLogId, endLogId);
                    }
                } else {
                    Date fromDate = new SimpleDateFormat("yyyy-MM-dd HH:mm")
                            .parse(logsListRequest.getFrom().replace("T", " "));
                    if (isBlank(logsListRequest.getTill())) {
                        return logsService.getAllLogsByUserIdFromAndByIdBetween(Integer
                                .parseInt(logsListRequest.getUserId()), fromDate, initLogId, endLogId);
                    } else {
                        Date tillDate = new SimpleDateFormat("yyyy-MM-dd HH:mm")
                                .parse(logsListRequest.getTill().replace("T", " "));
                        return logsService.getAllLogsByUserIdBetweenAndByIdBetween(Integer
                                .parseInt(logsListRequest.getUserId()), fromDate, tillDate, initLogId, endLogId);
                    }
                }
            } else {
                if (isBlank(logsListRequest.getFrom())) {
                    if (isBlank(logsListRequest.getTill())) {
                        return logsService.getAllLogsByUserIdAndUserNicknameAndByIdBetween(Integer
                                .parseInt(logsListRequest.getUserId()), logsListRequest.getUserNickname(), initLogId, endLogId);
                    } else {
                        Date tillDate = new SimpleDateFormat("yyyy-MM-dd HH:mm")
                                .parse(logsListRequest.getTill().replace("T", " "));
                        return logsService.getAllLogsByUserIdAndUserNicknameTillAndByIdBetween(Integer
                                .parseInt(logsListRequest.getUserId()), logsListRequest.getUserNickname(), tillDate, initLogId, endLogId);
                    }
                } else {
                    Date fromDate = new SimpleDateFormat("yyyy-MM-dd HH:mm")
                            .parse(logsListRequest.getFrom().replace("T", " "));
                    if (isBlank(logsListRequest.getTill())) {
                        return logsService.getAllLogsByUserIdAndUserNicknameFromAndByIdBetween(Integer
                                .parseInt(logsListRequest.getUserId()), logsListRequest.getUserNickname(), fromDate, initLogId, endLogId);
                    } else {
                        Date tillDate = new SimpleDateFormat("yyyy-MM-dd HH:mm")
                                .parse(logsListRequest.getTill().replace("T", " "));
                        return logsService.getAllLogsByUserIdAndUserNicknameBetweenAndByIdBetween(Integer
                                .parseInt(logsListRequest.getUserId()), logsListRequest.getUserNickname(), fromDate, tillDate, initLogId, endLogId);
                    }
                }
            }
        }
    }

    private boolean isBlank(String object) {
        return  object == null || Objects.equals(object, "");
    }
}
