package ru.innopolis.stc13.service;

import org.apache.commons.codec.digest.DigestUtils;
import ru.innopolis.stc13.pojo.User;
import ru.innopolis.stc13.repository.dao.UserDao;
import ru.innopolis.stc13.repository.dao.UserDaoImpl;

import java.sql.SQLException;

public class UserServiceImpl implements UserService {
    UserDao userDao;

    public UserServiceImpl() {
        userDao = new UserDaoImpl();
    }

    @Override
    public int getRole(String login) {
        if (login == null) {
            return -1;
        }
        try {
            User user = userDao.getUserByLogin(login);
            if (user != null) {
                return user.getRole();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public boolean checkAuth(String login, String password) {
        User user;
        if (login != null) {
            try {
                user = userDao.getUserByLogin(login);
                if (user != null && password != null) {
                    if(user.getHashPassword().equals(DigestUtils.md5Hex(password))) {
                        return true;
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return false;
    }
}
