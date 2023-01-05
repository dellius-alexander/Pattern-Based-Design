package com.example.SecretManagement;

import com.example.SecretManagement.Secret.AdvancedSecretManager;
import com.example.SecretManagement.Secret.Secret;
import com.example.SecretManagement.Secret.SecretManager;

public class Client {

    public static void main(String[] args) {
        // Simple Secret Manager
        SecretManager<Secret> manager = new SecretManager<>();
        manager.addSecret("password_1", new Secret("123456789"));
        System.out.printf("Secret Manager HashCode: %s\n", manager);
        manager.addSecret("password_2",  new Secret("987654321"));
        System.out.printf("Secret Manager HashCode: %s\n", manager);
        String password =  manager.getSecret("password_1").toString();
        System.out.printf("Password_1: %s\n",password);
        String password1 = manager.getSecret("password_2").toString();
        System.out.printf("Password_2: %s\n",password1);

        // Advanced Secret Manager
        AdvancedSecretManager<Secret> advancedManager = new AdvancedSecretManager<>("keystore-password".toCharArray());
        advancedManager.addSecret("password", new Secret("123456789"));
        System.out.printf("Secret Manager: %s\n", advancedManager);
        Secret advPassword = advancedManager.getSecret("password");
        System.out.printf("Advanced Password: %s\n", advPassword);

    }
}
