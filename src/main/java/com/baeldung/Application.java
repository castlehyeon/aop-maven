package com.baeldung;

import com.Account;
import com.AopConfiguration;
import com.BankAccountService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfiguration.class);

        BankAccountService bankAccountService = context.getBean(BankAccountService.class);
        Account account = new Account();
        account.setAccountNumber("12345");
        account.setBalance(2000.0);

        // Test the methods
        System.out.println("*******deposit=========================================================");
        bankAccountService.deposit(account, 500.0);
        System.out.println("*******withdraw=========================================================");
        bankAccountService.withdraw(account, 300.0);
        bankAccountService.getBalance();

        context.close();
    }
}
