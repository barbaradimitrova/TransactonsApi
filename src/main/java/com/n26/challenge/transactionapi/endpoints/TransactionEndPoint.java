package com.n26.challenge.transactionapi.endpoints;


import com.n26.challenge.transactionapi.model.Transaction;
import com.n26.challenge.transactionapi.service.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static com.n26.challenge.transactionapi.service.StatisticsManager.isValidTransaction;

@RestController
public class TransactionEndPoint {

    @Autowired
    TransactionManager transactionManager;


    @RequestMapping(method = RequestMethod.POST, path = "/transactions")
    public ResponseEntity addTransaction(@RequestBody Transaction transaction) {
        if (isValidTransaction(transaction)) {
            transactionManager.addTransaction(transaction);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.status((HttpStatus.NO_CONTENT)).build();
    }
}

