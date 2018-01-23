package com.n26.challenge.transactionapi.util;

import com.n26.challenge.transactionapi.service.StatisticsManager;
import com.n26.challenge.transactionapi.service.TransactionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class TransactionConfiguration {

    @Bean
    public TransactionManager transactionManager(StatisticsManager statisticsManager) {
        return new TransactionManager(statisticsManager);
    }

    @Bean
    public StatisticsManager statisticsManager() {
        return new StatisticsManager();
    }
}
