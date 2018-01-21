package com.n26.challenge.transactionapi.endpoints;


import com.n26.challenge.transactionapi.model.Transaction;
import com.n26.challenge.transactionapi.service.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.inject.Inject;

import java.time.Instant;

import static sun.security.krb5.internal.KerberosTime.now;


public class TransactionEndPoint {

    @Inject
    TransactionService transactionService;

    @RequestMapping(method= RequestMethod.POST,path="/transactions")
    @ResponseStatus(HttpStatus.CREATED)
    public void addTransaction(@RequestBody Transaction transaction) {
        if (transaction.getTimestamp()- Instant.now().toEpochMilli() < 60){
            transactionService.addTransaction(transaction);
        }
    }
}

