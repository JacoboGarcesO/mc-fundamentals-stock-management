
package com.transactionservice.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table("transactions")
public class Transaction {
    @Id
    private String id;
    private String accountId;
    private String type;
    private double amount;
    private LocalDateTime timestamp;
}
