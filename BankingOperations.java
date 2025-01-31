public interface BankingOperations {
    void createAccount(String accountHolder, double initialDeposit);
    void deposit(double amount);
    void withdraw(double amount);
    double checkBalance();
}
