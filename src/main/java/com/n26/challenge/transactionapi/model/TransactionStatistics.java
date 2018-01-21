package com.n26.challenge.transactionapi.model;


public class TransactionStatistics {

    private double sum;
    private double avg;
    private double max;
    private double min;
    private long count;

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
