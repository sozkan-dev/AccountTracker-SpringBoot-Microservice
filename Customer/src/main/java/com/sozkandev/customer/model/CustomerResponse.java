package com.sozkandev.customer.model;


import com.sozkandev.customer.entity.Account;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerResponse {
    private long customerId;
    private String name;
    private String surname;

    private Account account;

}