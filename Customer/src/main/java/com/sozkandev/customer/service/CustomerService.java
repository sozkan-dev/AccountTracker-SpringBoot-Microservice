package com.sozkandev.customer.service;

import com.sozkandev.customer.entity.Account;
import com.sozkandev.customer.entity.Customer;
import com.sozkandev.customer.model.CustomerRequest;
import com.sozkandev.customer.model.CustomerResponse;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustomerService {
    long addCustomer(CustomerRequest customerRequest);

    CustomerResponse getCustomerById(Long customerId);

    void deleteCustomerById(Long customerId);

    CustomerResponse editCustomerById(Long customerId, CustomerRequest customerRequest);

    long transferMoney(long fromIban, long toIban, long amount);


}