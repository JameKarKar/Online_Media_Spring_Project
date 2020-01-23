package com.daos;

import com.models.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserDao {

    List<User> getAllUsers();

    User getUserById(int id);

    User getUserByName(String name);

    void deleteUser(int id);

    void createUser(User user);

    void updateUser(User user);
}
