package com.example.SecretManagement.Secret;

import com.example.SecretManagement.User.User;
import com.example.SecretManagement.User.UserRepository;

/**
 * The Authentication class has a method login that takes a username
 * and password and returns true if the login is successful. It does
 * this by looking up the user in the UserRepository and checking that
 * the provided password matches the stored password.
 */
public class Authentication {
    private UserRepository userRepository;

    public Authentication(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean login(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            return false;
        }
        return user.getPassword().equals(password);
    }
}



