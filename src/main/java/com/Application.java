package com;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfiguration.class);
        BankAccountService bankAccountService = context.getBean(BankAccountService.class);

        Account account = new Account();
        account.setAccountNumber("12345");
        account.setBalance(2000.0);

        bankAccountService.deposit(account, 500.0);
        bankAccountService.withdraw(account, 300.0);
        bankAccountService.getBalance();


        context.close();
    }
}