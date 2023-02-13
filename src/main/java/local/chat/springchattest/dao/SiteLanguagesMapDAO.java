package local.chat.springchattest.dao;

import java.util.HashMap;

public interface SiteLanguagesMapDAO {

    HashMap<String, String> getLanguageMap(String languageCode);
}
