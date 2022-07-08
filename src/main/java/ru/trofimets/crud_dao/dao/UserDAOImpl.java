package ru.trofimets.crud_dao.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.trofimets.crud_dao.model.User;


import java.sql.*;
import java.util.List;
import java.util.Optional;

@Component
public class UserDAOImpl implements UserDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<User> index() {
        return jdbcTemplate.query("SELECT * FROM User", new BeanPropertyRowMapper<>(User.class));

    }

    @Override
    public User show(int id) throws SQLException {
        return jdbcTemplate.query("SELECT * FROM User WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(User.class))
                .stream().findAny().orElse(null);
    }

    @Override
    public Optional<User> show(String email) {
        return jdbcTemplate.query("SELECT * FROM User WHERE email=?", new Object[]{email}, new BeanPropertyRowMapper<>(User.class))
                .stream().findAny();
    }

    @Override
    public void save(User user) {
        jdbcTemplate.update("INSERT INTO User (name,surname,email) VALUES (?,?,?)", user.getName(), user.getSurname(), user.getEmail());

    }

    @Override
    public void update(int id, User updateUser) {
        jdbcTemplate.update("UPDATE User SET name = ?,surname = ?, email = ? WHERE id =?",
                updateUser.getName(), updateUser.getSurname(), updateUser.getEmail(), id);

    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM User WHERE id = ?", id);

    }
}
