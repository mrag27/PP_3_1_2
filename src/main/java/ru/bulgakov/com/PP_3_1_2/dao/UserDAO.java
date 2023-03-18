package ru.bulgakov.com.PP_3_1_2.dao;


import ru.bulgakov.com.PP_3_1_2.models.User;

import java.util.List;

public interface UserDAO {
    public void saveUser(User user);

    public User getUser(int id);

    public void deleteUser(int id);

    public void updateUser(User user);

    public List<User> getAllUser();

}
