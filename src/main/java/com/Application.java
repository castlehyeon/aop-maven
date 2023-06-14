package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

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

/*
@Component
public class Application {
    @Autowired
    private BankAccountService bankAccountService;

    public static void main(String[] args) {
AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfiguration.class);
        Application application = context.getBean(Application.class);

//        bankAccountService = context.getBean(BankAccountService.class);
        Account account = new Account();
        account.setAccountNumber("12345");
        account.setBalance(2000.0);

        // Test the methods
//        bankAccountService.deposit(account, 500.0);
//        bankAccountService.withdraw(account, 300.0);
//        bankAccountService.getBalance();

        application.bankAccountService.deposit(account, 500.0);
        application.bankAccountService.withdraw(account, 300.0);
        application.bankAccountService.getBalance();

        context.close();
            }
}
 */