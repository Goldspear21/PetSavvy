package petsavvy.pet.controllers;

import petsavvy.pet.model.RescuedAnimals;
import petsavvy.pet.services.RescuedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/RescuedAnimals")
public class RescuedRestController {
    @Autowired
    private RescuedService rescuedService;

    @GetMapping
    public List<RescuedAnimals> getAllRescuedAnimals() {
        return rescuedService.getAllRescuedAnimals();
    }

    @GetMapping("{tagID}")
    public Optional<RescuedAnimals> getRescuedAnimal(@PathVariable int tagID) {
        return rescuedService.getRescuedByTagID(tagID);
    }

    @GetMapping("/search/name")
    public List<RescuedAnimals> getRescuedAnimalByName(@RequestParam String name) {
        return rescuedService.getRescuedByName(name);
    }

    @PostMapping
    public RescuedAnimals createRescuedAnimal(@RequestBody RescuedAnimals rescuedAnimals) {
        return rescuedService.saveEntry(rescuedAnimals);
    }

    @PutMapping("{tagID}")
    public RescuedAnimals updateRescuedAnimal(@PathVariable int tagID, @RequestBody RescuedAnimals rescuedAnimals) {
        rescuedAnimals.setTagID(tagID);
        return rescuedService.saveEntry(rescuedAnimals);
    }

    @DeleteMapping("{tagID}")
    public void deleteRescuedAnimal(@PathVariable int tagID) {
        rescuedService.deleteEntry(tagID);
    }

}
