package com.example.SecretManagement.Secret;

import com.example.SecretManagement.User.Role;
import com.example.SecretManagement.User.RoleRepository;
import com.example.SecretManagement.User.User;

import java.util.List;

/**
 * The Authorization class has a method hasPermission that takes a
 * user and a permission and returns true if the user has the given
 * permission. It does this by looking up the roles associated with
 * the user in the RoleRepository and checking if any of the roles
 * have the given permission.
 */
public class Authorization {
    private RoleRepository roleRepository;

    public Authorization(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public boolean hasPermission(User user, String permission) {
        List<Role> roles = roleRepository.findByUser(user);
        for (Role role : roles) {
            if (role.getPermissions().contains(permission)) {
                return true;
            }
        }
        return false;
    }
}