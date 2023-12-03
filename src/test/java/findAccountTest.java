import org.example.AccountNotFoundException;
import org.example.Bank;
import org.example.BankAccount;
import org.example.NegativeAmountException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class findAccountTest {

    private Bank bank;

    @BeforeEach
    public void setUp() throws NegativeAmountException {
    bank = new Bank();
    bank.createAccount("Kawasaki",new BigDecimal("1246.300"));
    bank.createAccount("Cargo", new BigDecimal("1520.400"));
    bank.createAccount("Crico",new BigDecimal("50.50"));
    bank.createAccount("Esrtyper",new BigDecimal("1900.39"));
    }

    @Test
    void testFindAccountSuccessful() throws AccountNotFoundException {
        BankAccount bankTest = new BankAccount("Giro", new BigDecimal("1500.542"));
        assertEquals(bank.findAccount(2).getAccountSummary(),"Giro 2 1500.542");
    }
    @Test
    void testFindAccountThrowsException()throws AccountNotFoundException{
        assertThrows(AccountNotFoundException.class, () -> {
            bank.findAccount(5);
        },"Account not found");
    }
}