package com.bankingmanagement.controller;

import com.bankingmanagement.exception.BankDetailsNotFoundException;
import com.bankingmanagement.model.BankRequest;
import com.bankingmanagement.model.BankTO;
import com.bankingmanagement.service.BankService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class BankControllerTest1 {

    @MockitoBean
    public BankService bankService;

    @Autowired
    public MockMvc mockMvc;

    @Test
    public void findAllWhenBankDetailsExistThenReturnBankData() throws Exception {
        List<BankTO> banks = new ArrayList<>();
        BankTO bank = new BankTO("213", "234", "barclays", "uk");
        banks.add(bank);

        when(bankService.findAll()).thenReturn(banks);


       RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/banks")
                .contentType("application/json");

        mockMvc.perform(requestBuilder).andExpect(status().isOk());
    }

    @Test
    public void findAllWhenBankDetailsNotExistThenThrowException() throws Exception {
        when(bankService.findAll()).thenThrow(BankDetailsNotFoundException.class);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/banks")
                .contentType("application/json");

        mockMvc.perform(requestBuilder).andExpect(status().isNotFound());
    }

    @Test
    public void saveWhenSuccess() throws Exception {
        // Arrange
        BankTO expectedBank = new BankTO("1", "123", "Test Bank", "Test Address");
        BankRequest bankRequest = new BankRequest();
        bankRequest.setBankCode("123");
        bankRequest.setBankName("Test Bank");

        when(bankService.save(any(BankRequest.class))).thenReturn(expectedBank);

        // Act & Assert
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/v1/banks")
                .content(new ObjectMapper().writeValueAsString(bankRequest))
                .contentType("application/json");

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk());
    }

    @Test
    public void saveWhenFailure() throws Exception {
        // Arrange
        BankRequest bankRequest = new BankRequest();
        bankRequest.setBankCode("123");
        bankRequest.setBankName("Test Bank");

        when(bankService.save(any(BankRequest.class))).thenThrow(new BankDetailsNotFoundException("Bank details not found"));

        // Act & Assert
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/v1/banks")
                .content(new ObjectMapper().writeValueAsString(bankRequest))
                .contentType("application/json");

        mockMvc.perform(requestBuilder)
                .andExpect(status().isNotFound());
    }
}
