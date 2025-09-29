import java.util.ArrayList;
import java.util.List;

// Parent class: Account
class Account {
    private String accountHolder;
    private double balance;
    private List<String> transactionHistory;

    // Constructor
    public Account(String accountHolder, double initialBalance) {
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add("Account created with balance: " + initialBalance);
    }

    // Deposit Method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Deposited: " + amount + " | Balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    // Withdraw Method
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdrawn: " + amount + " | Balance: " + balance);
        } else {
            System.out.println("Insufficient balance or invalid amount!");
        }
    }

    // Show Balance
    public double getBalance() {
        return balance;
    }

    // Show Transaction History
    public void printTransactionHistory() {
        System.out.println("Transaction History for " + accountHolder + ":");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }
}

// Child Class: SavingsAccount (Inheritance + Method Overriding Example)
class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(String accountHolder, double initialBalance, double interestRate) {
        super(accountHolder, initialBalance);
        this.interestRate = interestRate;
    }

    // Overriding deposit method (adds interest on each deposit)
    @Override
    public void deposit(double amount) {
        super.deposit(amount);
        double interest = amount * interestRate / 100;
        super.deposit(interest);
        System.out.println("Interest added: " + interest);
    }
}

// Main Class
public class BankSimulation {
    public static void main(String[] args) {
        // Create Accounts
        Account acc1 = new Account("Nila P", 1000);
        SavingsAccount acc2 = new SavingsAccount("Student", 2000, 5);

        // Perform transactions
        acc1.deposit(500);
        acc1.withdraw(300);
        acc1.printTransactionHistory();

        System.out.println();

        acc2.deposit(1000);
        acc2.withdraw(500);
        acc2.printTransactionHistory();
    }
}