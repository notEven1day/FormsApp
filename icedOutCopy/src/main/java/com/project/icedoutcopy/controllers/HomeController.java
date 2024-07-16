package com.project.icedoutcopy.controllers;

import com.project.icedoutcopy.models.User;
import com.project.icedoutcopy.models.UserSession;
import com.project.icedoutcopy.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class HomeController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserSession userSession;

    @GetMapping("/")
    public String home() {
        return "homeLogin"; // This should match the name of your HTML template
    }


    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<String> handleLogin(@RequestBody Map<String, String> loginData) {
        String username = loginData.get("username");
        String password = loginData.get("password");
        System.out.println("skara");
        User user = userRepository.findByUsername(username);

        if (user != null && user.getPassword().equals(password)) {
            userSession.setLoggedInUser(user);
            // Login successful, return a success response
            return ResponseEntity.ok("Login successful");
        } else {
            // Login failed, return an error response
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Incorrect username or password");
        }
    }

    @GetMapping("/signUp")
    public String signUp() {
        return "signUp"; // Return the name of your signup HTML template
    }
}