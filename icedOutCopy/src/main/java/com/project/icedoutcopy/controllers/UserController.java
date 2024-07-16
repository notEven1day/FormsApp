package com.project.icedoutcopy.controllers;

import com.project.icedoutcopy.dtos.UserDTO;
import com.project.icedoutcopy.models.User;
import com.project.icedoutcopy.models.UserSession;
import com.project.icedoutcopy.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserSession userSession;

    @GetMapping("/api/userinfo")
    @ResponseBody
    public ResponseEntity<User> getUserInfo() {
        User loggedInUser = userSession.getLoggedInUser();
        if (loggedInUser != null) {
            return ResponseEntity.ok(loggedInUser);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }


    @PostMapping("/signup")
    @ResponseBody
    public ResponseEntity<String> handleSignUp(@RequestBody UserDTO userDTO) {

        System.out.println("skaraspenis");
        String username = userDTO.getUsername();
        String password = userDTO.getPassword();
        String firstName = userDTO.getFirstName();
        String lastName = userDTO.getLastName();
        String email = userDTO.getEmail();
        String phoneNumber = userDTO.getPhoneNumber();


        try {
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setEmail(email);
            user.setPhoneNumber(phoneNumber);
            userRepository.save(user);


            return ResponseEntity.ok("User created successfully");

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create user");
        }
    }
}


