package petsavvy.pet.repositories;

import petsavvy.pet.model.Customer;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    List<Customer> findAll();
    Optional<Customer> findByCustNumber(int custNumber);
    List<Customer> findByCustFirstNameContainingIgnoreCase(String custName);
    List<Customer> findByCustLastNameContainingIgnoreCase(String custName);
    List<Customer> findByCustEmail(String custEmail);
    List<Customer> findByCustPhone(String custPhone);

    @Modifying
    @Transactional
    void deleteByCustNumber(int custNumber);

    @Modifying
    @Transactional
    @Query(value ="ALTER TABLE customer AUTO_INCREMENT = 1", nativeQuery= true)
    void resetAutoIncrement();

    @Query("SELECT c FROM  Customer c WHERE c.custLastName = :custLastName")
    List<Customer> searchByCustLastName(@Param("custLastName") String custLastName);

    @Query("SELECT c FROM Customer c WHERE c.custNumber = :custNumber")
    List<Customer> searchByCustNumber(@Param("custNumber") int custNumber);

    @Modifying
    @Transactional
    @Query("UPDATE Customer c SET c.custFirstName = :custFirstName WHERE c.custNumber = :custNumber")
    void updateCustFirstNameByCustNumber(@Param("custName") String custName, @Param("custNumber") int custNumber);

    @Modifying
    @Transactional
    @Query("UPDATE Customer c SET c.custLastName = :custLastName WHERE c.custNumber = :custNumber")
    void updateCustLastNameByCustNumber(@Param("custName") String custName, @Param("custNumber") int custNumber);

    @Modifying
    @Transactional
    @Query("UPDATE Customer c SET c.custEmail = :custEmail WHERE c.custNumber = :custNumber")
    void updateCustEmailByCustNumber(@Param("custEmail") String custEmail, @Param("custNumber") int custNumber);

    @Modifying
    @Transactional
    @Query("UPDATE Customer c SET c.custPhone = :custPhone WHERE c.custNumber = :custNumber")
    void updateCustPhoneByCustNumber(@Param("custPhone") String custPhone, @Param("custNumber") int custNumber);

}
