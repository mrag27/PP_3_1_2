package ru.bulgakov.com.PP_3_1_2.service;


import ru.bulgakov.com.PP_3_1_2.models.User;

import java.util.List;

public interface UserService {
    public void saveUser(User user);

    public User getUser(int id);

    public void deleteUser(int id);

    public void updateUser(int id, User user);

    public List<User> getAllUser();

}
