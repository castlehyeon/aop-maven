package com.baeldung.method.info;

import com.AccountOperation;
import com.BankAccountAspect;
import org.junit.jupiter.api.Test;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankAccountAspectTest {

    @Test
    public void testGetAccountOperationInfo() {
        BankAccountService bankAccountService = new BankAccountService();

        BankAccountAspect bankAccountAspect = new BankAccountAspect();
        ProxyFactory proxyFactory = new ProxyFactory(bankAccountService);
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor(new NameMatchMethodPointcut(), bankAccountAspect);
        proxyFactory.addAdvisor(advisor);

        BankAccountService proxy = (BankAccountService) proxyFactory.getProxy();

        String result = proxy.deposit(100);
        assertEquals("Depositing 100", result);

        result = proxy.withdraw(50);
        assertEquals("Withdrawing 50", result);

        result = proxy.transfer(50, "123456789");
        assertEquals("Transferring 50 to account 123456789", result);
    }

    static class BankAccountService {
        @AccountOperation(operation = "Deposit")
        public String deposit(int amount) {
            return "Depositing " + amount;
        }

        @AccountOperation(operation = "Withdraw")
        public String withdraw(int amount) {
            return "Withdrawing " + amount;
        }

        @AccountOperation(operation = "Transfer")
        public String transfer(int amount, String accountNumber) {
            return "Transferring " + amount + " to account " + accountNumber;
        }
    }
}
