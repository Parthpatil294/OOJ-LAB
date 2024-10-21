


import java.util.*;

class Account {

    private String customerName;

    private String accountNumber;

     double balance;



   

    public Account(String customerName, String accountNumber, double initialBalance) {

        this.customerName = customerName;

        this.accountNumber = accountNumber;

        this.balance = initialBalance;

    }



    

    public void deposit(double amount) {

        balance += amount;

        System.out.println("Deposited: " + amount);

    }



    

    public void displayBalance() {

        System.out.println("Current Balance: " + balance);

    }



    
    public boolean withdraw(double amount) {

        if (amount <= balance) {

            balance -= amount;

            System.out.println("Withdrawn: " + amount);

            return true;

        } else {

            System.out.println("Insufficient balance for withdrawal.");

            return false;

        }

    }



    

    public double getBalance() {

        return balance;

    }

}





class SavingsAccount extends Account {

    private double interestRate;



    public SavingsAccount(String customerName, String accountNumber, double initialBalance, double interestRate) {

        super(customerName, accountNumber, initialBalance);

        this.interestRate = interestRate;

    }



    

    public void addInterest() {

        double interest = balance * interestRate / 100;

        deposit(interest);

        System.out.println("Interest added: " + interest);

    }

}


class CurrentAccount extends Account {

    private static final double MIN_BALANCE = 500.0;

    private static final double SERVICE_CHARGE = 50.0;



    public CurrentAccount(String customerName, String accountNumber, double initialBalance) {

        super(customerName, accountNumber, initialBalance);

    }



  

    public boolean withdraw(double amount) {

        if (amount > balance) {

            System.out.println("Insufficient balance for withdrawal.");

            return false;

        }

        if (balance - amount < MIN_BALANCE) {

            System.out.println("Minimum balance violation. Service charge applied.");

            balance -= SERVICE_CHARGE; 

            System.out.println("Service charge: " + SERVICE_CHARGE);

        }

        return super.withdraw(amount);

    }

}


public class Bank {

    public static void main(String[] args) {

        

        SavingsAccount savingsAccount = new SavingsAccount("Alice", "SA123", 1000.0, 5.0);

        savingsAccount.displayBalance();

        savingsAccount.addInterest();

        savingsAccount.displayBalance();

        savingsAccount.withdraw(200);

        savingsAccount.displayBalance();



        

        CurrentAccount currentAccount = new CurrentAccount("Bob", "CA456", 600.0);

        currentAccount.displayBalance();

        currentAccount.withdraw(200);

        currentAccount.displayBalance();

        currentAccount.withdraw(1000); 

        currentAccount.displayBalance();

    }

}

