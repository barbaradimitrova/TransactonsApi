package com.n26.challenge.transactionapi.endpoints;


import com.n26.challenge.transactionapi.model.TransactionStatictics;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;

public class StasticsEndPoint {

    @Inject
    TransactionStatictics transactionStatictics;

    @RequestMapping(method= RequestMethod.GET,path="/statistics")
     TransactionStatictics getStatistics() {
        return null;
    }


}



