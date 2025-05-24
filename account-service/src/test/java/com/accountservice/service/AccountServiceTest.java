package com.accountservice.service;

import com.accountservice.model.Account;
import com.accountservice.repository.AccountRepository;
import com.accountservice.service.AccountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.*;


public class AccountServiceTest {

    @Mock
    private AccountRepository repository;

    @InjectMocks
    private AccountService accountService;

    private Account sampleAccount;

    @BeforeEach
    void setUp() {
        sampleAccount = new Account("1", "Alvaro Ozuna", "BancoA", 1000.0);
    }

    @Test
    void testCreateAccount() {
        when(repository.save(sampleAccount)).thenReturn(Mono.just(sampleAccount));

        StepVerifier.create(accountService.createAccount(sampleAccount))
                .expectNext(sampleAccount)
                .verifyComplete();

        verify(repository).save(sampleAccount);
    }

    @Test
    void testGetAccountById() {
        when(repository.findById("1")).thenReturn(Mono.just(sampleAccount));

        StepVerifier.create(accountService.getAccountById("1"))
                .expectNext(sampleAccount)
                .verifyComplete();

        verify(repository).findById("1");
    }

    @Test
    void testGetAllAccounts() {
        when(repository.findAll()).thenReturn(Flux.just(sampleAccount));

        StepVerifier.create(accountService.getAllAccounts())
                .expectNext(sampleAccount)
                .verifyComplete();

        verify(repository).findAll();
    }

    @Test
    void testUpdateAccount() {
        Account updatedAccount = new Account("1", "Alvaro Ozuna", "BancoA", 2000.0);
        when(repository.findById("1")).thenReturn(Mono.just(sampleAccount));
        when(repository.save(sampleAccount)).thenReturn(Mono.just(updatedAccount));

        StepVerifier.create(accountService.updateAccount("1", updatedAccount))
                .expectNext(updatedAccount)
                .verifyComplete();

        verify(repository).findById("1");
        verify(repository).save(sampleAccount);
    }
}
