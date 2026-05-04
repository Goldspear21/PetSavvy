package petsavvy.pet.services;

import petsavvy.pet.model.Pet;
import petsavvy.pet.repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    //--get-methods--

    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    public Optional<Pet> findByPetID(int petID) {
        return petRepository.findByPetID(petID);
    }

    public List<Pet> findByPetName(String petName) {
        return petRepository.findByPetName(petName);
    }

    public List<Pet> findByPetStatus(String petStatus) {
        return petRepository.findByPetStatus(petStatus);
    }

    public List<Pet> findByPetBirthdate(LocalDate petBirthdate) {
        return petRepository.findByPetBirthdate(petBirthdate);
    }

    public List<Pet> searchPetByNameContaining(String petName) {
        return petRepository.findByPetNameContainingIgnoreCase(petName);
    }

    public List<Pet> searchByPetName(String petName) {
        return petRepository.searchByPetName(petName);
    }

    //--save-methods--

    public Pet savePet(Pet pet) {
        return petRepository.save(pet);
    }

    //--update-methods--

    public void updatePetName(int petID, String petName) {
        petRepository.updatePetNameByPetID(petName, petID);
    }

    public void updatePetBirthdate(int petID, LocalDate petBirthdate) {
        petRepository.updatePetBirthdateByPetID(petID, petBirthdate);
    }

    public void updatePetPrice(int petID, double petPrice) {
        petRepository.updatePetPriceByPetID(petID, petPrice);
    }

    public void updatePetType(int petID, String petType) {
        petRepository.updatePetTypeByPetID(petID, petType);
    }

    public void updatePetStatus(int petID, String status) {
        petRepository.updatePetStatusByPetID(petID, status);
    }

    public void resetAutoIncrement() {
        petRepository.resetAutoIncrement();
    }

    //--delete-methods--

    public void deletePet(int petID) {
        petRepository.deleteByPetID(petID);
    }

    //--custom-business-logic-methods

    public double getFinalPrice(Pet pet) {
        double discountPercentage = pet.getDiscountPercentage();
        double discountAmount = (pet.getPetPrice() * discountPercentage) / 100;

        return pet.getPetPrice() - discountAmount;
    }

}
