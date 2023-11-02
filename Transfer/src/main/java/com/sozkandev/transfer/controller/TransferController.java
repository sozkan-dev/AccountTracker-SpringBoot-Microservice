package com.sozkandev.transfer.controller;

import com.sozkandev.transfer.entity.Transfer;
import com.sozkandev.transfer.service.TransferService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transfer")
public class TransferController {


    private TransferService transferService;

    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping
    public ResponseEntity<Long> transferMoney(@RequestBody Transfer transfer){
        return new ResponseEntity<>(transferService.transferMoney(transfer), HttpStatus.OK);
    }
}