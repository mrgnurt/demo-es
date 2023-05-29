package com.example.demoes.domain.service;

import com.example.demoes.model.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TransactionService {

    String indexByEsRepo(Transaction transaction);

    String indexByEsOperation(Transaction transaction);

    List<Transaction> queryByESRepo(String id, String partnerId);

    List<Transaction> queryByESOperation(String id, String partnerId);
}
