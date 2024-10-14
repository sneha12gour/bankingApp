package banking_app.banking_app.controller;


import banking_app.banking_app.dto.AccountDto;
import banking_app.banking_app.entity.Account;
import banking_app.banking_app.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<?> addAccount(@RequestBody AccountDto accountDto) {
        try {
            return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
        } catch (Exception e) {
            // Log the error for debugging purposes
            System.out.println("Error occurred while adding account: " + e.getMessage());
            return new ResponseEntity<>("An error occurred while creating the account", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Get Account REST API
    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id) {
        AccountDto accountDto = accountService.getAccountById(id);
        return ResponseEntity.ok(accountDto);
    }

    //Deposit REST API
    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDto> deposit(@PathVariable Long id, @RequestBody Map<String, Double> request) {
        Double amount = request.get("amount");
        AccountDto accountDto = accountService.deposit(id, amount);
        return ResponseEntity.ok(accountDto);
    }

    //withdraw REST API
    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDto> withdraw(@PathVariable Long id,
                                               @RequestBody Map<String, Double> request) {

        double amount = request.get("amount");
        AccountDto accountDto = accountService.withdraw(id, amount);
        return ResponseEntity.ok(accountDto);
    }
    // Get All Accounts REST API
    @GetMapping
    public ResponseEntity<List<AccountDto>> getAllAccounts()
    {
         List<AccountDto> accounts=accountService.getAllAccounts();
         return ResponseEntity.ok(accounts);
    }
    // Delete Account REST API kuch bhi kanha
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id)
    {
        accountService.deleteAccount(id);
        return ResponseEntity.ok("Account is deleted successfully");
    }
}
