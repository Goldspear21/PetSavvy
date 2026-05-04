package petsavvy.pet.controllers;

import petsavvy.pet.services.RescuedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RescuedController {
    @Autowired
    private RescuedService rescuedService;

    @GetMapping("/rescued")
    public String rescuedTable() {
        return "redirect:/rescued_table.html";
    }

    @GetMapping("/rescue-form")
    public String rescuedForm() {
        return "redirect:/rescued_form.html";
    }
}

