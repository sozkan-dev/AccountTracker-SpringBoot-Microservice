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
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customerId")
    private long customerId;
    @Column(name = "CUSTOMER_NAME")
    private String name;
    @Column(name="CUSTOMER_SURNAME")
    private String surname;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Account account;
}