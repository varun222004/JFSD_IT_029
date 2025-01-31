import java.util.Random;

public class BankAccount extends Account {
    public BankAccount(String accountHolder, double initialDeposit) {
        super(accountHolder, initialDeposit);
    }

    @Override
    protected String generateAccountNumber() {
        Random rand = new Random();
        return String.format("%05d", rand.nextInt(100000)); // Generates a random 5-digit number
    }

    @Override
    public void createAccount(String accountHolder, double initialDeposit) {
        this.accountHolder = accountHolder;
        this.balance = initialDeposit;
        this.accountNumber = generateAccountNumber();
        System.out.println("Account created for " + accountHolder + " with account number: " + accountNumber);
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    @Override
    public double checkBalance() {
        return balance;
    }
}
