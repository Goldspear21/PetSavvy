package petsavvy.pet.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "rescuedanimal")
public class RescuedAnimals {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tagID;

    @Column(name = "RescuedName", nullable = true, length = 100)
    private String rescuedName;

    @Column(name = "RescueLocation", nullable = true, length = 200)
    private String rescueLocation;

    @Column(name = "RescueDate", length = 11, nullable = false)
    private LocalDate rescueDate;

    @Column(name = "Species", length = 200, nullable = true)
    private String species;

    @Column(name = "Vaccination", nullable = false)
    private boolean vaccination;

    @Column(name = "cuteness", nullable = false)
    private boolean cuteness; // cuteness can't change :)

    public RescuedAnimals() {}

    public RescuedAnimals (int tagID, String rescuedName, String rescueLocation, LocalDate rescueDate, String species, boolean vaccination, boolean cuteness) {
        this.tagID=tagID;
        this.rescuedName=rescuedName;
        this.rescueLocation=rescueLocation;
        this.rescueDate=rescueDate;
        this.species=species;
        this.vaccination=vaccination;
        this.cuteness=cuteness;
    }

    public LocalDate getRescueDate() {
        return rescueDate;
    }
    public void setRescueDate(LocalDate rescueDate) {
        this.rescueDate = rescueDate;
    }

    public String getSpecies() {
        return species;
    }
    public void setSpecies(String species) {
        this. species = species;
    }

    public String getRescueLocation() {
        return rescueLocation;
    }
    public void setRescueLocation(String rescueLocation) {
        this.rescueLocation = rescueLocation;
    }

    public boolean getVaccination() {
        return vaccination;
    }
    public void setVaccinated(boolean vaccination) {
        this.vaccination = vaccination;
    }

    public int getTagID() {
        return tagID;
    }
    public void setTagID(int TagID) {
        this.tagID = TagID;
    }

    public boolean getCuteness() {
        return cuteness;
    }
    public void setCuteness(boolean cuteness) {
        this.cuteness = cuteness;
    }

    public boolean isVaccination() {
        return vaccination;
    }
    public void setVaccination(boolean vaccination) {
        this.vaccination = vaccination;
    }

    public String getRescuedName() {
        return rescuedName;
    }
    public void setRescuedName(String rescuedName) {
        this.rescuedName = rescuedName;
    }
}
