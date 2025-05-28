package com.bankingmanagement.repository;

import com.bankingmanagement.entity.Bank;
import com.bankingmanagement.model.BankTO;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class BankRepositoryCustom {
    private final MongoTemplate mongoTemplate;

    public BankRepositoryCustom(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public List<Bank> findBankByName(String bankName) {
        Query query = new Query();
        query.addCriteria(Criteria.where("bankName").is(bankName));
        return mongoTemplate.find(query, Bank.class);
    }
}
