package local.chat.springchattest.service.authorities;

import local.chat.springchattest.entity.User;
import local.chat.springchattest.repository.AuthoritiesRepository;
import local.chat.springchattest.service.users.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthoritiesServiceImpl implements AuthoritiesService {

    private AuthoritiesRepository authoritiesRepository;
    private UsersService usersService;

    @Autowired
    public void setAuthoritiesRepository(AuthoritiesRepository authoritiesRepository) {
        this.authoritiesRepository = authoritiesRepository;
    }

    @Autowired
    public void setUsersService(UsersService usersService) {
        this.usersService = usersService;
    }

    @Override
    public User loadUserByNickname(String nickname) {
        return usersService.getUserByNickname(nickname);
    }
}
