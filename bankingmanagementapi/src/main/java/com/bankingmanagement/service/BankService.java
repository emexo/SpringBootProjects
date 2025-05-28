package com.bankingmanagement.service;

import com.bankingmanagement.entity.Bank;
import com.bankingmanagement.exception.BankDetailsNotFoundException;
import com.bankingmanagement.model.BankRequest;
import com.bankingmanagement.model.BankTO;

import java.util.List;

public interface BankService {

    List<BankTO> findAll() throws BankDetailsNotFoundException;

    BankTO findById(String id) throws BankDetailsNotFoundException;
    List<BankTO> findByBankName(String name) throws BankDetailsNotFoundException;

    BankTO save(BankRequest bankRequest) throws BankDetailsNotFoundException;
}
