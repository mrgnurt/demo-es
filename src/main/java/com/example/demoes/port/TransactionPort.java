package com.example.demoes.port;

import com.example.demoes.model.Transaction;

public interface TransactionPort {
    Transaction getTransaction(String id);

    void indexTransaction(Transaction transaction);
}
