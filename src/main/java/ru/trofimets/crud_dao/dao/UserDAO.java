package ru.trofimets.crud_dao.dao;

import ru.trofimets.crud_dao.model.User;

import java.util.List;


public interface UserDAO {

    List<User> index();

    User show(int id);

    void save(User user);

    void update(int id, User user);

    void delete(int id);
}
