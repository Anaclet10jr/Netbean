
class BankAccount {
    String accountNumber;
    String ownerName;
    double balance;

    // Constructor
    BankAccount(String number, String name, double initialBalance) {
        accountNumber = number;
        ownerName = name;
        balance = initialBalance;
    }

    // Deposits money
    void deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
            System.out.println("Deposit successful: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdraws money
    void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance = balance - amount;
            System.out.println("Withdrawal successful: " + amount);
        }
    }

    // Returns current balance
    double getBalance() {
        return balance;
    }

    // Displays account information
    void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Owner: " + ownerName);
        System.out.printf("Balance: %.2f%n", getBalance());
    }

    // Transfers money to another account
    void transfer(BankAccount anotherAccount, double amount) {
        if (amount <= 0) {
            System.out.println("Invalid transfer amount.");
        } else if (amount > balance) {
            System.out.println("Transfer failed: insufficient balance.");
        } else {
            balance = balance - amount;
            anotherAccount.balance = anotherAccount.balance + amount;
            System.out.println("Transfer successful: " + amount);
        }
    }
}

public class BankAccountDemo {
    public static void main(String[] args) {
        BankAccount account1 =
            new BankAccount("ACC001", "Alice", 1000);

        BankAccount account2 =
            new BankAccount("ACC002", "David", 500);

        System.out.println("===== INITIAL ACCOUNTS =====");
        account1.displayAccountInfo();
        account2.displayAccountInfo();

        System.out.println("\n===== TRANSACTIONS =====");
        account1.deposit(300);
        account2.deposit(200);

        account1.withdraw(100);
        account2.withdraw(50);

        // Alice transfers money to David
        account1.transfer(account2, 250);

        System.out.println("\n===== FINAL ACCOUNTS =====");
        account1.displayAccountInfo();
        account2.displayAccountInfo();
    }
}
