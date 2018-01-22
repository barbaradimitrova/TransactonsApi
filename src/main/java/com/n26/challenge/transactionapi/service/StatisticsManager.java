package com.n26.challenge.transactionapi.service;

import com.n26.challenge.transactionapi.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.*;
import java.util.stream.Collectors;


public class StatisticsManager {

    final static long TIME_INTERVAL_IN_MILLISECONDS = 60000L;
    LinkedList<Transaction> transactionsInMemory;

    @Autowired
    public StatisticsManager() {
        transactionsInMemory = new LinkedList<>();
    }

    void processTransaction(Transaction transaction) {
        transactionsInMemory.add(transaction);
        cleanOldTransactions();
    }


    public TransactionStatistics getTransactions() {
        TransactionStatistics responseStatistics = new TransactionStatistics();
        transactionsInMemory.stream()
                .filter(StatisticsManager::isValidTransaction)
                .forEach(responseStatistics::computeTransactionStatistics);

        if (responseStatistics.getCount() == 0) {
            responseStatistics.setMax(0);
            responseStatistics.setMin(0);
            cleanOldTransactions();
        }
        return responseStatistics;
    }

    protected void cleanOldTransactions() {

        Iterator<Transaction> it = transactionsInMemory.iterator();
        while (it.hasNext()) {
            Transaction transaction = it.next();
            if (!isValidTransaction(transaction)) {
                it.remove();
            }
        }
    }

    public static boolean isValidTransaction(@RequestBody Transaction transaction) {
        return System.currentTimeMillis() - transaction.getTimestamp() < TIME_INTERVAL_IN_MILLISECONDS;
    }


}
