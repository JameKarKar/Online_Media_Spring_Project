package com.controller;

import com.models.Category;
import com.models.Post;
import com.models.User;
import com.services.CatService;
import com.services.PostService;
import com.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class PageController {

    @Autowired
    private PostService postService;
    @Autowired
    private CatService catService;
    @Autowired
    private UserService userService;

    @RequestMapping("/")
        public String home(Model model){
        List<Post> postList = postService.getAllPosts();
        List<Category> categoryList = catService.getAllCats();
        model.addAttribute("posts" , postList);
        model.addAttribute("cats" , categoryList);
        return "home";
    }

    @RequestMapping("/admin/home")
    public String admin(Model model){
        List<Post> posts = postService.getAllPosts();
        List<Category> categories = catService.getAllCats(); // for dorpdown list cat
        model.addAttribute("cats" , categories); // for dropdown list cats
        model.addAttribute("posts" , posts);
        return "admin.home";
    }

    @RequestMapping("/contact")
    public String contact(Model model){
        List<Category> categories = catService.getAllCats(); // for dropdown list cats
        model.addAttribute("cats" , categories); // for dropdown list cats
        return "contact";
    }

    @RequestMapping("/author/home")
    public String author(Model model){

        List<Category> categories = catService.getAllCats(); // for dropdown list cats

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails)principal).getUsername();
        User user = userService.getUserByName(username);
        model.addAttribute("posts", user.getPosts());
        model.addAttribute("cats" , categories);  // for dropdown list cats
        return "author.home";
    }

    @RequestMapping("/user/home")
    public String userPanel(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        boolean bol = authentication.getAuthorities().stream().anyMatch(r ->  r.getAuthority()
                .equals("ROLE_ADMIN"));

        if (bol){
            return "redirect:/admin/home";
        }else {
            return "redirect:/author/home";
        }
    }
}
