
package com.transactionservice.service;

import com.transactionservice.model.Transaction;
import com.transactionservice.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository repository;

    public Mono<Transaction> processTransaction(Transaction transaction) {
        transaction.setTimestamp(LocalDateTime.now());
        return repository.save(transaction);
    }

    public Flux<Transaction> getAllTransactions() {
        return repository.findAll();
    }

    public Flux<Transaction> getTransactionsByAccountId(String accountId) {
        return repository.findByAccountId(accountId);
    }
}
