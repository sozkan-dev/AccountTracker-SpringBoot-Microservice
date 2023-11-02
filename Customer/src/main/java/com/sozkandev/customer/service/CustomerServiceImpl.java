package com.sozkandev.customer.service;

import com.sozkandev.customer.entity.Customer;
import com.sozkandev.customer.exception.CustomerCustomException;
import com.sozkandev.customer.external.client.TransferService;
import com.sozkandev.customer.external.request.Transfer;
import com.sozkandev.customer.model.CustomerRequest;
import com.sozkandev.customer.model.CustomerResponse;
import com.sozkandev.customer.repository.CustomerRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;
    private TransferService transferService;

    public CustomerServiceImpl(CustomerRepository customerRepository, TransferService transferService) {
        this.customerRepository = customerRepository;
        this.transferService = transferService;
    }

    @Override
    public long addCustomer(CustomerRequest customerRequest) {
        log.info("Adding Customer!");
        Customer customer = Customer.builder()
                                    .name(customerRequest.getName())
                                    .surname(customerRequest.getSurname())
                                    .account(customerRequest.getAccount())
                                    .build();
        customerRepository.save(customer);
        log.info("Customer Created!");
        return customer.getCustomerId();
    }

    @Override
    public CustomerResponse getCustomerById(Long customerId) {
        log.info("Get the customer for customerId: {}", customerId);
        Customer customer = customerRepository.findById(customerId)
                                              .orElseThrow(() -> new CustomerCustomException("CUSTOMER NOT FOUND!", "NOT_FOUND"));
        CustomerResponse customerResponse = new CustomerResponse();
        BeanUtils.copyProperties(customer, customerResponse);
        return customerResponse;
    }

    @Override
    public void deleteCustomerById(Long customerId) {
        customerRepository.deleteById(customerId);

    }

    @Override
    public CustomerResponse editCustomerById(Long customerId, CustomerRequest customerRequest) {
        Customer customer = customerRepository.findById(customerId)
                                              .orElseThrow(() -> new CustomerCustomException("CUSTOMER NOT FOUND!", "NOT_FOUND"));
        customer.setName(customerRequest.getName());
        customer.setSurname(customerRequest.getSurname());
        customer.getAccount()
                .setBalance(customerRequest.getAccount()
                                           .getBalance());
        customer.getAccount()
                .setAccountType(customerRequest.getAccount()
                                               .getAccountType());
        customerRepository.save(customer);
        CustomerResponse customerResponse = new CustomerResponse();
        BeanUtils.copyProperties(customer, customerResponse);
        return customerResponse;
    }

    @Override
    public void transferMoney(long fromIban, long toIban, long amount) {
        Customer c1 = customerRepository.findById(customerRepository.findCustomerIdByIban(fromIban)).orElseThrow();
        log.info("c1 customer: {}", c1.getCustomerId());
        Customer c2 = customerRepository.findById(customerRepository.findCustomerIdByIban(toIban)).orElseThrow();
        log.info("c2 customer: {}", c2.getCustomerId());

        Transfer transfer = Transfer.builder()
                                    .amount(amount)
                                    .fromIban(fromIban)
                                    .toIban(toIban)
                                    .build();
        transferService.transferMoney(transfer);
        c1.getAccount()
          .setBalance(c1.getAccount()
                        .getBalance() - amount);
        c2.getAccount()
          .setBalance(c2.getAccount()
                        .getBalance() + amount);
        customerRepository.save(c1);
        customerRepository.save(c2);
        log.info("Money Transfer From {} To {} Applied Succesfully!", c1.getCustomerId(), c2.getCustomerId());

    }
}