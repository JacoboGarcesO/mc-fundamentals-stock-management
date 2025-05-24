
package com.accountservice.controller;

import com.accountservice.model.Account;
import com.accountservice.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Account> create(@RequestBody Account account) {
        return accountService.createAccount(account);
    }

    @GetMapping("/{id}")
    public Mono<Account> getById(@PathVariable String id) {
        return accountService.getAccountById(id);
    }

    @GetMapping
    public Flux<Account> getAll() {
        return accountService.getAllAccounts();
    }

    @PutMapping("/{id}")
    public Mono<Account> update(@PathVariable String id, @RequestBody Account account) {
        return accountService.updateAccount(id, account);
    }
}
