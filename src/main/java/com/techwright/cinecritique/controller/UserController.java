package com.techwright.cinecritique.controller;

import com.techwright.cinecritique.pojo.Movies;
import com.techwright.cinecritique.pojo.Users;
import com.techwright.cinecritique.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

   /* @PostMapping
    public ResponseEntity<Users> createUser(@RequestBody Map<String, String> payload){
        return new ResponseEntity<Users>(userService.createUser(payload.get("username"), payload.get("password")), HttpStatus.CREATED);
    }*/

/*    @GetMapping("/{username}")
    public ResponseEntity<Optional<Users>> getUser(@PathVariable String username){
        return new ResponseEntity<Optional<Users>>(userService.searchUser(username), HttpStatus.OK);
    }*/

    @GetMapping("/{username}")
    public ResponseEntity<Optional<Users>> findUser(@PathVariable String username){
        return new ResponseEntity<Optional<Users>>(userService.findUser(username), HttpStatus.OK);
    }

}
