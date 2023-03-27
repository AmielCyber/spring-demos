package com.amiel.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("/")    // Handles all request for /
    public String showPage(){
        return "main-menu"; // Name of the page
    }
}
