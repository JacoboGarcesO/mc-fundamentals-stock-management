
package com.accountservice.service;

import com.accountservice.model.Account;
import com.accountservice.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository repository;

    public Mono<Account> createAccount(Account account) {
        return repository.save(account);
    }

    public Mono<Account> getAccountById(String id) {
        return repository.findById(id);
    }

    public Flux<Account> getAllAccounts() {
        return repository.findAll();
    }

    public Mono<Account> updateAccount(String id, Account updatedAccount) {
        return repository.findById(id)
            .flatMap(existing -> {
                existing.setCustomerName(updatedAccount.getCustomerName());
                existing.setBankId(updatedAccount.getBankId());
                existing.setBalance(updatedAccount.getBalance());
                return repository.save(existing);
            });
    }
}
