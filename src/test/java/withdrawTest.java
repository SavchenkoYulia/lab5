
import org.example.BankAccount;
import org.example.InsufficientFundsException;
import org.example.NegativeAmountException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class withdrawTest {
    BankAccount bankAccount ;

    @BeforeEach
    public void setUp() {
        bankAccount = new BankAccount("Krico",new BigDecimal("10258.245"));
    }

    @Test
    void testWithdrawIsCorrect() throws NegativeAmountException, InsufficientFundsException {
        bankAccount.withdraw(new BigDecimal("200.50"));

        assertEquals(bankAccount.getBalance(), new BigDecimal("10057.745"));
    }
    @Test
    void testWithdrawThrowException()throws NegativeAmountException
    {


        Throwable exception = assertThrows(NegativeAmountException.class, () -> {
            bankAccount.withdraw(new BigDecimal("15000.10"));
        },"Lack of funds");

    }

}