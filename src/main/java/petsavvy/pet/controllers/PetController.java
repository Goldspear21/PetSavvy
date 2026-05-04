package petsavvy.pet.controllers;

import petsavvy.pet.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class PetController {

    @Autowired
    private PetService petService;

    @GetMapping("/pets")
    public String petTable() {
        return "redirect:/pet_table.html";
    }
    
    @GetMapping("/pet-form")
    public String petForm() {
        return "redirect:/pet_form.html";
    }

}
