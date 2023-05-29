package com.example.demoes.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Field;

@Data
@Builder
public class Customer {
    @Field(name = "id")
    private String id;

    @Field(name = "name")
    private String name;

    @Field(name = "age")
    private Integer age;
}
