package petsavvy.pet.services;

import petsavvy.pet.model.RescuedAnimals;
import petsavvy.pet.repositories.RescuedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class RescuedService {
    @Autowired
    private RescuedRepository rescuedRepository;

    public List<RescuedAnimals> getAllRescuedAnimals() {
        return rescuedRepository.findAll();
    }

    public Optional<RescuedAnimals> getRescuedByTagID(int tagID) {
        return rescuedRepository.findByTagID(tagID);
    }

    public List<RescuedAnimals> getRescuedByLocation(String rescueLocation) {
        return rescuedRepository.findByRescueLocationIgnoreCase(rescueLocation);
    }
    public List<RescuedAnimals> getRescuedByDate(LocalDate rescueDate) {
        return rescuedRepository.findByRescueDate(rescueDate);
    }
    public List<RescuedAnimals> getRescuedBySpecies(String species) {
        return rescuedRepository.findBySpeciesIgnoreCase(species);
    }
    public List<RescuedAnimals> getRescuedByName(String rescuedName) {
        return rescuedRepository.findByRescuedNameContainingIgnoreCase(rescuedName);
    }

    public void setLocationByTag(String rescueLocation, int tagID) {
        rescuedRepository.updateRescueLocationByTagID(rescueLocation, tagID);
    }
    public void setRescueDateByTag(LocalDate rescueDate, int tagID) {
        rescuedRepository.updateRescueDateByTagID(rescueDate, tagID);
    }
    public void setRescueSpeciesByTag(String species, int tagID) {
        rescuedRepository.updateRescueSpeciesByTagID(species, tagID);
    }
    public void setRescuedNameByTag(String rescuedName, int tagID) {
        rescuedRepository.updateRescueNameByTagId(rescuedName, tagID);
    }

    public RescuedAnimals saveEntry(RescuedAnimals rescuedAnimal) {
        return rescuedRepository.save(rescuedAnimal);
    }

    public void deleteEntry(int tagID) {
        rescuedRepository.deleteById(tagID);
    }
}
