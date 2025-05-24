
package com.transactionservice.controller;

import com.transactionservice.model.Transaction;
import com.transactionservice.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Transaction> create(@RequestBody Transaction transaction) {
        return transactionService.processTransaction(transaction);
    }

    @GetMapping
    public Flux<Transaction> getAll() {
        return transactionService.getAllTransactions();
    }

    @GetMapping("/account/{accountId}")
    public Flux<Transaction> getByAccount(@PathVariable String accountId) {
        return transactionService.getTransactionsByAccountId(accountId);
    }
}
