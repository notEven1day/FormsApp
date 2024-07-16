package com.project.icedoutcopy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainShopPageController {
    //u will need all the repositories here
    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard"; // Return the name of your signup HTML template
    }
}
