package com.n26.challenge.transactionapi.endpoints;


import com.n26.challenge.transactionapi.model.Transaction;
import com.n26.challenge.transactionapi.service.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;

@RestController
public class TransactionEndPoint {

    @Autowired
    TransactionManager transactionManager;

    final static double TIME_INTERVAL_IN_MILLISECONDS = 60000;

    @RequestMapping(method= RequestMethod.POST,path="/transactions")
    public ResponseEntity addTransaction(@RequestBody Transaction transaction) {
        if (System.currentTimeMillis() - transaction.getTimestamp() < TIME_INTERVAL_IN_MILLISECONDS){
            transactionManager.addTransaction(transaction);
           return ResponseEntity.status(HttpStatus.OK).build();
       }
        return ResponseEntity.status((HttpStatus.NO_CONTENT)).build();
    }
}

