package ru.trofimets.crud_dao.dao;

import ru.trofimets.crud_dao.model.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface UserDAO {

    List<User> index();
    User show(int id) throws SQLException;

    Optional<User> show(String email);
    void save(User user);

    void update(int id, User user) throws SQLException;
    void delete(int id);
}
