package petsavvy.pet.controllers;

import petsavvy.pet.model.Customer;
import petsavvy.pet.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomerRestController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/search/name")
    public List<Customer> getCustomerByName(@RequestParam String name) {
        List<Customer> results = new ArrayList<>();

        results.addAll(customerService.searchCustomerByLastNameContaining(name));
        results.addAll(customerService.searchCustomerByFirstNameContaining(name));

        return results.stream()
                .distinct()
                .toList();
    }

    @GetMapping("/{custNumber}")
    public Optional<Customer> getCustomerbyId(@PathVariable int custNumber) {
        return customerService.findByCustNumber(custNumber);
    }

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }

    @PostMapping("/{custNumber}")
    public Customer updateCustomer(@PathVariable int custNumber, @RequestBody Customer customer) {
        customer.setCustNumber(custNumber);
        return customerService.saveCustomer(customer);
    }

    @PutMapping("/{custNumber}")
    public Customer updateCustomer(@RequestBody Customer customer, @PathVariable int custNumber) {
        customer.setCustNumber(custNumber);
        return customerService.saveCustomer(customer);
    }

    @DeleteMapping("/{custNumber}")
    public void deleteCustomer(@PathVariable int custNumber) {
        customerService.deleteCustomer(custNumber);
        customerService.resetAutoIncrement();
    }
}
