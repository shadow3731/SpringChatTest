package local.chat.springchattest.controller;

import local.chat.springchattest.information.LogsListRequest;
import local.chat.springchattest.operation.LogsReader;
import local.chat.springchattest.service.logs.LogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
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
    public String showLogsPage(@ModelAttribute("logsRequest") LogsListRequest logsListRequest,
                               Model model) throws ParseException {
        if (logsListRequest.getFrom() != null &&
                logsListRequest.getTill() != null &&
                !Objects.equals(logsListRequest.getFrom(), "") &&
                !Objects.equals(logsListRequest.getTill(), "")) {
            long fromTimestamp = LocalDateTime.parse(logsListRequest.getFrom())
                    .toEpochSecond(ZoneOffset
                            .from(OffsetDateTime.now()));
            long tillTimestamp = LocalDateTime.parse(logsListRequest.getTill())
                    .toEpochSecond(ZoneOffset
                            .from(OffsetDateTime.now()));
            if (tillTimestamp - fromTimestamp < 0) {
                model.addAttribute("invalidTimestampGap",
                        "Invalid timestamp gap");
                return "admin/logs";
            }
        }

        if (logsListRequest.getPageId() < 1) {
            model.addAttribute("invalidPageId",
                    "Invalid number of page");
            return "admin/logs";
        }

        LogsReader logsReader = new LogsReader();
        model.addAttribute("logs",
                logsReader.returnLogs(logsListRequest, logsService));

        return "admin/logs";
    }

    /*@GetMapping("/admin/logs")
    public String showLogsPage(@RequestParam(value = "id", required = false) String id,
                               @RequestParam(value = "nickname", required = false) String nickname,
                               @RequestParam(value = "from", required = false) String from,
                               @RequestParam(value = "till", required = false) String till,
                               Model model) throws ParseException {
        if (from != null && till != null &&
                !Objects.equals(from, "") &&
                !Objects.equals(till, "")) {
            long fromTimestamp = LocalDateTime.parse(from)
                    .toEpochSecond(ZoneOffset
                            .from(OffsetDateTime.now()));
            long tillTimestamp = LocalDateTime.parse(till)
                    .toEpochSecond(ZoneOffset
                            .from(OffsetDateTime.now()));
            if (tillTimestamp - fromTimestamp < 0) {
                model.addAttribute("invalidTimestampGap",
                        "Invalid timestamp gap");
                return "admin/logs";
            }
        }

        LogsReader logsReader = new LogsReader();
        model.addAttribute("logs",
                logsReader.returnLogs(logsService, id, nickname, from, till));

        return "admin/logs";
    }*/

    @ModelAttribute
    public void getCommonInfo(Model model) {
        model.addAllAttributes(CommonModel.getCommonModels());
    }
}
