package petsavvy.pet.controllers;

import petsavvy.pet.model.Pet;
import petsavvy.pet.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pets")
public class PetRestController {

    @Autowired
    private PetService petService;

    @GetMapping
    public List<Pet> getAllPets() {
        return petService.getAllPets();
    }

    @GetMapping("/search/name")
    public List<Pet> searchPetsByName(@RequestParam String name) {
         return petService.searchPetByNameContaining(name);
    }

    @GetMapping("/{petID}/getdiscountedprice")
    public double getDiscountedPrice(@PathVariable int petID) {
        Optional<Pet> optionalPet = petService.findByPetID(petID);
        if(optionalPet.isPresent()) {
            Pet pet = optionalPet.get();
            return petService.getFinalPrice(pet);
        }
        throw new RuntimeException("Pet not found with ID: " + petID);
    }

    @GetMapping("/{petID}")
    public Optional<Pet> getPetById(@PathVariable int petID) {
        return petService.findByPetID(petID);
    }

    @GetMapping ("/search/status")
    public List<Pet> searchPetsByStatus(@RequestParam String status) {
        return petService.findByPetStatus(status);
    }

    @PostMapping
    public Pet createPet(@RequestBody Pet pet) {
        return petService.savePet(pet);
    }

    @PutMapping("/{petID}")
    public Pet updatePet(@PathVariable int petID, @RequestBody Pet pet) {
        pet.setPetID(petID);
        return petService.savePet(pet);
    }

    @DeleteMapping("/{petID}")
    public void deletePet(@PathVariable int petID) {
        petService.deletePet(petID);
        petService.resetAutoIncrement();
    }
}
