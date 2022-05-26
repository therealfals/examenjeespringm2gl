package com.examenjava.isi;     
import java.util.List;    

import org.springframework.beans.factory.annotation.Autowired;    
import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.ModelAttribute;    
import org.springframework.web.bind.annotation.RequestMapping;    
import org.springframework.web.bind.annotation.RequestMethod;

import com.examenjava.isi.model.User;
import com.examenjava.isi.service.UserService;     
@Controller
public class UserController {    
    @Autowired    
    UserService userService;
    
    @RequestMapping("/createUser")    
    public String showform(Model m){    
        m.addAttribute("user", new User());  
        return "userform";   
    }  
    
    @RequestMapping("/login")    
    public String showloginform(Model m){    
        m.addAttribute("user", new User());  
        return "login";   
    }   
   
    @RequestMapping(value="/addUser",method = RequestMethod.POST)    
    public String save(@ModelAttribute("user") User user){    
    	userService.addUser(user);    
        return "redirect:/listUser";
    }    
    @RequestMapping("/listUser")    
    public String viewemp(Model m){    
        List<User> users=userService.getAllUsers();  
        m.addAttribute("users",users);  
        return "listusers";    
    }   
}  