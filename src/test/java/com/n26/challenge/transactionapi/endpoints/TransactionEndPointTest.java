package com.n26.challenge.transactionapi.endpoints;

import com.n26.challenge.transactionapi.service.TransactionManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TransactionEndPoint.class)
public class TransactionEndPointTest {

    @MockBean
    TransactionManager transactionManager;

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void testAddTransactionOk() throws Exception {
        mockMvc.perform(post("/transactions")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"amount\":10, \"timestamp\":" + (System.currentTimeMillis() - 10) +"}"))
                .andExpect(status().isCreated());
    } @Test
    public void testAddTransactionNoContent() throws Exception {
        mockMvc.perform(post("/transactions")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"amount\":10, \"timestamp\":" + (System.currentTimeMillis() - 70000) +"}"))
                .andExpect(status().isNoContent());
    }
}