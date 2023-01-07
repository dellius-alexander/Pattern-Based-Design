package com.example.SecretManagement;

import com.example.SecretManagement.Secrets.ISecret;
import com.example.SecretManagement.Secrets.Secret;
import com.example.SecretManagement.Secrets.SecretManager;

public class Client {

    public static void main(String[] args) {

        // Simple Secrets Manager
        SecretManager<Secret> manager = new SecretManager<>();
        manager.addSecret("dion@gmail.com", new Secret("123456789"));
        Secret password =  manager.getSecret("dion@gmail.com");
        System.out.printf("\nDion Password: %s \nDecrypted: %s\n",
                password,
                ISecret.decrypt(password.getSecretKey(), password.getPassword())
        );

//        // Advanced Secrets Manager
//        AdvancedSecretManager<Secrets> advancedManager = new AdvancedSecretManager<>("keystore-password".toCharArray());
//        advancedManager.addSecret("password", new Secrets("123456789"));
//        Secrets advPassword = advancedManager.getSecret("password");
//        System.out.printf("\nEncrypted Advanced Password: %s \nDecrypted: %s\n", advPassword, Secrets.decrypt(advPassword.getSecretKey(), advPassword.getPassword()));

    }
}
