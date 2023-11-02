package com.sozkandev.customer.controller;


import com.sozkandev.customer.entity.Account;
import com.sozkandev.customer.entity.Customer;
import com.sozkandev.customer.model.AccountType;
import com.sozkandev.customer.model.CustomerRequest;
import com.sozkandev.customer.model.CustomerResponse;
import com.sozkandev.customer.repository.CustomerRepository;
import com.sozkandev.customer.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<Long> addCustomer(@RequestBody CustomerRequest customerRequest){
        long customerId = customerService.addCustomer(customerRequest);
        return new ResponseEntity<>(customerId, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> getCustomerById(@PathVariable("id") Long customerId){
        CustomerResponse customerResponse = customerService.getCustomerById(customerId);
        return new ResponseEntity<>(customerResponse, HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<CustomerResponse> editCustomerById(@PathVariable("id") Long customerId, @RequestBody CustomerRequest customerRequest){
        CustomerResponse customerResponse = customerService.editCustomerById(customerId, customerRequest);
        return new ResponseEntity<>(customerResponse, HttpStatus.OK);
    }

    @PostMapping("/moneytransfer")
    public ResponseEntity<Long> transferMoney(@RequestParam long fromIban, @RequestParam long toIban, @RequestParam long amount){
        long transferId = customerService.transferMoney(fromIban, toIban, amount);
        return new ResponseEntity<>(transferId, HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCustomerById(@PathVariable("id") Long customerId){
        customerService.deleteCustomerById(customerId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}