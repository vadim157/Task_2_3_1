package ru.trofimets.crud_dao.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.trofimets.crud_dao.dao.UserDAO;
import ru.trofimets.crud_dao.model.User;
import ru.trofimets.crud_dao.service.UserService;

@Component
public class UserValidator implements Validator {

    private final UserService userService;

    @Autowired
    public UserValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;
        if (userService.show(user.getEmail()).isPresent()){
            errors.rejectValue("email","","This email is already taken");

        }

    }
}
