package com.example.demoes.domain.service;

import com.example.demoes.model.Transaction;
import com.example.demoes.domain.repository.TransactionPort;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    @Qualifier("operation")
    private TransactionPort transactionPortOperation;

    @Autowired
    @Qualifier("repo")
    private TransactionPort transactionPortRepo;

    public String indexByEsRepo(Transaction transaction) {
        System.out.println(new Gson().toJson(transaction));
        transactionPortRepo.indexTransaction(transaction);
        return "success";
    }

    public String indexByEsOperation(Transaction transaction) {
        transactionPortOperation.indexTransaction(transaction);
        return "success";
    }

    public List<Transaction> queryByESRepo(String id, String partnerId) {
        return transactionPortRepo.getTransactions(id, partnerId);
    }

    public List<Transaction> queryByESOperation(String id, String partnerId) {
        return transactionPortOperation.getTransactions(id, partnerId);
    }
}
