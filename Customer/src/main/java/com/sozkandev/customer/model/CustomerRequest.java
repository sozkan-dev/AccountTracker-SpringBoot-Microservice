package com.sozkandev.customer.model;

import com.sozkandev.customer.entity.Account;
import lombok.Data;

@Data
public class CustomerRequest {

    private String name;
    private String surname;
    private Account account;
}