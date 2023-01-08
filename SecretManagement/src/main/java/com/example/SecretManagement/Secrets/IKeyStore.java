package com.example.SecretManagement.Secrets;

/**
 * The KeyStore class has a generic type parameter K for the type
 * of the keys, and a generic type parameter V for the type of the
 * values. It has a HashMap instance to store the key-value pairs
 * and a password field to store the keystore password.
 *
 * The setPassword method allows you to set the keystore password.
 * The put method allows you to add a key-value pair to the keystore,
 * and the get method allows you to retrieve the value for a given key.
 * @param <K> key
 * @param <V> value
 */
public interface IKeyStore<K, V> {
    /**
     * Load an existing keystore using its associated password.
     *
     * @param keyStore the keystore
     * @param keyStorePassword the keystore password
     */
    void load(KeyStore<K, V> keyStore, char[] keyStorePassword);

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
