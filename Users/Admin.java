package org.example.Users;

public abstract class Admin extends User {
    public Admin(int userId, String login, String password) {
        super(userId, login, password);
    }

    public abstract void setRoot(int root, User userSer, User userIn);
    public abstract void addNewUser(User user);

}
