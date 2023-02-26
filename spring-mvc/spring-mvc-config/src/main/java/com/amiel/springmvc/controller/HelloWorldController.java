package com.amiel.springmvc.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")   // Handles from /hello/
public class HelloWorldController {
    // Need a controller method to show the initial HTML form
    @RequestMapping("/showForm")
    public String showForm(){
        return "helloworld-form";
    }
    // Need a controller method to process the HTML form
    @RequestMapping("/processForm")
    public String processForm(){
        return "helloworld";
    }
    // Controller method to read from data and add data to the model
    @RequestMapping("/processFormVersionTwo")
    public String letsShoutDude(HttpServletRequest request, Model model){
        // Read the request parameter from the HTML form
        String name = request.getParameter("studentName");
        // Convert the data to all caps
        name = name.toUpperCase();
        // Create the message
        final String result = "Yo! " + name;
        // Add message to the model
        model.addAttribute("message", result);

        return "helloworld";
    }
    // RequestParam binding to argument variable
    @RequestMapping("/processFormVersionThree")
    public String processFormVersionThree(@RequestParam("studentName") String name, Model model){
        // Convert the data to all caps
        name = name.toUpperCase();
        // Create the message
        final String result = "Hey my friend from v3! " + name;
        // Add message to the model
        model.addAttribute("message", result);

        return "helloworld";
    }
}
