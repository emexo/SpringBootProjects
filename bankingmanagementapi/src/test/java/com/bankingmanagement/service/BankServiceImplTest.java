package com.bankingmanagement.service;

import com.bankingmanagement.entity.Bank;
import com.bankingmanagement.exception.BankDetailsNotFoundException;
import com.bankingmanagement.model.BankTO;
import com.bankingmanagement.repository.BankRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BankServiceImplTest {
    @Mock
    private BankRepository bankRepository;

    @InjectMocks
    private BankServiceImpl bankService;

    @Test
    public void findAllWhenBankDetailsExistThenReturnBankData() throws BankDetailsNotFoundException {
        List<Bank> banks = new ArrayList<>();
        Bank bank = new Bank();
        bank.setId("w343");
        bank.setBankName("SBI");
        bank.setBankAddress("Marathalli");
        banks.add(bank);

        when(bankRepository.findAll()).thenReturn(banks);

        List<BankTO> bankTOList = bankService.findAll();
        assertEquals(1, bankTOList.size());
    }

    @Test
    public void findAllWhenBankDetailsNotExistThenThrowException(){
        List<Bank> banks = null;
        when(bankRepository.findAll()).thenReturn(banks);
        assertThrows(BankDetailsNotFoundException.class, ()-> bankService.findAll());
    }
}
