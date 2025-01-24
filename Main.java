import java.util.Random;
import java.util.Scanner;

// Interface defining banking operations
interface BankingOperations {
    void createAccount(String accountHolder, double initialDeposit);
    void deposit(double amount);
    void withdraw(double amount);
    double checkBalance();
}

// Abstract class implementing the BankingOperations interface
abstract class Account implements BankingOperations {
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

// Class extending the Account abstract class
class BankAccount extends Account {
    public BankAccount(String accountHolder, double initialDeposit) {
        super(accountHolder, initialDeposit);
    }

    @Override
    protected String generateAccountNumber() {
        Random rand = new Random();
        int number = rand.nextInt(90000) + 10000; // Generate a random 5-digit number
        return String.valueOf(number);
    }

    @Override
    public void createAccount(String accountHolder, double initialDeposit) {
        // Implementation here
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    @Override
    public double checkBalance() {
        return balance;
    }
}

// Main class with a menu-driven program
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount account = null;

        while (true) {
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter account holder name: ");
                    String name = scanner.next();
                    System.out.print("Enter initial deposit: ");
                    double deposit = scanner.nextDouble();
                    account = new BankAccount(name, deposit);
                    System.out.println("Account created successfully!");
                    break;
                case 2:
                    if (account != null) {
                        System.out.print("Enter amount to deposit: ");
                        double amount = scanner.nextDouble();
                        account.deposit(amount);
                        System.out.println("Amount deposited successfully!");
                    } else {
                        System.out.println("No account found. Please create an account first.");
                    }
                    break;
                case 3:
                    if (account != null) {
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = scanner.nextDouble();
                        account.withdraw(withdrawAmount);
                    } else {
                        System.out.println("No account found. Please create an account first.");
                    }
                    break;
                case 4:
                    if (account != null) {
                        System.out.println("Current balance: " + account.checkBalance());
                    } else {
                        System.out.println("No account found. Please create an account first.");
                    }
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
