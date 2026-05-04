package petsavvy.pet.repositories;

import petsavvy.pet.model.Pet;
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
public interface PetRepository extends JpaRepository<Pet, Integer> {


    List<Pet> findAll();
    Optional<Pet> findByPetID(int petID);
    List<Pet> findByPetName(String petName);
    List<Pet> findByPetStatus(String petStatus);
    List<Pet> findByPetBirthdate(LocalDate petBirthdate);
    List<Pet> findByPetNameContainingIgnoreCase(String petName);

    @Modifying
    @Transactional
    void deleteByPetID(int petID);

    @Modifying
    @Transactional
    @Query(value ="ALTER TABLE pet AUTO_INCREMENT = 1", nativeQuery= true)
    void resetAutoIncrement();

    @Query("SELECT p.petAge FROM Pet p WHERE p.petID = :petID")
    Integer findPetAgeByPetID(@Param("petID") int petID);

    @Query("SELECT p FROM Pet p WHERE p.petName = :petName")
    List<Pet> searchByPetName(@Param("petName") String petName);

    @Modifying
    @Transactional
    @Query("UPDATE Pet p SET p.petName = :petName WHERE p.petID = :petID")
    void updatePetNameByPetID(@Param("petName") String petName, @Param("petID") int petID);

    @Modifying
    @Transactional
    @Query("UPDATE Pet p SET p.petBirthdate = :petBirthdate WHERE p.petID = :petID")
    void updatePetBirthdateByPetID(@Param("petID") int petID, @Param("petBirthdate") LocalDate petBirthdate);

    @Modifying
    @Transactional
    @Query("UPDATE Pet p SET p.petPrice = :petPrice WHERE p.petID = :petID")
    void updatePetPriceByPetID(@Param("petID") int petID, @Param("petPrice") double petPrice);

    @Modifying
    @Transactional
    @Query("UPDATE Pet p SET p.petType = :petType WHERE p.petID = :petID")
    void updatePetTypeByPetID(@Param("petID") int petID, @Param("petType") String petType);

    @Modifying
    @Transactional
    @Query("UPDATE Pet p SET p.petStatus = :petStatus WHERE p.petID = :petID")
    void updatePetStatusByPetID(@Param("petID") int petID, @Param("petStatus") String status);
}
