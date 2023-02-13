package local.chat.springchattest.dao;

import local.chat.springchattest.entity.site.SiteLanguagesMap;

public interface SiteLanguagesMapDAO {

    SiteLanguagesMap getLanguageMap(String languageCode);
}
