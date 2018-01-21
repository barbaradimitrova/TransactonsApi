package com.n26.challenge.transactionapi.endpoints;


import com.n26.challenge.transactionapi.service.TransactionStatistics;
import com.n26.challenge.transactionapi.service.TransactionManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;

public class StatisticEndPoint {

    @Inject
    TransactionManager transactionManager;

    @RequestMapping(method= RequestMethod.GET,path="/statistics")
    public TransactionStatistics getStatistics() {
        return transactionManager.getTransactionStatistics();
    }


}



