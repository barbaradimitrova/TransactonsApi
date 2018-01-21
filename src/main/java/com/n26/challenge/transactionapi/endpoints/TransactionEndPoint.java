package com.n26.challenge.transactionapi.endpoints;


import com.n26.challenge.transactionapi.model.Transaction;
import com.n26.challenge.transactionapi.service.TransactionManager;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.inject.Inject;

import java.time.Instant;


public class TransactionEndPoint {

    @Inject
    TransactionManager transactionManager;
    final static double TIME_INTERVAL_IN_SECONDS = 60;

    @RequestMapping(method= RequestMethod.POST,path="/transactions")
    @ResponseStatus(HttpStatus.CREATED)
    public void addTransaction(@RequestBody Transaction transaction) {
        if (transaction.getTimestamp()- Instant.now().toEpochMilli() < TIME_INTERVAL_IN_SECONDS){
            transactionManager.addTransaction(transaction);
        }
    }
}

