package com.baeldung.method.info;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.Account;
import com.BankAccountAspect;
import com.BankAccountService;
import com.WithdrawLimitException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootTest(classes = { BankAccountService.class, Account.class, BankAccountAspect.class })
@EnableAspectJAutoProxy // AspectJ 자동 프록시 생성 활성화
class BankAccountServiceIntegrationTest {

    private Account account;

    @BeforeEach
    public void setup() {
        account = new Account();
        account.setAccountNumber("12345");
        account.setBalance(2000.0);
    }

    @Autowired
    BankAccountService bankAccountService;

    @Test
    void withdraw() {
        bankAccountService.withdraw(account, 500.0);
        assertEquals(1500.0, account.getBalance());
    }

    @Test
    void withdrawWhenLimitReached() {
        assertThrows(WithdrawLimitException.class,
                () -> bankAccountService.withdraw(account, 600.0));
        assertEquals(2000.0, account.getBalance());
    }

    @Test
    void deposit() {
        bankAccountService.deposit(account, 500.0);
        assertEquals(2500.0, account.getBalance());
    }

    @Test
    void getBalance() {
        bankAccountService.getBalance();
    }
}
