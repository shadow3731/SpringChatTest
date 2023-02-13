package local.chat.springchattest.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import local.chat.springchattest.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO {

    private EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public User getUser(int id) {
        return entityManager.find(User.class, id);
    }
}
