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

}