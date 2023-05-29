package com.example.demoes.application.controller;

import com.example.demoes.model.Transaction;
import com.example.demoes.domain.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/index-by-es-repo")
    public String indexByEsRepo(@RequestBody Transaction transaction) {
        return transactionService.indexByEsRepo(transaction);
    }

    @PostMapping("/index-by-es-operation")
    public String indexByEsOperation(@RequestBody Transaction transaction) {
        return transactionService.indexByEsOperation(transaction);
    }

    @GetMapping("/query-by-es-repo")
    public List<Transaction> queryByESRepo(@RequestParam(name="id", required = false) String id,
                                           @RequestParam(name="partnerId", required = false) String partnerId) throws Exception {
        return transactionService.queryByESRepo(id, partnerId);
    }

    @GetMapping("/query-by-es-operation")
    public List<Transaction> queryByESOperation(@RequestParam(name="id", required = false) String id,
                                                @RequestParam(name="partnerId", required = false) String partnerId) throws Exception {
        return transactionService.queryByESOperation(id, partnerId);
    }

}
