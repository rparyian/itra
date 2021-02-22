package com.example.ex4.service;

import com.example.ex4.model.User;
import com.example.ex4.repo.UserRepo;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private UserRepo userRepo;
    public MyUserDetailsService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        return userRepo.findByUsername(name);
    }
    public void changeStatusToUnblocked(User user){
        user.setStatus("unblocked");
        userRepo.saveAndFlush(user);
    }
    public void changeStatusToBlocked(User user){
        user.setStatus("blocked");
        userRepo.saveAndFlush(user);

    }

    public void changeLastInTime(User user){
        user.setLastInDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        userRepo.saveAndFlush(user);
        System.out.println(user.getLastInDate());
    }
}
