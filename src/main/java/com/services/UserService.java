package com.services;

import com.daos.UserDao;
import com.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public List<User> getAllUsers(){
        return userDao.getAllUsers();
    }

    public User getUsersById(int id){
        return userDao.getUserById(id);
    }

    public User getUserByName(String name){
        return userDao.getUserByName(name);
    }

    public void userDelete(int id){
        userDao.deleteUser(id);
    }

    public void userCreated(User user){
        userDao.createUser(user);
    }

    public void userUpdate(User user){
        userDao.updateUser(user);
    }
}
