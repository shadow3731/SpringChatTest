package local.chat.springchattest.dao;

import local.chat.springchattest.entity.Site;

public interface SiteDAO {

    Site getConfigurations(String lang);
}
