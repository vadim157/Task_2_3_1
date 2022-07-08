package ru.trofimets.crud_dao.service;

import ru.trofimets.crud_dao.model.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> index();
    User show(int id) throws SQLException;
    void save(User user);
    Optional<User> show(String email);

    void update(int id, User user) throws SQLException;
    void delete(int id);
}
