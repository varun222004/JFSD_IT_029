public interface BankingOperations {
    void createAccount(String accountHolder, double initialDeposit);
    void deposit(double amount);
    void withdraw(double amount);
    double checkBalance();
}

public abstract class Account implements BankingOperations {
    protected String accountNumber;
    protected String accountHolder;
    protected double balance;

    public Account(String accountHolder, double initialDeposit) {
        this.accountHolder = accountHolder;
        this.balance = initialDeposit;
        this.accountNumber = generateAccountNumber();
    }

    protected abstract String generateAccountNumber();
}
