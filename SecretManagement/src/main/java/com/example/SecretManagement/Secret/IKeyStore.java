package com.example.SecretManagement.Secret;

public interface IKeyStore<K, V> {
    /**
     * Load an existing keystore using its associated password.
     *
     * @param keyStore the keystore
     * @param password the keystore password
     */
    void load(KeyStore<K, V> keyStore, char[] password);

    /**
     * Add an entry to the keystore
     *
     * @param key   the key
     * @param value the secret value
     */
    void put(K key, V value);

    /**
     * Get the value for the corresponding key
     *
     * @param key the key
     * @return the secret value
     */
    V get(K key);

    /**
     * Get the value using the key and the keystore password
     *
     * @param key      the key
     * @param password the keystore password
     * @return the secret value
     */
    V get(K key, char[] password);
}
