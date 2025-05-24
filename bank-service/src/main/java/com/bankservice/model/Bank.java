
package com.bankservice.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table("banks")
public class Bank {
    @Id
    private String id;
    private String name;
    private String country;
}
