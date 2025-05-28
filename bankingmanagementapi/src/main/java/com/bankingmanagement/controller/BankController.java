package com.bankingmanagement.controller;

import com.bankingmanagement.exception.BankDetailsNotFoundException;
import com.bankingmanagement.model.BankRequest;
import com.bankingmanagement.model.BankTO;
import com.bankingmanagement.service.BankService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/api/v1/banks")
@RestController
public class BankController {

    @Autowired
    public BankService bankService;

    // http:localhost:9090/api/v1/banks GET
    @GetMapping
    public ResponseEntity<List<BankTO>> findAll() throws BankDetailsNotFoundException{
        log.info("Inside the BankController.findAll");
        List<BankTO> banks = bankService.findAll();

        log.info("End of BankController.findAll");
        return  new ResponseEntity<>(banks, HttpStatus.OK);
    }

    // http:localhost:9090/api/v1/banks/43534 GET   @PathVariable
    // http:localhost:9090/api/v1/banks?id=43534 GET @RequestParam

    @GetMapping("/{id}")
    public ResponseEntity<BankTO> findById(@PathVariable("id") String id) throws BankDetailsNotFoundException {
        log.info("Inside the BankController.findById, id:{} ", id);

        BankTO bank = bankService.findById(id);
        log.info("Bank details for the bank id:{} and value:{}", id, bank);

        log.info("End of BankController.findById");
        return  new ResponseEntity<>(bank, HttpStatus.OK);
    }

    // http:localhost:9090/api/v1/banks/byname?name=SBI GET
    @GetMapping("/byname")
    public ResponseEntity<List<BankTO>> findByBankName(@RequestParam("name") String name) throws BankDetailsNotFoundException {
        log.info("Inside the BankController.findByBankName, bankName:{}", name);
        List<BankTO> banks = bankService.findByBankName(name);
        log.info("Bank details:{}", banks);
        log.info("End of BankControlle.findByBankName");
        return  new ResponseEntity<>(banks, HttpStatus.OK);
    }

    // http:localhost:9090/api/v1/banks POST @RequestBody
    @PostMapping
    public ResponseEntity<BankTO> save(@RequestBody @Valid BankRequest bankRequest) throws BankDetailsNotFoundException{
        log.info("Inside the BankController.save, bankRequest:{}", bankRequest);
        BankTO bank = bankService.save(bankRequest);
        log.info("Bank details:{}", bank);
        return  new ResponseEntity<>(bank, HttpStatus.OK);
    }

}
