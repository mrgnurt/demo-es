package com.example.demoes.infrastruture;

import com.example.demoes.model.Transaction;
import com.example.demoes.port.TransactionPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("repo")
public class TransactionRepoImpl implements TransactionPort {

    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public Transaction getTransaction(String id) {
        return transactionRepository.findById(id).orElse(null);
    }

    @Override
    public void indexTransaction(Transaction transaction) {
        transactionRepository.save(transaction);
    }
}
