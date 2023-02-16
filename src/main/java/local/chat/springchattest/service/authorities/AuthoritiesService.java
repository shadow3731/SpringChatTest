package local.chat.springchattest.service.authorities;

import local.chat.springchattest.entity.User;

public interface AuthoritiesService {

    User loadUserByNickname(String nickname);
}
