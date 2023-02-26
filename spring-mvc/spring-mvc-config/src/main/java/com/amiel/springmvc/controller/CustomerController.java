package com.amiel.springmvc.controller;

import com.amiel.springmvc.entity.Customer;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    // Pre-process all web requests coming into our Controller.
    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        // Removes leading and trailing whitespaces and trims it to null if true is passed.
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        // For every string class, then apply the StringTrimmerEditor.
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
    @RequestMapping("/showForm")
    public String showForm(Model model){
        model.addAttribute("customer", new Customer());
        return "customer-form";
    }
    @RequestMapping("/processForm") // @Valid validates the customer and checks if it has errors in BindingResult
    public String processForm(
            @Valid @ModelAttribute("customer") Customer customer, BindingResult result ){
        if(result.hasErrors()){
            return "customer-form";
        }else{
            return "customer-confirmation";
        }
    }
}
