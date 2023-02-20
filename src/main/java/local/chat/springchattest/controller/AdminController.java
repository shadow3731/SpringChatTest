package local.chat.springchattest.controller;

import local.chat.springchattest.service.logs.LogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.Objects;

@Controller
public class AdminController {

    private LogsService logsService;

    @Autowired
    public void setLogsService(LogsService logsService) {
        this.logsService = logsService;
    }

    @GetMapping("/admin")
    public String showAdminRoomPage() {
        return "admin/admin";
    }

    @GetMapping("/admin/logs")
    public String showLogsPage(@RequestParam(value = "id", required = false) String id,
                               @RequestParam(value = "nickname", required = false) String nickname,
                               @RequestParam(value = "from", required = false) String from,
                               @RequestParam(value = "till", required = false) String till,
                               Model model) throws ParseException {
        if (from != null && till != null &&
                !Objects.equals(from, "") &&
                !Objects.equals(till, "")) {
            if (isNegativeTimestampGap(from, till)) {
                model.addAttribute("invalidTimestampGap",
                        "Invalid timestamp gap");
                return "admin/logs";
            }
        }

        if (isBlank(id)) {
            if (isBlank(nickname)) {
                if (isBlank(from)) {
                    if (isBlank(till)) {
                        model.addAttribute("logs", logsService.getAllLogs());
                    } else {
                        Date tillDate = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(till.replace("T", " "));
                        model.addAttribute("logs", logsService.getAllLogsTill(tillDate));
                    }
                } else {
                    Date fromDate = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(from.replace("T", " "));
                    if (isBlank(till)) {
                        model.addAttribute("logs", logsService.getAllLogsFrom(fromDate));
                    } else {
                        Date tillDate = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(till.replace("T", " "));
                        model.addAttribute("logs", logsService.getAllLogsBetween(fromDate, tillDate));
                    }
                }
            } else {
                if (isBlank(from)) {
                    if (isBlank(till)) {
                        model.addAttribute("logs", logsService.getAllLogsByUserNickname(nickname));
                    } else {
                        Date tillDate = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(till.replace("T", " "));
                        model.addAttribute("logs", logsService.getAllLogsByUserNicknameTill(nickname, tillDate));
                    }
                } else {
                    Date fromDate = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(from.replace("T", " "));
                    if (isBlank(till)) {
                        model.addAttribute("logs", logsService.getAllLogsByUserNicknameFrom(nickname, fromDate));
                    } else {
                        Date tillDate = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(till.replace("T", " "));
                        model.addAttribute("logs", logsService.getAllLogsByUserNicknameBetween(nickname, fromDate, tillDate));
                    }
                }
            }
        } else {
            if (isBlank(nickname)) {
                if (isBlank(from)) {
                    if (isBlank(till)) {
                        model.addAttribute("logs", logsService.getAllLogsByUserId(Integer.parseInt(id)));
                    } else {
                        Date tillDate = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(till.replace("T", " "));
                        model.addAttribute("logs", logsService.getAllLogsByUserIdTill(Integer.parseInt(id), tillDate));
                    }
                } else {
                    Date fromDate = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(from.replace("T", " "));
                    if (isBlank(till)) {
                        model.addAttribute("logs", logsService.getAllLogsByUserIdFrom(Integer.parseInt(id), fromDate));
                    } else {
                        Date tillDate = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(till.replace("T", " "));
                        model.addAttribute("logs", logsService.getAllLogsByUserIdBetween(Integer.parseInt(id), fromDate, tillDate));
                    }
                }
            } else {
                if (isBlank(from)) {
                    if (isBlank(till)) {
                        model.addAttribute("logs", logsService.getAllLogsByUserIdAndUserNickname(Integer.parseInt(id), nickname));
                    } else {
                        Date tillDate = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(till.replace("T", " "));
                        model.addAttribute("logs", logsService.getAllLogsByUserIdAndUserNicknameTill(Integer.parseInt(id), nickname, tillDate));
                    }
                } else {
                    Date fromDate = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(from.replace("T", " "));
                    if (isBlank(till)) {
                        model.addAttribute("logs", logsService.getAllLogsByUserIdAndUserNicknameFrom(Integer.parseInt(id), nickname, fromDate));
                    } else {
                        Date tillDate = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(till.replace("T", " "));
                        model.addAttribute("logs", logsService.getAllLogsByUserIdAndUserNicknameBetween(Integer.parseInt(id), nickname, fromDate, tillDate));
                    }
                }
            }
        }

        return "admin/logs";
    }

    @ModelAttribute
    public void getCommonInfo(Model model) {
        model.addAllAttributes(CommonModel.getCommonModels());
    }

    private boolean isNegativeTimestampGap(String from, String till) {
        long fromTimestamp = LocalDateTime.parse(from)
                .toEpochSecond(ZoneOffset
                        .from(OffsetDateTime.now()));
        long tillTimestamp = LocalDateTime.parse(till)
                .toEpochSecond(ZoneOffset
                        .from(OffsetDateTime.now()));
        return tillTimestamp - fromTimestamp < 0;
    }

    private boolean isBlank(String object) {
        return  object == null || Objects.equals(object, "");
    }
}
