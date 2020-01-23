package com.impls;
import com.daos.CatDao;
import com.models.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CatImpl implements CatDao {

    @Autowired
    private SessionFactory sessionFactory;

    public Session session(){
        return sessionFactory.getCurrentSession();
    }

    public List<Category> getAllCats() {
        Query query = session().createQuery("from Category");
        List<Category> cats = query.list();
        session().flush();
        return cats;
    }

    public Category getCatByIdEdit(int id) {
        Category category = session().get(Category.class,id);
        session().flush();
        return category;
    }

    @Override
    public Category getCatById(int id) {
        Category category = session().get(Category.class,id);
        session().flush();
        return category;
    }

    public void catEdit(Category category) {
        session().saveOrUpdate(category);
        session().flush();
    }

    public void deleteCat(int id) {
        session().delete(getCatByIdEdit(id));
        session().flush();
    }

    public void saveCat(Category category) {
        session().save(category);
        session().flush();
    }

}
