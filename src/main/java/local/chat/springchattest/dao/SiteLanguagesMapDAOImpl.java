package local.chat.springchattest.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import local.chat.springchattest.entity.site.SiteLanguagesMap;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class SiteLanguagesMapDAOImpl implements SiteLanguagesMapDAO {

    private EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public SiteLanguagesMap getLanguageMap(String languageCode) {
        Map<String, String> map = new HashMap<>();

        Query query = entityManager
                .createQuery("select name, :code from SiteLanguagesMap")
                .setParameter("code", languageCode);
        List<Object[]> list = query.getResultList();
        for (Object[] l : list) {
            map.put(l[0].toString(), l[1].toString());
        }

        return new SiteLanguagesMap(map);
    }
}
