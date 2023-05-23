package com.example.demoes.controller;

import com.example.demoes.model.Transaction;
import com.example.demoes.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/index-by-es-repo")
    public String indexByEsRepo(@RequestBody Transaction transaction) throws Exception {
        return transactionService.indexByEsRepo(transaction);
    }

    @PostMapping("/index-by-es-operation")
    public String indexByEsOperation(@RequestBody Transaction transaction) throws Exception {
        return transactionService.indexByEsOperation(transaction);
    }

    @GetMapping("/query-by-es-repo")
    public Transaction queryByESRepo(@RequestParam(name="id") String id) throws Exception {
        return transactionService.queryByESRepo(id);
    }

    @GetMapping("/query-by-es-operation")
    public Transaction queryByESOperation(@RequestParam(name="id") String id) throws Exception {
        return transactionService.queryByESOperation(id);
    }

}
