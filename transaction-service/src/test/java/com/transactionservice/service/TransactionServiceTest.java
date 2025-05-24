package com.transactionservice.service;

import com.transactionservice.model.Transaction;
import com.transactionservice.repository.TransactionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.LocalDateTime;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TransactionServiceTest {
    private TransactionRepository repository;
    private TransactionService service;

    @BeforeEach
    void setUp() {
        repository = mock(TransactionRepository.class);
        service = new TransactionService(repository);
    }

    @Test
    void processTransaction() {
        Transaction tx = new Transaction(null, "acc001", "deposit", 500.0, LocalDateTime.now());
        when(repository.save(any(Transaction.class))).thenReturn(Mono.just(tx));

        StepVerifier.create(service.processTransaction(tx))
                .expectNext(tx)
                .verifyComplete();
    }

    @Test
    void getAllTransactions() {
        when(repository.findAll()).thenReturn(Flux.just(
                new Transaction("1", "acc001", "deposit", 500, LocalDateTime.now()),
                new Transaction("2", "acc001", "withdrawal", 200, LocalDateTime.now())
        ));

        StepVerifier.create(service.getAllTransactions())
                .expectNextCount(2)
                .verifyComplete();
    }
}
