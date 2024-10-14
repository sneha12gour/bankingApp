package banking_app.banking_app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Table(name="accounts")
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(name="account_holder_name")
    private String accountHolderName;
    private double balance;


        // Constructor matching the parameters in the mapper
        public Account(Long id, String accountHolderName, double balance) {
            this.id = id;
            this.accountHolderName = accountHolderName;
            this.balance = balance;
        }

        // Getters and setters (or use Lombok @Data)
        // ...

}
