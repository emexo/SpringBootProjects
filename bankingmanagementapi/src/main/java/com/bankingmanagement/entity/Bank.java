package com.bankingmanagement.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@Document(collection = "bank")
public class Bank {
    @Id
    private String id;

    @Field("bankCode")
    private String bankCode;

    @Field("bankName")
    private String bankName;

    @Field("bankAddress")
    private String bankAddress;

}
