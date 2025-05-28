package com.bankingmanagement.controller;

import com.bankingmanagement.entity.Bank;
import com.bankingmanagement.exception.BankDetailsNotFoundException;
import com.bankingmanagement.model.BankRequest;
import com.bankingmanagement.model.BankTO;
import com.bankingmanagement.service.BankService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.assertj.MockMvcTester;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BankControllerTest {

    @MockitoBean
    private BankService bankService;

    @Autowired
    private MockMvc mockMvc;

   @Test
   public void findAllWhenSuccess() throws Exception {
       List<BankTO> banks = new ArrayList<>();
       BankTO bank = new BankTO("213","234", "barclays", "uk");
       banks.add(bank);

       when(bankService.findAll()).thenReturn(banks);

      RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/banks")
               .contentType(MediaType.APPLICATION_JSON);
      mockMvc.perform(requestBuilder).andExpect(status().isOk());
   }

    @Test
    public void findAllWhenFailure() throws Exception {
        when(bankService.findAll()).thenThrow(new BankDetailsNotFoundException("bank details not exist"));

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/banks")
                .contentType(MediaType.APPLICATION_JSON);
        mockMvc.perform(requestBuilder).andExpect(status().isNotFound());
    }

    @Test
    public void findAllWhenException() throws Exception {
        when(bankService.findAll()).thenThrow(new NullPointerException());

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/banks")
                .contentType(MediaType.APPLICATION_JSON);
        mockMvc.perform(requestBuilder).andExpect(status().isInternalServerError());
    }

    @Test
    public void saveWhenSuccess() throws Exception {
        BankTO bank = new BankTO("213","234", "barclays", "uk");
        when(bankService.save(any())).thenReturn(bank);
        BankRequest bankRequest = new BankRequest();
        bankRequest.setBankCode("we");
        bankRequest.setBankName("23");

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/v1/banks")
                .content(new ObjectMapper().writeValueAsString(bankRequest))
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder).andExpect(status().isCreated());
    }
}

