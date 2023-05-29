package com.example.demoes.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Mapping;

import java.util.Date;
import java.util.List;

@Data
@Builder
@Document(indexName = "transaction")
@Mapping(mappingPath = "transaction-index.json")
public class Transaction {
    @Id
    private String id;

    @Field(type = FieldType.Long, name = "amount")
    private Long amount;

    @Field(type = FieldType.Keyword, name = "partnerId")
    private String partnerId;

    @Field(name = "customerId", type = FieldType.Keyword)
    private String customerId;

    @Field(name = "customerId1", type = FieldType.Keyword)
    private String customerId1;

    @Field(name = "test", type = FieldType.Keyword)
    private String test;

    @Field(name = "test2", type = FieldType.Keyword)
    private String test2;

    @Field(name = "date")
    private Date date;

    @Field(type = FieldType.Text, name = "info")
    private String info;

    @Field(name = "customer")
    private Customer customer;

    @Field(name = "customerList")
    private List<Customer> customerList;

    @Field(name = "customerListNested")
    private List<Customer> customerListNested;


}
