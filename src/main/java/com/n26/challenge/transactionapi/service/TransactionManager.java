package com.n26.challenge.transactionapi.service;


import com.n26.challenge.transactionapi.model.Transaction;
import com.n26.challenge.transactionapi.model.TransactionStatistics;
import org.springframework.stereotype.Service;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@Service
public class TransactionManager {
    private final Queue<Transaction> queueOfTransactions;
    StatisticsManager statisticsManager;


    public TransactionManager(StatisticsManager statisticsManager) {
        this.statisticsManager = statisticsManager;
        this.queueOfTransactions = new ConcurrentLinkedQueue<>();
        Thread thread = new Thread(){
            public void run() {
                process();
            };
        };
        thread.start();
    }

    public void addTransaction(Transaction transaction){
        this.queueOfTransactions.add(transaction);
    }
    public TransactionStatistics getTransactionStatistics(){
            return statisticsManager.getTransactions();
    }

    private void process() {
        while (true) {
            Transaction transaction = queueOfTransactions.poll();
            if (transaction != null){
                statisticsManager.processTransaction(transaction);
            }
        }
    }
}
