
import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. New balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount. Please enter a positive value.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: " + balance);
        } else if (amount <= 0) {
            System.out.println("Invalid withdrawal amount. Please enter a positive value.");
        } else {
            System.out.println("Insufficient funds. Withdrawal failed.");
        }
    }
}

class ATM {
    private BankAccount userAccount;

    public ATM(BankAccount userAccount) {
        this.userAccount = userAccount;
    }

    public void deposit(double amount) {
        userAccount.deposit(amount);
    }

    public void withdraw(double amount) {
        userAccount.withdraw(amount);
    }

    public void checkBalance() {
        System.out.println("Current balance: " + userAccount.getBalance());
    }
}

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter initial account balance: ");
        double initialBalance = scanner.nextDouble();
        scanner.nextLine(); 

        BankAccount userAccount = new BankAccount(initialBalance);
        ATM atm = new ATM(userAccount);

        while (true) {
            System.out.println("\nATM Menu");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    scanner.nextLine(); 
                    atm.deposit(depositAmount);
                    break;

                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawalAmount = scanner.nextDouble();
                    scanner.nextLine();
                    atm.withdraw(withdrawalAmount);
                    break;

                case 3:
                    atm.checkBalance();
                    break;

                case 4:
                    System.out.println("Exiting the ATM. Goodbye!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
