package org.example.Users;

public abstract class User {
    private int userId;
    private int userRoot = 0;
    private String login;
    private String password;

    private int balance;

    public int getUserId() {
        return userId;
    }

    public int getUserRoot() {
        return userRoot;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getLogin() {
        return login;
    }

    public User(int userId, String login, String password) {
        this.userId = userId;
        this.login = login;
        this.password = password;
    }

    @Override
    public String toString() {
        return userId + ";" + login + ";" + password;
    }
}
