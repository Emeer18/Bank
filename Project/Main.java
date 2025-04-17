package Project;

import java.util.Scanner;
import Entities.Menus;
import Entities.Account;
import Entities.BankSystem;
import Entities.Logs;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Menus menu = new Menus();
        BankSystem bankSystem = new BankSystem();
        Account account = new Account();
        int menuOption = 0;

        do {
            menu.initialMenu();
            menuOption = sc.nextInt();
            sc.nextLine();


            if (menuOption == 1) {
                account.createAccount(bankSystem);
            }

            if (menuOption == 2) {

                int option = 0;
                int idAccess = 0;
                boolean found = false;
                String action = "";

                System.out.println("Enter your username:");
                String user = sc.nextLine();
                System.out.println("Enter your password:");
                String password = sc.nextLine();

                for (Account accounts : bankSystem.getAccounts()) {
                    if (accounts.getUser().equals(user) && accounts.getPassword().equals(password)) {
                        System.out.println("Login successful!");
                        found = true;
                        idAccess = accounts.getId();
                    }
                }

                if (found == true) {
                    do {
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
                                System.out.println("Enter amount to withdraw:");
                                amount = sc.nextDouble();
                                bankSystem.withdraw(amount, idAccess);
                                sc.nextLine();
                                break;
                            case 3:
                                System.out.println("Enter amount to transfer:");
                                amount = sc.nextDouble();
                                System.out.println("Enter the ID of the account to transfer to:");
                                int idTransfer = sc.nextInt();
                                bankSystem.transfer(idAccess, amount, idTransfer);
                                sc.nextLine();
                                break;
                            case 4:
                                bankSystem.checkBalance(idAccess);
                                System.out.println("Do you want to perform a new operation?\n1 - Yes\n6 - For exit to account.");
                                option = sc.nextInt();
                                sc.nextLine();
                                if (option == 1) {
                                    break;
                                } else if (option == 6) {
                                    System.out.println("Exiting account...");
                                    break;
                                } else {
                                    System.out.println("Invalid option.");
                                }
                                break;
                            case 5:
                                menu.settingsMenu();
                                int settingsOption = sc.nextInt();
                                sc.nextLine();
                                switch (settingsOption) {
                                    case 1:
                                        bankSystem.changePassword(idAccess, sc);
                                        break;
                                    case 2:
                                        bankSystem.changeUsername(idAccess, sc);
                                        break;
                                    case 3:
                                        bankSystem.deleteAccount(idAccess, sc);
                                        System.out.println("Account deleted successfully.");
                                        option = 6;
                                        break;
                                    case 4:
                                        break;
                                    default:
                                        System.out.println("Invalid option.");
                                        break;
                                }       
                            case 6:
                                System.out.println("Exiting account...");
                                break;
                            
                            default:
                                break;

                            case 7:
                                System.out.println("Logs:");
                                for (Logs logs : bankSystem.getLogs()) {
                                    if (logs.getUser().equals(user)) {
                                        logs.displayLog();
                                    }
                                }
                            
                        }
                    } while (option != 6);
                } else {
                    System.out.println("Invalid username or password.");
                }
            }

            if (menuOption != 1 && menuOption != 2 && menuOption != 3) {
                System.out.println("Invalid option. Please try again.");
            }

        } while (menuOption != 3);

        for (Account accounts : bankSystem.getAccounts()) {
            System.out.println(accounts.toString());
        }
        sc.close();
    }
}
