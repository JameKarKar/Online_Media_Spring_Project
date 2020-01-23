package com.services;

import com.daos.CatDao;
import com.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatService {

    @Autowired
    private CatDao catDao;

    public List<Category> getAllCats(){
        return catDao.getAllCats();
    }

    public Category getCatByIdEditGet(int id){
        return catDao.getCatByIdEdit(id);
    }

    public Category getCatById(int id){
        return catDao.getCatById(id);    //  one to many
    }

    public void catEditPostMethod(Category category){
        catDao.catEdit(category);
    }

    public void deleteCats(int id){
        catDao.deleteCat(id);
    }

    public void saveCats(Category category){
        catDao.saveCat(category);
    }
}
