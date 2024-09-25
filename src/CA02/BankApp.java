package CA02;


// Main class for the bank application
public class BankApp {
    public static void main(String[] args) {
        // Create a shared bank account object with an initial balance of 1000
        BankAccount account = new BankAccount(1000);

        // Create and start threads for deposit and withdraw operations
        DepositThread depositThread = new DepositThread(account, 500);
        WithdrawThread withdrawThread = new WithdrawThread(account, 300);

        // Start both threads
        depositThread.start();
        withdrawThread.start();

        // Wait for both threads to finish
        try {
            depositThread.join();
            withdrawThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Display the final balance
        System.out.println("Final balance: " + account.getBalance());
    }
}


// BankAccount class representing a shared resource
class BankAccount {
    private int balance;

    // Constructor to initialize balance
    public BankAccount(int initialBalance) {
        this.balance = initialBalance;
    }

    // Synchronized method for withdrawing money
    public synchronized void withdraw(int amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds! Current balance: " + balance);
            return;
        }
        System.out.println(Thread.currentThread().getName() + " is trying to withdraw: " + amount);
        balance -= amount;
        System.out.println(Thread.currentThread().getName() + " completed withdrawal. Remaining balance: " + balance);
    }

    // Synchronized method for depositing money
    public synchronized void deposit(int amount) {
        System.out.println(Thread.currentThread().getName() + " is depositing: " + amount);
        balance += amount;
        System.out.println(Thread.currentThread().getName() + " completed deposit. Current balance: " + balance);
    }

    // Method to check balance
    public synchronized int getBalance() {
        return balance;
    }
}

// DepositThread class representing the deposit operation
class DepositThread extends Thread {
    private BankAccount account;
    private int amount;

    // Constructor
    public DepositThread(BankAccount account, int amount) {
        this.account = account;
        this.amount = amount;
    }

    // Run method to deposit money
    @Override
    public void run() {
        account.deposit(amount);
    }
}

// WithdrawThread class representing the withdraw operation
class WithdrawThread extends Thread {
    private BankAccount account;
    private int amount;

    // Constructor
    public WithdrawThread(BankAccount account, int amount) {
        this.account = account;
        this.amount = amount;
    }

    // Run method to withdraw money
    @Override
    public void run() {
        account.withdraw(amount);
    }
}

