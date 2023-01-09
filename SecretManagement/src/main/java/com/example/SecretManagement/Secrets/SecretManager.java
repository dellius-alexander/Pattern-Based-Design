package com.example.SecretManagement.Secrets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * This SecretManager class uses a KeyStore to store secrets securely. The
 * KeyStore is a Java utility that provides a secure way to store cryptographic keys.
 *
 * The SecretManager constructor takes a key store password and creates a
 * new KeyStore instance using the default type. The addSecret method adds
 * a secret to the KeyStore using the given alias/key. The getSecret method
 * retrieves a secret from the KeyStore using the given alias/key.
 *
 * This implementation is more secure than the previous implementation because
 * it uses the KeyStore to store secrets in an encrypted form. However, it is
 * also more complex and requires additional dependencies (such as the Java
 * Cryptography Extension (JCE) Unlimited Strength Jurisdiction Policy Files).
 *
 * You can use this SecretManager class to store any type of secret that can be
 * stored in a KeyStore, such as passwords, API keys, or sensitive data.
 * @param <T> generic object parameter
 */
public class SecretManager<T> implements ISecretManager<T> {
    private static final Logger log = LoggerFactory.getLogger(SecretManager.class);
    private KeyStore<String, T> keyStore;
    private final char[] keyStorePassword;

    public SecretManager(char[] keyStorePassword) {
        try {
            keyStore = new KeyStore<>(keyStorePassword);
        } catch (Exception e){
            log.error(e.getMessage());
            e.printStackTrace();
        }
        this.keyStorePassword = keyStorePassword;
    }

    /**
     * Add secret to secret store.
     *
     * @param key    the secret key
     * @param secret the sensitive object to be hashed.
     */
    @Override
    public void addSecret(String key, T secret) {
        try {
            keyStore.put(key,  secret);
        } catch (Exception e){
            log.error(e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Get secret from secret store.
     *
     * @param key the secret key
     * @return the secret for the given key.
     */
    @Override
    public T getSecret(String key) {
        try {
            return keyStore.get(key, this.keyStorePassword);
        } catch (Exception e){
            log.error(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}
