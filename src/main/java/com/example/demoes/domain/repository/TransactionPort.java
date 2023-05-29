package com.example.demoes.domain.repository;

import com.example.demoes.model.Transaction;

import java.util.List;

public interface TransactionPort {
    List<Transaction> getTransactions(String id, String partnerId);

    void indexTransaction(Transaction transaction);
}
