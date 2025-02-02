package com.registration.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.registration.model.User;
import com.registration.repositories.UserRepository;
@Controller
public class UserController {
    

    @Autowired
    UserRepository userRepository;

    @GetMapping("/registration")
    public String getRegPage(@ModelAttribute("user") User user) {
        return "register";
    }

    @PostMapping("/registration") 
        public String saveUser(@ModelAttribute("user") User user , Model model) {
            userRepository.save(user);
            model.addAttribute("message", "Submitted succesfully");
            return "register";
        }
    }

    /*@GetMapping("/users")
    public String usersPage(Model model) {
        List<User> listOfUsers = userRepository.findAll(); 
        model.addAttribute("user", listOfUsers);
        return "user";
    }*/

