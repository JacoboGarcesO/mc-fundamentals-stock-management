
package com.accountservice.repository;

import com.accountservice.model.Account;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface AccountRepository extends ReactiveCrudRepository<Account, String> {
}
