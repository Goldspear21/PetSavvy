package petsavvy.pet.model;

import jakarta.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int custNumber;

    @Column(name = "custfirstname", length = 100, nullable = false)
    private String custFirstName;

    @Column(name = "custlastname", length = 100, nullable = false)
    private String custLastName;

    @Column(name="custemail", length = 100, nullable = false)
    private String custEmail;

    @Column(name = "custphone", length = 20, nullable = false)
    private String custPhone;

    public Customer() {}

    public Customer(int custNumber, String custFirstName, String custLastName, String custEmail, String custPhone) {
        this.custNumber = custNumber;
        this.custFirstName = custFirstName;
        this.custLastName = custLastName;
        this.custEmail = custEmail;
        this.custPhone = custPhone;
    }

    public void setCustNumber(int custNumber){ this.custNumber = custNumber; }
    public int getCustNumber(){return custNumber;}

    public void setCustFirstName(String custFirstName) {this.custFirstName = custFirstName;}
    public String getCustFirstName(){return custFirstName;}

    public void setCustLastName(String custLastName) {this.custLastName = custLastName;}
    public String getCustLastName(){return custLastName;}

    public void setCustEmail(String custEmail) {this.custEmail = custEmail;}
    public String getCustEmail(){return custEmail;}

    public void setCustPhone(String custPhone) {this.custPhone = custPhone;}
    public String getCustPhone(){return custPhone;}
}
