package com.controller;

import com.models.Category;
import com.models.Post;
import com.services.CatService;
import com.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class CatController {

    @Autowired
    private CatService catService;


    @RequestMapping("/admin/cat/all")
    public String allCat(Model model){
        List<Category> cats = catService.getAllCats();
        model.addAttribute("cats" , cats);
        return "admin.cat.all";
    }

    @RequestMapping("/admin/cat/edit/{id}")
    public String catEdit(@PathVariable("id") String id, Model model){
        Category category = catService.getCatByIdEditGet(Integer.parseInt(id));
        model.addAttribute("category",category);
        return "admin.cat.edit";
    }

    @RequestMapping(value = "/admin/cat/edit/", method = RequestMethod.POST)
    public String catEditPost(@ModelAttribute ("category") Category category){
        catService.catEditPostMethod(category);
        return "redirect:/admin/cat/all";
    }

    @RequestMapping("/admin/cat/delete/{id}")
    public String catDelete(@PathVariable("id") String id){
        catService.deleteCats(Integer.parseInt(id));
        return "redirect:/admin/cat/all";
    }

    @RequestMapping("/admin/cat/create")
    public String catCreateGet(Model model){
        model.addAttribute("category",new Category());
        return "admin.cat.create";
    }

    @RequestMapping(value = "/admin/cat/create",method = RequestMethod.POST)
    public String catCreatePost(@ModelAttribute("category") Category category){
        catService.saveCats(category);
        return "redirect:/admin/cat/all";
    }

    @RequestMapping("/cat/{id}")
    public String OneToMany(@PathVariable("id") String id, Model model){
        Category category = catService.getCatById(Integer.parseInt(id));
        List<Category> categories = catService.getAllCats();
        List<Post> posts = category.getPosts();
        model.addAttribute("posts" , posts);
        model.addAttribute("cats" , categories);
        return "catPage";
    }
}
