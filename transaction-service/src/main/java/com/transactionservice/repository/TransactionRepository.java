
package com.transactionservice.repository;

import com.transactionservice.model.Transaction;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface TransactionRepository extends ReactiveCrudRepository<Transaction, String> {
    Flux<Transaction> findByAccountId(String accountId);
}
