package ru.trofimets.crud_dao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.trofimets.crud_dao.dao.UserDAO;
import ru.trofimets.crud_dao.model.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Component
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }


    @Override
    public List<User> index() {
        return userDAO.index();
    }

    @Override
    public User show(int id) throws SQLException {
        return userDAO.show(id);
    }

    @Override
    public void save(User user) {
        userDAO.save(user);

    }

    @Override
    public Optional<User> show(String email) {
        return userDAO.show(email);
    }

    @Override
    public void update(int id, User user) throws SQLException {
        userDAO.update(id, user);

    }

    @Override
    public void delete(int id) {
        userDAO.delete(id);

    }
}
