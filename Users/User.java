package org.example.Users;

public abstract class User {
    private String fullName;
    private String phoneNumber;
    private int userId;
    private int userRoot=0;
    private String login=null;
    private String password=null;

    private int balance;

    public String getFullName() {
        return fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getUserId() {
        return userId;
    }

    public int getUserRoot() {
        return userRoot;
    }

    public User(int balance) {
        this.balance = balance;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public User(String fullName, String phoneNumber, int userId, String login, String password) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.userId = userId;
        this.login = login;
        this.password = password;
    }

    public User(String fullName, String phoneNumber, int userId) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Пользователь:" +
                "Имя:" + fullName + '\'' +
                ", Номер телефона: " + phoneNumber + '\'' +
                ", ID пользователя:" + userId + '\'' +
                '}';
    }
}
