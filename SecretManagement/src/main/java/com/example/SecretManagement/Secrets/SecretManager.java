package com.example.SecretManagement.Secrets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

/**
 * The SecretManager class stores secrets as key/value pair, string key
 * and a generic value. The addSecret method allows you to add a secret
 * to the SecretManager, and the getSecret method allows you
 * to retrieve a secret from the secret store by using its key. You can
 * use the ISecretManager class to implement a SecretManager and store
 * any type of secret, such as passwords, API keys, or sensitive data.
 *
 * @param <T> A generic secret object of any type
 */
public class SecretManager<T> implements ISecretManager<T> {

    private final HashMap<String, T> secrets;
    private static final Logger log = LoggerFactory.getLogger(SecretManager.class);

    public SecretManager() {
        secrets = new HashMap<>();
        log.info("Secret Manager initialized...");
    }

    /**
     * Add secret to secret store.
     *
     * @param key    the secret key
     * @param secret the sensitive object to be hashed and kept secret.
     */
    @Override
    public void addSecret(String key, T secret) {
        secrets.put(key, secret);
        log.info("\nAdded secret for key: {} \nSecret: {}\n", key, secrets.get(key));
    }

    /**
     * Get secret from secret store.
     *
     * @param key the secret key
     * @return the secret for the given key.
     */
    @Override
    public T getSecret(String key) {
        log.info("Retrieving secret for key: {}", key);
        return secrets.get(key);
    }
}
