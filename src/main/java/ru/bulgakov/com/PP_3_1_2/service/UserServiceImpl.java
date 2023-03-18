package ru.bulgakov.com.PP_3_1_2.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bulgakov.com.PP_3_1_2.dao.UserDAO;
import ru.bulgakov.com.PP_3_1_2.models.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        userDAO.saveUser(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User getUser(int id) {
        return userDAO.getUser(id);
    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        userDAO.deleteUser(id);
    }

    @Override
    @Transactional
    public void updateUser(int id, User user) {
        userDAO.updateUser(user);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUser() {
        return userDAO.getAllUser();
    }
}
