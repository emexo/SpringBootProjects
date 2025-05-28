package com.bankingmanagement.service;

import com.bankingmanagement.entity.Bank;
import com.bankingmanagement.exception.BankDetailsNotFoundException;
import com.bankingmanagement.model.BankRequest;
import com.bankingmanagement.model.BankTO;
import com.bankingmanagement.repository.BankRepository;
import com.bankingmanagement.repository.BankRepositoryCustom;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class BankServiceImpl implements BankService{

    @Autowired
    private BankRepository bankRepository;

    @Autowired
    private BankRepositoryCustom bankRepositoryCustom;

    @PreAuthorize("hasRole('ADMIN')")
    @Override
    public List<BankTO> findAll() throws BankDetailsNotFoundException {
        log.info("Inside the BankServiceImpl.findAll");
        List<Bank> banks =  bankRepository.findAll();

        if(CollectionUtils.isEmpty(banks)){
            log.error("Bank details not exist");
            throw  new BankDetailsNotFoundException("Bank details not exist");
        }

        List<BankTO> bankTOList = banks.stream().map(bank -> {
            BankTO bankTO = new BankTO(bank.getId(), bank.getBankCode(), bank.getBankName(), bank.getBankAddress());
            return bankTO;
        }).collect(Collectors.toList());

        log.info("End of BankServiceImpl.findAll");
        return  bankTOList;
    }

    @Override
    public BankTO findById(String id) throws BankDetailsNotFoundException {
        log.info("Inside the BankServiceImpl.findById, id:{}", id);
        Optional<Bank> bankOptional =  bankRepository.findById(id);

        if(bankOptional.isEmpty()){
            log.error("Bank details not exist");
            throw  new BankDetailsNotFoundException("Bank details not exist");
        }

        Bank bank = bankOptional.get();

        BankTO bankTO = new BankTO(bank.getId(), bank.getBankCode(), bank.getBankName(), bank.getBankAddress());
        log.info("End of BankServiceImpl.findById");
        return bankTO;
    }

    @Override
    public List<BankTO> findByBankName(String name) throws BankDetailsNotFoundException {
        log.info("Inside the BankServiceImpl.findByBankName, name:{}", name);
        List<Bank> banks =  bankRepositoryCustom.findBankByName(name);

        if(CollectionUtils.isEmpty(banks)){
            log.error("Bank details not exist");
            throw  new BankDetailsNotFoundException("Bank details not exist");
        }

        List<BankTO> bankTOList = banks.stream().map(bank -> {
            BankTO bankTO = new BankTO(bank.getId(), bank.getBankCode(), bank.getBankName(), bank.getBankAddress());
            return bankTO;
        }).collect(Collectors.toList());

        log.info("End of BankServiceImpl.findByBankName");
        return bankTOList;
    }

    @Override
    public BankTO save(BankRequest bankRequest) throws BankDetailsNotFoundException {
        return null;
    }
}
