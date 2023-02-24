package local.chat.springchattest.configuration;

import local.chat.springchattest.factory.UserFactory;
import local.chat.springchattest.session.UserSessionListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public UserFactory userFactory() {
        return new UserFactory();
    }

    @Bean
    public UserSessionListener userSessionListener(UserFactory userFactory) {
        return new UserSessionListener(userFactory);
    }
}
