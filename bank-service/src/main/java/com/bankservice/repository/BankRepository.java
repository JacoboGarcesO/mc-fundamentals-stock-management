
package com.bankservice.repository;

import com.bankservice.model.Bank;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface BankRepository extends ReactiveCrudRepository<Bank, String> {
}
