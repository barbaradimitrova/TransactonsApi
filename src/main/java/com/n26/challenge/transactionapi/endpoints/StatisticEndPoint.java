package com.n26.challenge.transactionapi.endpoints;


import com.n26.challenge.transactionapi.model.TransactionStatistics;
import com.n26.challenge.transactionapi.service.StatisticService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;

public class StatisticEndPoint {

    @Inject
    StatisticService statisticService;

    @RequestMapping(method= RequestMethod.GET,path="/statistics")
    public TransactionStatistics getStatistics() {
        return statisticService.getTransactionStatistics();
    }


}



