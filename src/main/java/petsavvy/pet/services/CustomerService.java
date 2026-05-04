package petsavvy.pet.services;

import petsavvy.pet.model.Customer;
import petsavvy.pet.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    //get method

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Optional<Customer> findByCustNumber(int custNumber) {
        return customerRepository.findByCustNumber(custNumber);
    }

    public List<Customer> findByCustFirstName(String custFirstName) {
        return customerRepository.findByCustFirstNameContainingIgnoreCase(custFirstName);
    }

    public List<Customer> findByCustLastName(String custLastName) {
        return customerRepository.findByCustLastNameContainingIgnoreCase(custLastName);
    }

    public List<Customer> findByCustEmail(String custEmail) {
        return customerRepository.findByCustEmail(custEmail);
    }

    public List<Customer> findByCustPhone(String custPhone) {
        return customerRepository.findByCustPhone(custPhone);
    }

    public List<Customer> searchCustomerByFirstNameContaining(String custFirstName) {
        return customerRepository.findByCustFirstNameContainingIgnoreCase(custFirstName);
    }

    public List<Customer> searchCustomerByLastNameContaining(String custLastName) {
        return customerRepository.findByCustLastNameContainingIgnoreCase(custLastName);
    }

    //saving methods

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    //updating
    public void updateCustomerFirstName(int custNumber, String custFirstName) {
        customerRepository.updateCustFirstNameByCustNumber(custFirstName,custNumber);
    }

    public void updateCustomerLastName(int custNumber, String custLastName) {
        customerRepository.updateCustLastNameByCustNumber(custLastName,custNumber);
    }

    public void updateCustomerEmail(int custNumber, String custEmail) {
        customerRepository.updateCustEmailByCustNumber(custEmail,custNumber);
    }

    public void updateCustomerPhone(int custNumber, String custPhone) {
        customerRepository.updateCustPhoneByCustNumber(custPhone,custNumber);
    }

    public void resetAutoIncrement() {
        customerRepository.resetAutoIncrement();
    }

    //Deleting

    public void deleteCustomer(int custNumber) {
        customerRepository.deleteByCustNumber(custNumber);
    }

}
