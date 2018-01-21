package com.n26.challenge.transactionapi.service;


import com.n26.challenge.transactionapi.model.Transaction;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class TransactionService {

    private final Queue<Transaction> transQueue;


    public TransactionService() {
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


    private void process() {
        while (true) {
            Transaction transaction = transQueue.poll();
            //process transaction

        }
    }
}
