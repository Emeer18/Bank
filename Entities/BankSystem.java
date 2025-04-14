package Entities;

import java.util.ArrayList;
import java.util.List;
import Enums.STATUS;

public class BankSystem {

    List<Account> accounts = new ArrayList<>();
    Account accountMethods = new Account();

    public BankSystem() {
    }

    public void createAccount(Account account) {
        accounts.add(account);
        account.setId(accounts.indexOf(account) + 1);
    }

    public void deleteAccount(int id) {
        Account account = searchIdAccount(id);
        if (account != null) {
            accounts.remove(account);
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

        if (account != null) {
            account.setBalance(account.getBalance() + amount);
            System.out.println("Deposit successful!");
        } else {
            System.out.println("Account not found.");
        }
    }

}
