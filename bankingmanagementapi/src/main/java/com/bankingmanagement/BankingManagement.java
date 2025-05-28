package com.bankingmanagement;

import com.bankingmanagement.service.BankServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


@EnableCaching
@Slf4j
@SpringBootApplication
public class BankingManagement {

	public static void main(String[] args) {
		SpringApplication.run(BankingManagement.class, args);
		log.info("Banking Management Application has been started");
	}

}
