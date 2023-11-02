package com.sozkandev.customer.entity;

import com.sozkandev.customer.model.AccountType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "account_id")
    private long accountId;
    @Column(name = "BALANCE")
    private long balance;
    @Column(name = "ACCOUNT_TYPE")
    private AccountType accountType;
    @Column(name = "IBAN")
    private long iban;

    //@OneToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "customer_id", referencedColumnName = "customerId")
    //private Customer customer;
}