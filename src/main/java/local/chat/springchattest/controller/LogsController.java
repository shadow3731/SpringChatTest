package local.chat.springchattest.controller;

import local.chat.springchattest.information.LogsListRequest;
import local.chat.springchattest.operation.LogsReader;
import local.chat.springchattest.service.logs.LogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Objects;

@Controller
public class LogsController {

    private LogsService logsService;

    @Autowired
    public void setLogsService(LogsService logsService) {
        this.logsService = logsService;
    }

    @GetMapping("/admin/logs")
    public String showLogsPage(@RequestParam(value = "action", required = false) String action,
                               @ModelAttribute("logsRequest") LogsListRequest logsListRequest,
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

        LogsReader logsReader = new LogsReader(logsService, logsListRequest);

        if (action != null) {
            switch (action) {
                case "Show logs", "<<" -> logsListRequest.setPageId(1);
                case "Go to" -> {}
                case "<" -> logsListRequest.setPageId(logsListRequest.getPageId() - 1);
                case ">" -> logsListRequest.setPageId(logsListRequest.getPageId() + 1);
                case ">>" -> logsListRequest.setPageId(logsReader.returnLastPage());
            }
        }

        if (logsListRequest.getPageId() < 1) {
            logsListRequest.setPageId(1);
            model.addAttribute("invalidPageId",
                    "Invalid number of page");
            return "admin/logs";
        }

        model.addAttribute("logs",
                logsReader.returnLogs());

        return "admin/logs";
    }

    @ModelAttribute
    public void getCommonInfo(Model model) {
        model.addAllAttributes(CommonModel.getCommonModels());
    }
}
