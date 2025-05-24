
package com.accountservice.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table("accounts")
public class Account {
    @Id
    private String id;
    private String customerName;
    private String bankId;
    private double balance;
}
