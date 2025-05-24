package com.accountservice.service;

import com.bankservice.model.Bank;
import com.bankservice.repository.BankRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.*;

public class BankServiceTest {

    @Mock
    private BankRepository repository;

    @InjectMocks
    private BankService bankService;

    private Bank sampleBank;

    @BeforeEach
    void setUp() {
        sampleBank = new Bank("1", "BancoA", "Colombia");
    }

    @Test
    void testCreateBank() {
        when(repository.save(sampleBank)).thenReturn(Mono.just(sampleBank));

        StepVerifier.create(bankService.createBank(sampleBank))
                .expectNext(sampleBank)
                .verifyComplete();

        verify(repository).save(sampleBank);
    }

    @Test
    void testGetBankById() {
        when(repository.findById("1")).thenReturn(Mono.just(sampleBank));

        StepVerifier.create(bankService.getBankById("1"))
                .expectNext(sampleBank)
                .verifyComplete();

        verify(repository).findById("1");
    }

    @Test
    void testGetAllBanks() {
        when(repository.findAll()).thenReturn(Flux.just(sampleBank));

        StepVerifier.create(bankService.getAllBanks())
                .expectNext(sampleBank)
                .verifyComplete();

        verify(repository).findAll();
    }

    @Test
    void testUpdateBank() {
        Bank updatedBank = new Bank("1", "BancoUpdated", "CountryUpdated");
        when(repository.findById("1")).thenReturn(Mono.just(sampleBank));
        when(repository.save(sampleBank)).thenReturn(Mono.just(updatedBank));

        StepVerifier.create(bankService.updateBank("1", updatedBank))
                .expectNext(updatedBank)
                .verifyComplete();

        verify(repository).findById("1");
        verify(repository).save(sampleBank);
    }
}
