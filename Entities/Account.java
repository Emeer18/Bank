package Entities;

public class Account {

    private String name;
    private String email;
    private String phoneNumber;
    private String cpf; 
    private int id;
    private double balance;
    private String user;
    private String password;

    public Account(){
    }

    public Account(String name, String email, String phoneNumber, String cpf, double balance, String user, String password) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.cpf = cpf;
        this.balance = balance;
        this.user = user;
        this.password = password;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }
    

    @Override
    public String toString() {
        
        StringBuilder sb = new StringBuilder();
        sb.append("Account Details:\n");
        sb.append("Name: ").append(name).append("\n");
        sb.append("Email: ").append(email).append("\n");
        sb.append("Phone Number: ").append(phoneNumber).append("\n");
        sb.append("CPF: ").append(cpf).append("\n");
        sb.append("Balance: ").append(balance).append("\n");
        sb.append("Username: ").append(user).append("\n");
        sb.append("Id: ").append(id).append("\n");
        sb.append("----------------------------------------------------------------\n");

        return sb.toString();
    }
}