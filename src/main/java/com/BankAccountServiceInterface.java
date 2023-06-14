package com;

public interface BankAccountServiceInterface {
    void deposit(Account account, Double amount);
    void withdraw(Account account, Double amount) throws WithdrawLimitException;
    double getBalance();
}
