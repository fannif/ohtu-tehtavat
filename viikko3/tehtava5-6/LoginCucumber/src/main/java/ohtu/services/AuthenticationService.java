package ohtu.services;

import static java.lang.Character.isLetter;
import static java.lang.Character.isLowerCase;
import ohtu.domain.User;
import java.util.ArrayList;
import java.util.List;
import ohtu.data_access.UserDao;

public class AuthenticationService {

    private UserDao userDao;

    public AuthenticationService(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean logIn(String username, String password) {
        for (User user : userDao.listAll()) {
            if (user.getUsername().equals(username)
                    && user.getPassword().equals(password)) {
                return true;
            }
        }

        return false;
    }

    public boolean createUser(String username, String password) {
        if (userDao.findByName(username) != null) {
            return false;
        }

        if (invalid(username, password)) {
            return false;
        }

        userDao.add(new User(username, password));

        return true;
    }

    private boolean invalid(String username, String password) {
        if (username.length() < 3) {
            return true;
        }
        if (password.length() < 8) {
            return true;
        }
        
        for (char c: username.toCharArray()) {
            if (!isLetter(c) || !isLowerCase(c)) {
                return true;
            }
        }
        
        for (char c: password.toCharArray()) {
            if (!isLetter(c)) {
                return false;
            }
        }

        return true;
    }
}
