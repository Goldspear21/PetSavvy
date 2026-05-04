package petsavvy.pet.controllers;

import petsavvy.pet.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String userTable() {
        return "redirect:/user_table.html";
    }

    @GetMapping("/user-form")
    public String userForm() {
        return "redirect:/user_form.html";
    }
}
