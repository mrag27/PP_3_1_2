package ru.bulgakov.com.PP_3_1_2.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import ru.bulgakov.com.PP_3_1_2.models.User;

import java.util.List;


@Repository
public class UserDAOImpl implements UserDAO {
    @PersistenceContext
    private EntityManager entityManager;

    public UserDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public User getUser(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void deleteUser(int id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public List<User> getAllUser() {
        String sql = "FROM User";
        return entityManager.createQuery(sql, User.class).getResultList();
    }
}
