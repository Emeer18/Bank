package Project;

import java.util.Scanner;
import Entities.Menus;
import Entities.Account; 
import Entities.BankSystem;
import java.util.ArrayList; 
import java.util.List;
import Enums.STATUS; 


public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Menus menu = new Menus();
        BankSystem bankSystem = new BankSystem();
        Account account = new Account();
        int option = 0;

        do {
            menu.initialMenu();
            option = sc.nextInt();
            sc.nextLine();

            if (option == 1) {
                System.out.println("Enter your name:");
                String name = sc.nextLine();
                System.out.println("Enter your email:");
                String email = sc.nextLine();
                System.out.println("Enter your phone number:");
                String phoneNumber = sc.nextLine();
                System.out.println("Enter your CPF:");
                String cpf = sc.nextLine();
                System.out.println("Enter your balance:");
                double balance = sc.nextDouble();
                sc.nextLine();
                System.out.println("Enter your username:");
                String user = sc.nextLine();
                System.out.println("Enter your password:");
                String password = sc.nextLine();
                System.out.println("Account created successfully!");

                Account newAccount = new Account(name, email, phoneNumber, cpf, balance, user, password);
                bankSystem.createAccount(newAccount);
            }

            if (option == 2) {

                System.out.println("Enter your username:");
                String user = sc.nextLine();
                System.out.println("Enter your password:");
                String password = sc.nextLine();

                boolean found = false;
                for (Account accounts : bankSystem.getAccounts()) {
                    if (accounts.getUser().equals(user) && accounts.getPassword().equals(password)) {
                        System.out.println("Login successful!");
                        found = true;
                        int idAccess = accounts.getId();

                        menu.accountMenu(user);
                    option = sc.nextInt();

                    switch (option) {
                        case 1:
                            System.out.println("Enter amount to deposit:");
                            double amount = sc.nextDouble();
                            bankSystem.deposit(idAccess, amount);
                            sc.nextLine();
                            break;
                        case 2:
                            
                            break;
                        case 3:
                            
                            break;
                        case 4:

                            break;
                        case 5:
                            System.out.println("Settings");
                            break;
                        case 6:
                            break;
                        default:
                            break;
                        }
                    }
                }
                    
                if (found == false) {
                    System.out.println("Invalid username or password.");
                }
            }

        } while (option != 17);

        for (Account accounts : bankSystem.getAccounts()) {
            
            System.out.println(accounts.toString());
        }
        sc.close();
    }
}
    