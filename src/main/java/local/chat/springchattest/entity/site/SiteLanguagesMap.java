package local.chat.springchattest.entity.site;

import jakarta.persistence.Table;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Table(name = "site_configuration_languages_texts")
public class SiteLanguagesMap {


    private Map<String, String> languagesMap;
}
