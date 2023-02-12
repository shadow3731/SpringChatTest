package local.chat.springchattest.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import local.chat.springchattest.entity.Site;
import org.springframework.stereotype.Repository;

@Repository
public class SiteDAOImpl implements SiteDAO {

    private EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Site getConfigurations(String lang) {
        return null;
    }
}
