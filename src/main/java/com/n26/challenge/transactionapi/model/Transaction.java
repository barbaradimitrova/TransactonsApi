package com.n26.challenge.transactionapi.model;


import org.springframework.web.bind.annotation.RequestBody;

public class Transaction {

    private double amount;
    private long timestamp;

    public double getAmount() {
        return amount;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public Transaction setAmount(double amount) {
        this.amount = amount;
        return this;
    }

    public Transaction setTimestamp(long timestamp) {
        this.timestamp = timestamp;
        return this;
    }

}

