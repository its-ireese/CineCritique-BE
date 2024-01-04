package com.techwright.cinecritique.services;

import com.techwright.cinecritique.pojo.Users;
import com.techwright.cinecritique.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public Optional<Users> findUser(String username){
        return userRepo.findByUsername(username);
    }
    public Optional<Users> createUser(String username){
        return userRepo.findUserById(username);
    }

    public Boolean searchUser(String username){
        return userRepo.existsByUsername(username);
    }
    public Boolean searchEmail(String email){
        return userRepo.existsByEmail(email);
    }




}
