package com.amiel.springmvc.controller;

import com.amiel.springmvc.entity.Student;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
@RequestMapping("/student")
public class StudentController {
    @RequestMapping("/showForm")
    private String showForm(Model model){
        // Create a new Student object
        Student student = new Student();
        // Add student object to the model. (attributeName, modelClass)
        model.addAttribute("student", student);

        return "student-form";
    }
    @RequestMapping("/processForm")
    public String processForm(@ModelAttribute("student") Student student){
        // Log the input data
        return "student-confirmation";
    }
}
