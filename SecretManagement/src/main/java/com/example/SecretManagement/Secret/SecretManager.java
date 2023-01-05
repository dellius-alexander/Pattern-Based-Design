package com.example.SecretManagement.Secret;

import java.util.HashMap;

/**
 * The SecretManager class stores secrets as key/value pair, string key
 * and a generic value. The addSecret method allows you to add a secret
 * to the SecretManager, and the getSecret method allows you
 * to retrieve a secret from the secret store by using its key. You can
 * use the ISecretManager class to implement a SecretManager and store
 * any type of secret, such as passwords, API keys, or sensitive data.
 * @param <T> A generic secret object of any type
 */
public class SecretManager<T> implements ISecretManager<T>{

    private final HashMap<String, T> secrets;

    public SecretManager() {
        secrets = new HashMap<>();
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
    }

    /**
     * Get secret from secret store.
     *
     * @param key the secret key
     * @return the secret for the given key.
     */
    @Override
    public T getSecret(String key) {

        return secrets.get(key);
    }
}
