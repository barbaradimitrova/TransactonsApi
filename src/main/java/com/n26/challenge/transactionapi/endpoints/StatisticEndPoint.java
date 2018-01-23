package com.n26.challenge.transactionapi.endpoints;


import com.n26.challenge.transactionapi.model.TransactionStatistics;
import com.n26.challenge.transactionapi.service.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatisticEndPoint {

    @Autowired
    TransactionManager transactionManager;

    @RequestMapping(method = RequestMethod.GET, path = "/statistics")
    public TransactionStatistics getStatistics() {
        return transactionManager.getTransactionStatistics();
    }
}



