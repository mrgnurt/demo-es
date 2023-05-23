package com.example.demoes.service;

import com.example.demoes.model.Transaction;
import com.example.demoes.port.TransactionPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    @Qualifier("operation")
    private TransactionPort transactionPortOperation;

    @Autowired
    @Qualifier("repo")
    private TransactionPort transactionPortRepo;

    public String indexByEsRepo(Transaction transaction) {
        transactionPortRepo.indexTransaction(transaction);
        return "success";
    }

    public String indexByEsOperation(Transaction transaction) {
        transactionPortOperation.indexTransaction(transaction);
        return "success";
    }

    public Transaction queryByESRepo(String id) {
        return transactionPortRepo.getTransaction(id);
    }

    public Transaction queryByESOperation(String id) {
        return transactionPortOperation.getTransaction(id);
    }

}
