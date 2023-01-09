package com.example.SecretManagement;

import com.example.SecretManagement.Secrets.ISecret;
import com.example.SecretManagement.Secrets.Secret;
import com.example.SecretManagement.Secrets.SecretManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Client {
    private final static Logger log = LoggerFactory.getLogger(Client.class);

    public static void main(String[] args) {
        SecretManager<Secret> manager;
        try {
            // Advanced Secrets Manager
            char[] keyStorePassword = "key_store_password".toCharArray();
            manager = new SecretManager<>(keyStorePassword);
            String email = "dion@gmail.com";
            String rawPassword = "123456789";
            Secret actualEncryptedPassword = new Secret(rawPassword);
            manager.addSecret(email, actualEncryptedPassword);
            Secret expectedPassword =  manager.getSecret(email);
            log.info("\nEmail: {} \nRaw Password: {} \nActual Password: {} \nExpected Password: {} \nDecrypted Password: {}\n",
                    email,
                    rawPassword,
                    actualEncryptedPassword,
                    expectedPassword,
                    ISecret.decrypt(actualEncryptedPassword.getSecretKey(), actualEncryptedPassword.getPassword())
            );
        } catch (Exception e){

        }
    }
}
