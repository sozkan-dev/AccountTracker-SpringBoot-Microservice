package com.sozkandev.transfer.service;

import com.sozkandev.transfer.entity.Transfer;
import com.sozkandev.transfer.repository.TransferRepository;
import org.springframework.stereotype.Service;

@Service
public class TransferServiceImpl implements TransferService {

    private TransferRepository transferRepository;

    public TransferServiceImpl(TransferRepository transferRepository) {
        this.transferRepository = transferRepository;
    }

    @Override
    public long transferMoney(Transfer transfer) {

        Transfer transfer1 = Transfer.builder()
                .fromIban(transfer.getFromIban())
                .toIban(transfer.getToIban())
                .amount(transfer.getAmount())
                .build();
        transferRepository.save(transfer1);
        return transfer1.getTransferId();
    }
}