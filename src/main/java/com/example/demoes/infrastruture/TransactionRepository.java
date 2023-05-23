package com.example.demoes.infrastruture;

import com.example.demoes.model.Transaction;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface TransactionRepository extends ElasticsearchRepository<Transaction, String> {
}
