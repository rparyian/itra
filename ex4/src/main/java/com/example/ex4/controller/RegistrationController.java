package com.example.ex4.controller;

import com.example.ex4.model.RegistrationForm;
import com.example.ex4.model.User;
import com.example.ex4.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    private PasswordEncoder passwordEncoder;
    private UserRepo userRepo;

    public RegistrationController(PasswordEncoder passwordEncoder, UserRepo userRepo) {
        this.passwordEncoder = passwordEncoder;
        this.userRepo = userRepo;
    }

    @GetMapping
    public String getRegistrationForm(){
        return "/registration";
    }
    @PostMapping
    public String saveNewUser(RegistrationForm form){
        System.out.println(form.getPassword());
        userRepo.save(form.toUser(passwordEncoder));
        return "redirect:/login";
    }
}
