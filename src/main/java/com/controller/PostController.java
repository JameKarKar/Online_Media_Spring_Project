package com.controller;

import com.models.Category;
import com.models.Post;
import com.models.User;
import com.services.CatService;
import com.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
public class PostController {

    @Autowired
    private CatService catService;

    @Autowired
    private PostService postService;

    @RequestMapping("/author/post/all")
    public String allPost(Model model){
        List<Post> posts = postService.getAllPosts();
        model.addAttribute("posts", posts);
        for (Post post : posts){
            User user = post.getUser();
            System.out.println(user);
        }
        return "author.post.all";
    }

    @RequestMapping("/author/post/create")
    public String postCreate(Model model){
        List<Category> cats = catService.getAllCats();
        model.addAttribute("cats" , cats);
        model.addAttribute("post" , new Post());
        return "author.post.create";
    }

    @RequestMapping(value = "/author/post/create",method = RequestMethod.POST)
    public String postCreatePost(@ModelAttribute("post") Post post, Model model, HttpServletRequest request){

        MultipartFile file = post.getFile();

        if (file != null && !file.isEmpty()){
            String imgName = saveImage(request,file);
            post.setImage(imgName);
        }
        post.setUser_id(1);
        postService.savePosts(post);

        return "redirect:/author/home";
    }

    public String saveImage(HttpServletRequest request, MultipartFile file){

        String imgName = System.currentTimeMillis() + ".png";

        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        Path path = Paths.get(rootDirectory + "/WEB-INF/assets/imgs/" +imgName);

        if (file != null && !file.isEmpty()){

            try {
                file.transferTo(new File(path.toString()));
            } catch (IOException e) {
                e.printStackTrace();
                throw  new RuntimeException("Image can't be save.");
            }

        }

        return imgName;
    }

    @RequestMapping("/author/post/edit/{id}")
    public String editPost(@PathVariable("id")String id , Model model){
        Post post = postService.getPostsById(Integer.parseInt(id));
        List<Category> categories = catService.getAllCats();
        model.addAttribute("post" , post);
        model.addAttribute("cats" , categories);
        return "author.post.edit";
    }

    @RequestMapping("/author/post/edit/")
    public String editPosts(@ModelAttribute("post") Post post,Model model,HttpServletRequest request){

        MultipartFile file = post.getFile();

        if(file != null && !file.isEmpty()){
            String imgName = saveImage( request,file);
            post.setImage(imgName);
        }else {
            System.out.println("File not exit");
        }

        postService.updatePosts(post);

        return "redirect:/author/home";
    }

    @RequestMapping("/author/post/delete/{id}")
    public String deletePost(@PathVariable("id")String id,Model model){
        postService.deletePost(Integer.parseInt(id));
        return "redirect:/author/home";
    }

    @RequestMapping("/singlePost/{id}")
    public String singlePosts(@PathVariable("id") String id, Model model){
        Post post = postService.getPostsById(Integer.parseInt(id));
        model.addAttribute("posts" , post);
        return "single.post";
    }
}
