package com.example.demoes.infrastruture;

import com.example.demoes.model.Transaction;
import com.example.demoes.domain.repository.TransactionPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Qualifier("repo")
public class TransactionRepoImpl implements TransactionPort {

    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public List<Transaction> getTransactions(String id, String partnerId) {
        return transactionRepository.findTransactionsByIdAndPartnerId(id, partnerId, null);
    }

    @Override
    public void indexTransaction(Transaction transaction) {
        transactionRepository.save(transaction);
    }
}
