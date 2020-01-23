package com.daos;

import com.models.Category;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CatDao {

    List<Category> getAllCats(); //show all category

    Category getCatByIdEdit(int id); // category edit get method

    Category getCatById(int id);

    void catEdit(Category category); // category edit post method

    void deleteCat(int id); // delete category

    void saveCat(Category category); //for cat create



}

