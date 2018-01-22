package com.n26.challenge.transactionapi.service;

import com.n26.challenge.transactionapi.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;


public class StatisticsManager {

    final static double TIME_INTERVAL_IN_MILLISECONDS = 60000;
    ArrayList<Transaction> transactionsInMemory;

    @Autowired
    public StatisticsManager() {
        transactionsInMemory = new ArrayList<>();
    }

    void processTransaction(Transaction transaction) {

        transactionsInMemory.add(transaction);
        for (int i = 0; i < transactionsInMemory.size(); i++) {
            if (System.currentTimeMillis() - transactionsInMemory.get(i).getTimestamp() > TIME_INTERVAL_IN_MILLISECONDS) {
                transactionsInMemory.remove(i);
            }
        }
    }

    public TransactionStatistics getTransactions() {
        TransactionStatistics responseStatistics = new TransactionStatistics();
        transactionsInMemory.stream()
                .filter(transactionInMemory -> System.currentTimeMillis() - transactionInMemory.getTimestamp() < TIME_INTERVAL_IN_MILLISECONDS)
                .forEach(responseStatistics::computeTransactionStatistics);

        if (responseStatistics.getCount() == 0) {
            responseStatistics.setMax(0);
            responseStatistics.setMin(0);
        }
        return responseStatistics;
    }


}
