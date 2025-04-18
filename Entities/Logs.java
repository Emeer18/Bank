package Entities;

public class Logs {

    private String user;
    private String action;
    private String date;

    public Logs(String user, String action, String date) {
        this.user = user;
        this.action = action;
        this.date = date;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void displayLog() {
        System.out.println("User: " + user + " - Action: " + action + " - Date: " + date);
    }
    
}
