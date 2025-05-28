package com.bankingmanagement.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.lang.NonNull;

@ToString
@Setter
@Getter
public class BankRequest {
    @NonNull
    private String bankName;
    @NonNull
    private String bankCode;
    private String bankAddress;
}
