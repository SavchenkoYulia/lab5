package org.example;
import java.math.BigDecimal;

public class BankAccount {
    private static int accountNumber = 0;
    private int ID;
    private String accountName;
    private BigDecimal balance = new BigDecimal("0.0");

    public BankAccount(String accountName,BigDecimal initialDeposit) {
        this.accountName = accountName;
        this.balance=initialDeposit;
        ID=++accountNumber;
    }
    public void deposit(BigDecimal amount) {
        balance = balance.add(amount);
    }

    public void withdraw(BigDecimal amount) throws NegativeAmountException, InsufficientFundsException {
        if (balance.compareTo(BigDecimal.valueOf(0)) < 0){
            throw new NegativeAmountException("There are no funds in the account");
        } else if (balance.compareTo(amount) < 0){
            throw new InsufficientFundsException("insufficient funds");
        } else {
            balance = balance.subtract(amount);
        }

    }
    public String getAccountSummary() {
        String str =accountName+" "+ID+" "+balance ;
        return str;
    }
    public static int getAccountNumber() {
        return accountNumber;
    }

    public int getID() {
        return ID;
    }

    public String getAccountName() {
        return accountName;
    }

    public BigDecimal getBalance() {
        return balance;
    }
}
