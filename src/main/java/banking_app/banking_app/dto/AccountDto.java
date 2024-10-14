package banking_app.banking_app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor      // Lombok will generate the default no-arg constructor
@AllArgsConstructor     // Lombok will generate the all-args constructor
public class AccountDto {
    private Long id;
    private String accountHolderName;
    private double balance;

    // Lombok will generate getters, setters, toString, equals, and hashCode
}
