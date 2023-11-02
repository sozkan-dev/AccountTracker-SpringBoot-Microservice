package com.sozkandev.transfer.entity;

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
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long transferId;

    @Column(name = "FROM_CUSTOMER")
    private long fromIban;
    @Column(name = "TO_CUSTOMER")
    private long toIban;
    @Column(name = "TRANSFER_AMOUNT")
    private long amount;
}