package com.example.demoes.infrastruture;

import com.example.demoes.model.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface TransactionRepository extends ElasticsearchRepository<Transaction, String> {
    Page<Transaction> findTransactionByPartnerId(String partnerId, Pageable pageable);

    Transaction findTransactionByIdAndPartnerId(String id, String partnerId);
}
