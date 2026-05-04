package petsavvy.pet.controllers;

import petsavvy.pet.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customer")
    public String getTable() {
        return "redirect:/customer_table.html";
    }

    @GetMapping("/customer-form")
    public String getForm() {
        return "redirect:/customer_form.html";
    }
}
