package com.example.SecretManagement.User;

/**
 * The User, Role, UserRepository, and RoleRepository classes are
 * simple data models used to represent users, roles, and the repositories
 * that store them. You can implement these classes and interfaces in
 * any way that makes sense for your application.
 */
public interface UserRepository {
    User findByUsername(String username);
}
