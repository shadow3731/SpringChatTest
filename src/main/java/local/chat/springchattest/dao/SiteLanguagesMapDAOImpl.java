package local.chat.springchattest.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class SiteLanguagesMapDAOImpl implements SiteLanguagesMapDAO {

    private EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public HashMap<String, String> getLanguageMap(String languageCode) {
        return null;
    }
}
