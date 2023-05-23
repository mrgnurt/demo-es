package com.example.demoes.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

@Data
@Builder
@Document(indexName = "transaction")
public class Transaction {
    @Id
    private String id;

    @Field(type = FieldType.Long, name = "amount")
    private Long amount;

    @Field(type = FieldType.Keyword, name = "partnerId")
    private String partnerId;

    @Field(type = FieldType.Date, name = "date")
    private Date date;

    @Field(type = FieldType.Text, name = "info")
    private String info;


}
