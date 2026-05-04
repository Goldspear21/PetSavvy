package petsavvy.pet.repositories;

import petsavvy.pet.model.RescuedAnimals;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface RescuedRepository extends JpaRepository<RescuedAnimals, Integer> {
    Optional<RescuedAnimals> findByTagID(int tagID);
    List<RescuedAnimals> findAll();
    RescuedAnimals save(RescuedAnimals rescuedAnimal);

    @Query("SELECT r FROM RescuedAnimals r WHERE r.rescueLocation = :rescueLocation")
    List<RescuedAnimals> findByRescueLocationIgnoreCase(String rescueLocation);

    @Query("SELECT r FROM RescuedAnimals r WHERE r.rescueDate = :rescueDate")
    List<RescuedAnimals> findByRescueDate(LocalDate rescueDate);

    @Query("SELECT r FROM RescuedAnimals r WHERE r.species = :species")
    List<RescuedAnimals> findBySpeciesIgnoreCase(String species);

    List<RescuedAnimals> findByRescuedNameContainingIgnoreCase(String rescuedName);

    @Modifying
    @Transactional
    @Query("DELETE FROM RescuedAnimals WHERE tagID = :tagID")
    void deleteById(int tagID);

    @Modifying
    @Transactional
    @Query("UPDATE RescuedAnimals r SET r.rescueLocation = :rescueLocation WHERE r.tagID = :tagID")
    void updateRescueLocationByTagID(@Param("rescueLocation") String rescueLocation,@Param("tagID") int tagID);

    @Modifying
    @Transactional
    @Query("UPDATE RescuedAnimals r SET r.rescueDate = :rescueDate WHERE r.tagID = :tagID")
    void updateRescueDateByTagID(@Param("rescueDate") LocalDate rescueDate, @Param("tagID") int tagID);

    @Modifying
    @Transactional
    @Query("UPDATE RescuedAnimals r SET r.species = :species WHERE r.tagID = :tagID")
    void updateRescueSpeciesByTagID(@Param("species") String species, @Param("tagID") int tagID);

    @Modifying
    @Transactional
    @Query("UPDATE RescuedAnimals r SET r.rescuedName = :rescuedName WHERE r.tagID = :tagID")
    void updateRescueNameByTagId(@Param("rescuedName") String rescuedName, @Param("tagID") int tagID);
}
