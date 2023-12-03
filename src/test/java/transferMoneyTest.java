
import org.example.AccountNotFoundException;
import org.example.Bank;
import org.example.InsufficientFundsException;
import org.example.NegativeAmountException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class transferMoneyTest {
    private static Bank bank;

    @BeforeAll
    public static void setUp() throws NegativeAmountException {
        bank = new Bank();
        bank.createAccount("Jotaro", new BigDecimal("300.32"));
        bank.createAccount("Nori", new BigDecimal("20.10"));
    }

    @Test
    void testTransferMoneySuccess() throws AccountNotFoundException, InsufficientFundsException, NegativeAmountException {
        bank.transferMoney(1, 2, new BigDecimal("200.10"));
        assertEquals(bank.findAccount(1).getBalance(), new BigDecimal("23.22"));
    }
    @Test
    void testTransferMoneyFailed()throws AccountNotFoundException, InsufficientFundsException, NegativeAmountException
    {
        assertThrows(InsufficientFundsException.class, () -> {
            bank.transferMoney(2,1,new BigDecimal("200.10"));
        },"Account not found");
    }
}