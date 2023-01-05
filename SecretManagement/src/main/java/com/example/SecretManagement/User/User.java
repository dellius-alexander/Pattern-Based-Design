package com.example.SecretManagement.User;

/**
 * The User, Role, UserRepository, and RoleRepository classes are
 * simple data models used to represent users, roles, and the repositories
 * that store them. You can implement these classes and interfaces in
 * any way that makes sense for your application.
 */
public class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
