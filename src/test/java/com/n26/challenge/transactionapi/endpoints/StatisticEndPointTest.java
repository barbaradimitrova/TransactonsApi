package com.n26.challenge.transactionapi.endpoints;

import com.n26.challenge.transactionapi.model.TransactionStatistics;
import com.n26.challenge.transactionapi.service.StatisticsManager;
import com.n26.challenge.transactionapi.service.TransactionManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(StatisticEndPoint.class)
public class StatisticEndPointTest {
    @MockBean
    private TransactionManager transactionManager;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetStatistics() throws Exception {

        when(transactionManager.getTransactionStatistics()).thenReturn(new TransactionStatistics());

        mockMvc.perform(get("/statistics"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.sum", is(0.0)))
                .andExpect(jsonPath("$.avg", is(0.0)))
                .andExpect(jsonPath("$.count", is(0)));
    }




}