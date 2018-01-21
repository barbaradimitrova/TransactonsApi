package com.n26.challenge.transactionapi.endpoints;


import com.n26.challenge.transactionapi.model.Transaction;
import com.n26.challenge.transactionapi.service.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.inject.Inject;


public class TransactionEndPoint {

    @Inject
    TransactionService transactionService;

    @RequestMapping(method= RequestMethod.POST,path="/transactions")
    @ResponseStatus(HttpStatus.CREATED)
    void addTransaction(@RequestBody Transaction transaction) {
            
    }
}

