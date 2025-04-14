package Entities;

public class Menus {

    public void initialMenu() {

        StringBuilder sb = new StringBuilder();

        sb.append("Welcome to EBank!\n");
        sb.append("Enter an option to continue:\n");
        sb.append("1 - Create Account\n");
        sb.append("2 - Access Account\n");
        sb.append("3 - Exit the system\n");

        System.out.println(sb.toString());
    }

    public void accountMenu(String user) {

        StringBuilder sb = new StringBuilder();

        sb.append("Welcome " + user + "!");
        sb.append("\n");
        sb.append("1 - Deposit\n");
        sb.append("2 - Withdraw\n");
        sb.append("3 - Transfer\n");
        sb.append("4 - Check Balance\n");
        sb.append("5 - Settings\n");
        sb.append("6 - Exit Account\n");

        System.out.println(sb.toString());
    }

}