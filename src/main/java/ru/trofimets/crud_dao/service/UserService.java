package ru.trofimets.crud_dao.service;

import ru.trofimets.crud_dao.model.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> index();

    User show(int id);

    void save(User user);

    void update(int id, User user);

    void delete(int id);
}
