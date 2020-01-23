package com.controller;

import com.models.Authority;
import com.models.Category;
import com.models.User;
import com.services.AuthService;
import com.services.CatService;
import com.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthService authService;

    @Autowired
    private CatService catService;


    @RequestMapping("/admin/user/all")
    public String getAllUsers(Model model){
        List<User> users = userService.getAllUsers();
        model.addAttribute("users",users);
        return "users.all";
    }

    @RequestMapping("/login")
    public String login(@RequestParam(name = "error" ,required = false) String error ,
                        @RequestParam(name = "logout" , required = false) String logout ,
                        Model model){

        List<Category> categories = catService.getAllCats(); // for dropdown list cat
        model.addAttribute("cats" , categories); // for dropdown list cat

        if (error != null ){
            model.addAttribute("error" , "Login Error , Please retry again!");
        }
        if (logout != null){
            model.addAttribute("logout" , "Logout Successfully!");
        }

        return "login";
    }

    @RequestMapping("/admin/user/toggle/{id}")
    public String userToggle(@PathVariable("id") String id, Model model){
        User user = userService.getUsersById(Integer.parseInt(id));
        if (user.isEnabled()){
            user.setEnabled(false);
        }else {
            user.setEnabled(true);
        }
        userService.userUpdate(user);
        return "redirect:/admin/user/all";
    }

    @RequestMapping("/register")
    public String register(Model model){
        List<Category> categories = catService.getAllCats(); //for dropdown list
        model.addAttribute("user" , new User());
        model.addAttribute("cats" , categories); // for dropdown list cat
        return "register";
    }

    @RequestMapping(value = "/register" , method = RequestMethod.POST)
    public String registerPost(@Valid @ModelAttribute("user") User user , BindingResult result, Model model){

        System.out.println(user);
        if (result.hasErrors()){
            List<ObjectError> errors = result.getAllErrors();
            for (ObjectError error : errors){
                System.out.println(error.getDefaultMessage());
            }
            return "register";
        }else {
            userService.userCreated(user);
            authService.addAuth(new Authority(user.getUsername(), "ROLE_USER"));
            model.addAttribute("register_success" , "Register Successfully! Please login again.");
            return "login";
        }
    }
}
