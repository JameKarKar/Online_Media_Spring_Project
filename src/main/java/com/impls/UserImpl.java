package com.impls;

import com.daos.UserDao;
import com.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    public Session session(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<User> getAllUsers() {
        Query query = session().createQuery("from User");
        List<User> users = query.list();
       return users;
    }

    @Override
    public User getUserById(int id) {
        User user = session().get(User.class,id);
        session().flush();
        return user;
    }

    @Override
    public User getUserByName(String name) {

        Query query = session().createQuery("from User where username=:name");
        query.setParameter("name" , name);
        User users = (User)query.uniqueResult();
        return users;
    }

    @Override
    public void deleteUser(int id) {
       session().delete(getUserById(id));
       session().flush();

    }

    @Override
    public void createUser(User user) {
        session().save(user);
        session().flush();
    }

    @Override
    public void updateUser(User user) {
        session().saveOrUpdate(user);
        session().flush();
    }
}
