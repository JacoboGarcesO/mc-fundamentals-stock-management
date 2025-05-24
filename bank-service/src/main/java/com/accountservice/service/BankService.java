
package com.accountservice.service;

import com.bankservice.model.Bank;
import com.bankservice.repository.BankRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class BankService {

    private final BankRepository repository;

    public Mono<Bank> createBank(Bank bank) {
        return repository.save(bank);
    }

    public Mono<Bank> getBankById(String id) {
        return repository.findById(id);
    }

    public Flux<Bank> getAllBanks() {
        return repository.findAll();
    }

    public Mono<Bank> updateBank(String id, Bank updatedBank) {
        return repository.findById(id)
            .flatMap(existing -> {
                existing.setName(updatedBank.getName());
                existing.setCountry(updatedBank.getCountry());
                return repository.save(existing);
            });
    }
}
