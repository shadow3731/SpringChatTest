package local.chat.springchattest.dao;

import local.chat.springchattest.entity.site.UserSiteConfiguration;

public interface SiteDAO {

    UserSiteConfiguration getConfigurations(String lang);
}
