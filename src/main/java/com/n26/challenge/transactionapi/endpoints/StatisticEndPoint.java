package com.n26.challenge.transactionapi.endpoints;


import com.n26.challenge.transactionapi.model.TransactionStatistics;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;

public class StatisticEndPoint {

    @Inject
    TransactionStatistics transactionStatistics;

    @RequestMapping(method= RequestMethod.GET,path="/statistics")
    TransactionStatistics getStatistics() {
        return null;
    }


}



