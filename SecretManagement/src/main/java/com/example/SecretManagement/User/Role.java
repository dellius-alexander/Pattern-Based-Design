package com.example.SecretManagement.User;


import java.util.List;

/**
 * The User, Role, UserRepository, and RoleRepository classes are
 * simple data models used to represent users, roles, and the repositories
 * that store them. You can implement these classes and interfaces in
 * any way that makes sense for your application.
 */
public class Role {
    private String name;
    private List<String> permissions;

    public Role(String name, List<String> permissions) {
        this.name = name;
        this.permissions = permissions;
    }

    public String getName() {
        return name;
    }

    public List<String> getPermissions() {
        return permissions;
    }
}
