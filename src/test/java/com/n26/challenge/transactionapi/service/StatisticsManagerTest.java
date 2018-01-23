package com.n26.challenge.transactionapi.service;

import com.n26.challenge.transactionapi.model.Transaction;
import com.n26.challenge.transactionapi.model.TransactionStatistics;
import org.junit.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StatisticsManagerTest {

    final static Long MINUTE_IN_MILLISECONDS = 60000L;
    @Test
    public void cleanOldTransactionsTest(){
        StatisticsManager statisticsManager = postTransactions();
        statisticsManager.cleanOldTransactions();
        final int actualSize = statisticsManager.transactionsInMemory.size();
        assertThat(actualSize, is(3));
    }

    @Test
    public void testValidTransaction() throws Exception {
        Transaction transaction = new Transaction().setTimestamp(System.currentTimeMillis() - 1000);
        final boolean actualValidTransaction = StatisticsManager.isValidTransaction(transaction);
        assertThat(actualValidTransaction,is(TRUE));

    }
    @Test
    public void testInvalidTransaction() throws Exception {
        Transaction transaction = new Transaction().setTimestamp(System.currentTimeMillis() - 2*MINUTE_IN_MILLISECONDS);
        final boolean actualInvalidTransaction = StatisticsManager.isValidTransaction(transaction);
        assertThat(actualInvalidTransaction,is(FALSE));
    }

    @Test
    public void testGetTransactions() throws Exception {
        StatisticsManager statisticsManager = postTransactions();
        TransactionStatistics transactionStatistics = statisticsManager.getTransactions();
        assertThat(transactionStatistics.getCount(), is(3));
        assertThat(transactionStatistics.getSum(), is(100d));
        assertThat(transactionStatistics.getAvg(), is(100d/3));
        assertThat(transactionStatistics.getMax(), is(100d));
        assertThat(transactionStatistics.getMin(), is(-10d));
    }
    @Test
    public void testGetTransactionsIfEmpty() throws Exception {
        StatisticsManager statisticsManager = new StatisticsManager();
        TransactionStatistics transactionStatistics = statisticsManager.getTransactions();
        assertThat(transactionStatistics.getCount(), is(0));
        assertThat(transactionStatistics.getSum(), is(0d));
        assertThat(transactionStatistics.getAvg(), is(0d));
        assertThat(transactionStatistics.getMax(), is(0d));
        assertThat(transactionStatistics.getMin(), is(0d));
    }

    private StatisticsManager postTransactions() {
        StatisticsManager statisticsManager = new StatisticsManager();
        final long timeNow = System.currentTimeMillis();
        statisticsManager.transactionsInMemory.add(new Transaction().setTimestamp(timeNow - MINUTE_IN_MILLISECONDS/2).setAmount(10));
        statisticsManager.transactionsInMemory.add(new Transaction().setTimestamp(timeNow - 2*MINUTE_IN_MILLISECONDS).setAmount(-10));
        statisticsManager.transactionsInMemory.add(new Transaction().setTimestamp(timeNow - 10*MINUTE_IN_MILLISECONDS).setAmount(10));
        statisticsManager.transactionsInMemory.add(new Transaction().setTimestamp(timeNow-10).setAmount(100));
        statisticsManager.transactionsInMemory.add(new Transaction().setTimestamp(timeNow-1).setAmount(-10));
        return statisticsManager;
    }
}