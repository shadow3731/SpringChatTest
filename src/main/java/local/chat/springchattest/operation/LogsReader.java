package local.chat.springchattest.operation;

import local.chat.springchattest.entity.Log;
import local.chat.springchattest.information.LogsListRequest;
import local.chat.springchattest.service.logs.LogsService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Component
@NoArgsConstructor
public class LogsReader {

    private LogsService logsService;
    private LogsListRequest logsListRequest;

    public LogsReader(@Autowired LogsService logsService,
                      @Autowired LogsListRequest logsListRequest) {
        this.logsService = logsService;
        this.logsListRequest = logsListRequest;
    }

    public List<Log> returnLogs() throws ParseException {
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

    public long returnLastPage() throws ParseException {
        long lastPage;

        if (isBlank(logsListRequest.getUserId())) {
            if (isBlank(logsListRequest.getUserNickname())) {
                if (isBlank(logsListRequest.getFrom())) {
                    if (isBlank(logsListRequest.getTill())) {
                        lastPage = logsService.countAllLogs();
                    } else {
                        Date tillDate = new SimpleDateFormat("yyyy-MM-dd HH:mm")
                                .parse(logsListRequest.getTill().replace("T", " "));
                        lastPage = logsService.countAllLogsTill(tillDate);
                    }
                } else {
                    Date fromDate = new SimpleDateFormat("yyyy-MM-dd HH:mm")
                            .parse(logsListRequest.getFrom().replace("T", " "));
                    if (isBlank(logsListRequest.getTill())) {
                        lastPage = logsService.countAllLogsFrom(fromDate);
                    } else {
                        Date tillDate = new SimpleDateFormat("yyyy-MM-dd HH:mm")
                                .parse(logsListRequest.getTill().replace("T", " "));
                        lastPage = logsService.countAllLogsBetween(fromDate, tillDate);
                    }
                }
            } else {
                if (isBlank(logsListRequest.getFrom())) {
                    if (isBlank(logsListRequest.getTill())) {
                        lastPage = logsService.countAllLogsByUserNickname(logsListRequest.getUserNickname());
                    } else {
                        Date tillDate = new SimpleDateFormat("yyyy-MM-dd HH:mm")
                                .parse(logsListRequest.getTill().replace("T", " "));
                        lastPage = logsService.countAllLogsByUserNicknameTill(logsListRequest.getUserNickname(), tillDate);
                    }
                } else {
                    Date fromDate = new SimpleDateFormat("yyyy-MM-dd HH:mm")
                            .parse(logsListRequest.getFrom().replace("T", " "));
                    if (isBlank(logsListRequest.getTill())) {
                        lastPage = logsService.countAllLogsByUserNicknameFrom(logsListRequest.getUserNickname(), fromDate);
                    } else {
                        Date tillDate = new SimpleDateFormat("yyyy-MM-dd HH:mm")
                                .parse(logsListRequest.getTill().replace("T", " "));
                        lastPage = logsService.countAllLogsByUserNicknameBetween(logsListRequest.getUserNickname(), fromDate, tillDate);
                    }
                }
            }
        } else {
            if (isBlank(logsListRequest.getUserNickname())) {
                if (isBlank(logsListRequest.getFrom())) {
                    if (isBlank(logsListRequest.getTill())) {
                        lastPage = logsService.countAllLogsByUserId(Integer.parseInt(logsListRequest.getUserId()));
                    } else {
                        Date tillDate = new SimpleDateFormat("yyyy-MM-dd HH:mm")
                                .parse(logsListRequest.getTill().replace("T", " "));
                        lastPage = logsService.countAllLogsByUserIdTill(Integer.parseInt(logsListRequest.getUserId()), tillDate);
                    }
                } else {
                    Date fromDate = new SimpleDateFormat("yyyy-MM-dd HH:mm")
                            .parse(logsListRequest.getFrom().replace("T", " "));
                    if (isBlank(logsListRequest.getTill())) {
                        lastPage = logsService.countAllLogsByUserIdFrom(Integer.parseInt(logsListRequest.getUserId()), fromDate);
                    } else {
                        Date tillDate = new SimpleDateFormat("yyyy-MM-dd HH:mm")
                                .parse(logsListRequest.getTill().replace("T", " "));
                        lastPage = logsService.countAllLogsByUserIdBetween(Integer.parseInt(logsListRequest.getUserId()), fromDate, tillDate);
                    }
                }
            } else {
                if (isBlank(logsListRequest.getFrom())) {
                    if (isBlank(logsListRequest.getTill())) {
                        lastPage = logsService.countAllLogsByUserIdAndUserNickname(Integer.parseInt(logsListRequest.getUserId()), logsListRequest.getUserNickname());
                    } else {
                        Date tillDate = new SimpleDateFormat("yyyy-MM-dd HH:mm")
                                .parse(logsListRequest.getTill().replace("T", " "));
                        lastPage = logsService.countAllLogsByUserIdAndUserTill(Integer.parseInt(logsListRequest.getUserId()), logsListRequest.getUserNickname(), tillDate);
                    }
                } else {
                    Date fromDate = new SimpleDateFormat("yyyy-MM-dd HH:mm")
                            .parse(logsListRequest.getFrom().replace("T", " "));
                    if (isBlank(logsListRequest.getTill())) {
                        lastPage = logsService.countAllLogsByUserIdAndUserFrom(Integer.parseInt(logsListRequest.getUserId()), logsListRequest.getUserNickname(), fromDate);
                    } else {
                        Date tillDate = new SimpleDateFormat("yyyy-MM-dd HH:mm")
                                .parse(logsListRequest.getTill().replace("T", " "));
                        lastPage = logsService.countAllLogsByUserIdAndUserBetween(Integer.parseInt(logsListRequest.getUserId()), logsListRequest.getUserNickname(), fromDate, tillDate);
                    }
                }
            }
        }

        return (long) Math.ceil(lastPage / (double) logsListRequest.getLOGS_AMOUNT_ON_PAGE());
    }

    private boolean isBlank(String object) {
        return  object == null || Objects.equals(object, "");
    }


}
