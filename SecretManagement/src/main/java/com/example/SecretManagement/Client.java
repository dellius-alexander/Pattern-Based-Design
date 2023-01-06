package com.example.SecretManagement;

import com.example.SecretManagement.Secret.Secret;
import com.example.SecretManagement.Secret.SecretManager;

public class Client {

    public static void main(String[] args) {

        // Simple Secret Manager
        SecretManager<Secret> manager = new SecretManager<>();
        manager.addSecret("dion@gmail.com", new Secret("123456789"));
        Secret password =  manager.getSecret("dion@gmail.com");
        System.out.printf("\nDion Password: %s \nDecrypted: %s\n",
                password,
                Secret.decrypt(password.getSecretKey(), password.getPassword())
        );

//        // Advanced Secret Manager
//        AdvancedSecretManager<Secret> advancedManager = new AdvancedSecretManager<>("keystore-password".toCharArray());
//        advancedManager.addSecret("password", new Secret("123456789"));
//        Secret advPassword = advancedManager.getSecret("password");
//        System.out.printf("\nEncrypted Advanced Password: %s \nDecrypted: %s\n", advPassword, Secret.decrypt(advPassword.getSecretKey(), advPassword.getPassword()));

    }
}
