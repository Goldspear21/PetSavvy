package petsavvy.pet.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class AppController {

    @GetMapping("/")
    public String index(){
        return "index.html";
    }

    @GetMapping("/login")
    public String login() {
        // If the user already has a valid session, redirect them to the index page
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.isAuthenticated() && !auth.getPrincipal().equals("anonymousUser")) {
            return "redirect:/"; // Send them back to the homepage
        }
        
        return "login.html"; // Show login page if they are a guest
    }
}
