package com.bankingmanagement.repository;

import com.bankingmanagement.entity.Bank;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BankRepository extends MongoRepository<Bank, String> {
}
