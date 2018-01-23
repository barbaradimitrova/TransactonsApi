package com.n26.challenge.transactionapi.model;


public class TransactionStatistics {

    private double sum;
    private double avg;
    private double max;
    private double min;
    private int count;


    public TransactionStatistics() {
        this.sum = 0;
        this.avg = 0;
        this.max = Long.MIN_VALUE;
        this.min = Long.MAX_VALUE;
        this.count = 0;

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

    public int getCount() {
        return count;
    }

    public TransactionStatistics setCount(int count) {
        this.count = count;
        return this;
    }

    public void computeTransactionStatistics(final Transaction transactionInMemory) {

        this.max = Math.max(this.max, transactionInMemory.getAmount());
        this.min = Math.min(this.min, transactionInMemory.getAmount());
        this.sum = transactionInMemory.getAmount() + this.sum;
        this.count ++;
        this.avg = this.sum/this.count;

    }
}
