package com.n26.challenge.transactionapi.service;


import com.n26.challenge.transactionapi.model.Transaction;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class TransactionManager {
    private final Queue<Transaction> transQueue;
    StatisticsManager statisticsManager;


    public TransactionManager(StatisticsManager statisticsManager) {
        this.statisticsManager = statisticsManager;
        this.transQueue = new ConcurrentLinkedQueue<>();
        Thread thread = new Thread(){
            public void run() {
                process();
            };
        };
        thread.start();
    }

    public void addTransaction(Transaction transaction){
        this.transQueue.add(transaction);
    }
    public TransactionStatistics getTransactionStatistics(){
        return statisticsManager.getTransactions();
    }

    private void process() {
        while (true) {
            Transaction transaction = transQueue.poll();
            if (transaction != null){
                statisticsManager.processTransaction(transaction);
            }

        }
    }
}
