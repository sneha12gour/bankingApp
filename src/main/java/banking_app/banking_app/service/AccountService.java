package banking_app.banking_app.service;

import banking_app.banking_app.dto.AccountDto;
import org.springframework.http.HttpStatus;

import java.util.List;


public interface AccountService {
    AccountDto createAccount(AccountDto accountDto);
    AccountDto getAccountById(Long id);
    AccountDto deposit(Long id,double amount);
    AccountDto withdraw(Long id,double amount);
    List<AccountDto> getAllAccounts();
    void deleteAccount(Long id);
}