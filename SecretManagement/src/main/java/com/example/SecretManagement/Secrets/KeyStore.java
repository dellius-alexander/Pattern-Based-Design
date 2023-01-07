package com.example.SecretManagement.Secrets;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

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
public class KeyStore<K, V> implements IKeyStore<K, V> {
    private static final Logger log = LoggerFactory.getLogger(KeyStore.class);
    private final Map<K, V> store;
    protected final char[] keyStorePassword;

    public KeyStore(char[] keyStorePassword) {
        store = new HashMap<>();
        this.keyStorePassword = keyStorePassword;
    }

    /**
     * Load an existing keystore using its associated password.
     * @param keyStore the keystore
     * @param password the keystore password
     */
    @Override
    public void load(KeyStore<K, V> keyStore, char[] password){
        try {
            if (keyStore == null || this.keyStorePassword == null){
                return; // do nothing
            }
            else if (keyStore.keyStorePassword == password){
                store.putAll(keyStore.store);
            }
            else {
                throw new IllegalStateException("Error: Keystore password does not match or keystore is invalid type.");
            }
        } catch (Exception e){
            log.error(e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Add an entry to the keystore
     * @param key the key
     * @param value the secret value
     */
    @Override
    public void put(K key, V value) {
        store.put(key, value);
    }

    /**
     * Get the value for the corresponding key
     * @param key the key
     * @return the secret value
     */
    @Override
    public V get(K key) {
        return store.get(key);
    }

    /**
     * Get the value using the key and the keystore password
     * @param key the key
     * @param password the keystore password
     * @return the secret value
     */
    @Override
    public V get(K key, char[] password) {
        if (this.keyStorePassword == password){
            return store.get(key);
        } else {
            throw new IllegalStateException("Unable to validate keystore password or key is incorrect reference.");
        }

    }
}
