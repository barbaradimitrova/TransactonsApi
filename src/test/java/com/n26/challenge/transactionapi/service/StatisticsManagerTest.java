package com.n26.challenge.transactionapi.service;

import com.n26.challenge.transactionapi.model.Transaction;
import org.junit.Test;
import org.springframework.boot.autoconfigure.transaction.TransactionProperties;

import java.util.ArrayList;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.echocat.unittest.utils.matchers.IsEqualTo.isEqualTo;
import static org.junit.Assert.*;

public class StatisticsManagerTest {

    final static Long MINUTE_IN_MILLISECONDS = 60000L;
    @Test
    public void cleanOldTransactionsTest(){
        StatisticsManager statisticsManager = postTransactions();
        statisticsManager.cleanOldTransactions();
        final int actualSize = statisticsManager.transactionsInMemory.size();
        assertThat(actualSize, isEqualTo(2));
    }

    @Test
    public void testValidTransaction() throws Exception {
        Transaction transaction = new Transaction().setTimestamp(System.currentTimeMillis() - 1000);
        final boolean actualValidTransaction = StatisticsManager.isValidTransaction(transaction);
        assertThat(actualValidTransaction,isEqualTo(TRUE));

    }
    @Test
    public void testInvalidTransaction() throws Exception {
        Transaction transaction = new Transaction().setTimestamp(System.currentTimeMillis() - 2*MINUTE_IN_MILLISECONDS);
        final boolean actualInvalidTransaction = StatisticsManager.isValidTransaction(transaction);
        assertThat(actualInvalidTransaction,isEqualTo(FALSE));
    }

    @Test
    public void testGetTransactions() throws Exception {
        StatisticsManager statisticsManager = postTransactions();
        TransactionStatistics transactionStatistics = statisticsManager.getTransactions();
        assertThat(transactionStatistics.getCount(), isEqualTo(3));
        assertThat(transactionStatistics.getSum(), isEqualTo(100d));
        assertThat(transactionStatistics.getAvg(), isEqualTo(100d/3));
        assertThat(transactionStatistics.getMax(), isEqualTo(100d));
        assertThat(transactionStatistics.getMin(), isEqualTo(-10d));
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