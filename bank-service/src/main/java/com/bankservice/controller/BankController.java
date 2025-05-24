
package com.bankservice.controller;

import com.bankservice.model.Bank;
import com.bankservice.service.BankService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/banks")
@RequiredArgsConstructor
public class BankController {

    private final BankService bankService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Bank> create(@RequestBody Bank bank) {
        return bankService.createBank(bank);
    }

    @GetMapping("/{id}")
    public Mono<Bank> getById(@PathVariable String id) {
        return bankService.getBankById(id);
    }

    @GetMapping
    public Flux<Bank> getAll() {
        return bankService.getAllBanks();
    }

    @PutMapping("/{id}")
    public Mono<Bank> update(@PathVariable String id, @RequestBody Bank bank) {
        return bankService.updateBank(id, bank);
    }
}
