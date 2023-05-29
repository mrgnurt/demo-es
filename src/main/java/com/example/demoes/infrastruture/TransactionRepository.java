package com.example.demoes.infrastruture;

import com.example.demoes.model.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface TransactionRepository extends ElasticsearchRepository<Transaction, String> {
    Page<Transaction> findTransactionsByPartnerId(String partnerId, Pageable pageable);

    List<Transaction> findTransactionsByIdAndPartnerId(String id, String partnerId, Pageable pageable);

    @Query("{\"bool\":{\"must\":[{\"term\":{\"partnerId\":\"?0\"}}]}}")
    List<Transaction> findTransactionsPartnerIdCustomQuery(String partnerId, Pageable pageable);
}
