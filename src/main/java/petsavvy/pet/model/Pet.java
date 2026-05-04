package petsavvy.pet.model;

import java.time.LocalDate;

import org.hibernate.annotations.Formula;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;


//bhargav - 412002531
@Entity
@Table(name = "pet", uniqueConstraints = {
@UniqueConstraint(columnNames = {"PetName", "PetBirthdate","PetPrice","PetType", "PetStatus", "PetVaccinated"})
})
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int petID;

    @Column(name="PetName", length= 100,  nullable=false)
    private String petName;

    @Column(name="PetBirthdate", length= 100,  nullable=false)
    private LocalDate petBirthdate;

    @Column(name="PetPrice", nullable = false)
    private double petPrice;

    @Column(name="PetType", length=100, nullable = false)
    private String petType; // cat dog bird or anything

    @Column(name="PetStatus",  length=100, nullable=false)
    private String petStatus; //available, sold, adopted or reserved

    @Column(name="PetVaccinated", nullable = false)
    private boolean petVaccinated;

    @Formula("LEAST(GREATEST((TIMESTAMPDIFF(YEAR, pet_birthdate, CURDATE()) - 5) * 5.0, 0), 50.0)")
    private double discountPercentage;

    @Formula("TIMESTAMPDIFF(YEAR, pet_birthdate, CURDATE())")
    private Integer petAge;


    public Pet() {
    }

    public Pet(int petID, String petName, LocalDate petBirthdate, double petPrice, String petType, String petStatus) {
        this.petID = petID;
        this.petName = petName;
        this.petBirthdate = petBirthdate;
        this.petPrice = petPrice;
        this.petType = petType;
        this.petStatus=petStatus;
    }

    public int getPetID() {return petID;}

    public void setPetID(int petID) {this.petID = petID;}

    public void setPetName(String petname){
        this.petName=petname;
    }

    public void setPetBirthdate(LocalDate birthdate){
        this.petBirthdate=birthdate;
    }

    public String getPetName(){
        return this.petName;
    }

    public LocalDate getPetBirthdate(){
        return this.petBirthdate;
    }

    public double getPetPrice() {
        return petPrice;
    }

    public void setPetPrice(double petPrice) {
        this.petPrice = petPrice;
    }

    public String getPetType() {
        return petType;
    }

    public void setPetType(String petType) {
        this.petType = petType;
    }

    public String getPetStatus() {
        return petStatus;
    }

    public void setPetStatus(String petStatus) {
        this.petStatus = petStatus;
    }

    public boolean isPetVaccinated() {
        return petVaccinated;
    }

    public void setPetVaccinated(boolean petVaccinated) {
        this.petVaccinated = petVaccinated;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public Integer getPetAge() {
        return petAge;
    }


}
