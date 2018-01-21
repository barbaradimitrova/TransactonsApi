package com.n26.challenge.transactionapi.service;


import com.n26.challenge.transactionapi.model.Transaction;

import java.time.Instant;
import java.util.List;

import static java.time.Instant.now;

public class StatisticsManager {

    TransactionStatistics transactionStatistics;
    Transaction[] transactionsInMemory;
    List<Transaction> transactionsKept;

    void processTransaction(Transaction transaction){
        new TransactionStatistics(transaction, now().toEpochMilli());
    }

    public TransactionStatistics getTransactions() {
        for (int i=0; i<transactionsInMemory.length; i++){
            if (transactionsInMemory[i].getTimestamp() - now().toEpochMilli() < 3600){
                transactionsKept.add(transactionsInMemory[i]);
                if (transactionsInMemory[i].getAmount()>=transactionStatistics.getMax()){
                    transactionStatistics.setMax(transactionsInMemory[i].getAmount());
                }else{
                    transactionStatistics.setMin(transactionsInMemory[i].getAmount());
                }
            }
        }
        return null ;
    }
}
