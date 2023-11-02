package com.sozkandev.customer.external.client;


import com.sozkandev.customer.external.request.Transfer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "TRANSFER-SERVICE/transfer")
public interface TransferService {

    @PostMapping
    public ResponseEntity<Long> transferMoney(@RequestBody Transfer transfer);

}