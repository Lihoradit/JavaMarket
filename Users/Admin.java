package org.example.Users;

public abstract class Admin extends User {
    public Admin(String fullName, String phoneNumber, int userId) {
        super(fullName, phoneNumber, userId);
    }

    public abstract void setRoot(int root, User userSer, User userIn);
    public abstract void addNewUser(User user);

}
