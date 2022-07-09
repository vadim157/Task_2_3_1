package ru.trofimets.crud_dao.dao;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.trofimets.crud_dao.model.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Component
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    @Transactional(readOnly = true)
    public List<User> index() {
        return entityManager.createQuery("select u FROM User u", User.class).getResultList();

    }

    @Override
    @Transactional(readOnly = true)
    public User show(int id) {
        return entityManager.find(User.class,id);
    }

    @Override
    @Transactional
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    @Transactional
    public void update(int id, User updateUser) {

        User user = entityManager.find(User.class,id);
        user.setName(updateUser.getName());
        user.setSurname(updateUser.getSurname());
        user.setEmail(updateUser.getEmail());
        entityManager.merge(user);
    }

    @Override
    @Transactional
    public void delete(int id) {
        entityManager.remove(entityManager.find(User.class,id));
    }
}
