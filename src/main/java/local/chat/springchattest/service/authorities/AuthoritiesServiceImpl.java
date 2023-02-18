package local.chat.springchattest.service.authorities;

import local.chat.springchattest.entity.Authority;
import local.chat.springchattest.repository.AuthoritiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthoritiesServiceImpl implements AuthoritiesService {

    private AuthoritiesRepository authoritiesRepository;

    @Autowired
    public void setAuthoritiesRepository(AuthoritiesRepository authoritiesRepository) {
        this.authoritiesRepository = authoritiesRepository;
    }

    @Override
    public Authority getAuthorityById(int id) {
        return authoritiesRepository.findById(id).orElse(null);
    }
}
