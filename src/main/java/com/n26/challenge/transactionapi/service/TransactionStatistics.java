package com.n26.challenge.transactionapi.service;


import com.n26.challenge.transactionapi.model.Transaction;

public class TransactionStatistics {

    private double timestamp;
    private double createdAt;
    private double sum;
    private double avg;
    private double max;
    private double min;
    private long count;


    protected TransactionStatistics(final Transaction transaction, double createdAt)
    {
        this.timestamp = transaction.getTimestamp();
        this.sum = transaction.getAmount();
        this.avg = transaction.getAmount();
        this.max = transaction.getAmount();
        this.min = transaction.getAmount();
        this.count = 1;
        this.createdAt = createdAt;
    }

    public double getSum() {
        return sum;
    }

    public TransactionStatistics setSum(double sum) {
        this.sum = sum;
        return this;
    }

    public double getAvg() {
        return avg;
    }

    public TransactionStatistics setAvg(double avg) {
        this.avg = avg;
        return this;
    }

    public double getMax() {
        return max;
    }

    public TransactionStatistics setMax(double max) {
        this.max = max;
        return this;
    }

    public double getMin() {
        return min;
    }

    public TransactionStatistics setMin(double min) {
        this.min = min;
        return this;
    }

    public long getCount() {
        return count;
    }

    public TransactionStatistics setCount(long count) {
        this.count = count;
        return this;
    }
}
