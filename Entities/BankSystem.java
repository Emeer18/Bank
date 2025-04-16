package Entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankSystem {

    List<Account> accounts = new ArrayList<>();
    Account accountMethods = new Account();

    public BankSystem() {
    }

    public void addAccount(Account account) {
        accounts.add(account);
        account.setId(accounts.indexOf(account) + 1);
    }

    public void deleteAccount(int id, Scanner sc) {
        Account account = searchIdAccount(id);
        System.out.println("Enter your password to confirm delete the account:");
        String password = sc.nextLine();

        if (account != null) {
            if(account.getPassword().equals(password)) {
                System.out.println("Account deleted successfully!");
                accounts.remove(account);
            } 
            else {
                System.out.println("Incorrect password.");
            }
        } 
        else {
            System.out.println("Account not found.");
        }
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public Account searchIdAccount(int id) {
        for (Account account : accounts) {
            if (account.getId() == id) {
                return account;
            }
        }
        return null;
    }

    public void deposit(int idAccess, double amount) {

        Account account = searchIdAccount(idAccess);
        if (amount > 0) {
                account.setBalance(account.getBalance() + amount);
                System.out.println("Deposit successful!");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount, int idAccess) {
        Account account = searchIdAccount(idAccess);

        if (account != null) {
            if (amount > 0 && amount <= account.getBalance()) {
                account.setBalance(account.getBalance() - amount);
            }
        }

        else {
            System.out.println("Account not found.");
            return;
        }
    }

    public void transfer(int idAccess, double amount, int idTransfer) {
        Account account = searchIdAccount(idAccess);
        Account accountTransfer = searchIdAccount(idTransfer);

        if (accountTransfer == null) {
            System.out.println("Account not found.");
            return;
        }

        if (account != null) {

            if (amount > 0 && amount <= account.getBalance()) {
                account.setBalance(account.getBalance() - amount);
                accountTransfer.setBalance(accountTransfer.getBalance() + amount);
            }

        } else {
            System.out.println("Account not found.");
        }

    }

    public void checkBalance(int idAccess) {
        Account account = searchIdAccount(idAccess);
        if (account != null) {
            System.out.println("Your balance is: " + account.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }

    public void changePassword(int idAccess, Scanner sc) {
        Account account = searchIdAccount(idAccess);
        if (account != null) {
            System.out.println("Enter your current password:");
            String currentPassword = sc.nextLine();
            if (account.getPassword().equals(currentPassword)) {
                System.out.println("Enter new password!");
                String newPassword = sc.nextLine();
                account.setPassword(newPassword);
                System.out.println("Password changed successfully!");
                return;
            }
            else{
                System.out.println("Incorrect password.");
            }
        } else {
            System.out.println("Account not found.");
        }
    }
    public void changeUsername(int idAccess, Scanner sc) {
        Account account = searchIdAccount(idAccess);
        if (account != null) {
            System.out.println("Enter your current password:");
            String currentPassword = sc.nextLine();
            if (account.getPassword().equals(currentPassword)) {
                System.out.println("Enter new username!");
                String newUsername = sc.nextLine();
                account.setUser(newUsername);
                System.out.println("Username changed successfully!");
                return;
            }
            else{
                System.out.println("Incorrect password.");
            }
        } else {
            System.out.println("Account not found.");
        }
    }
}
