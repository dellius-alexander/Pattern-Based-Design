import com.example.SecretManagement.Secrets.KeyStore;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.charset.Charset;

@Slf4j
public class TestKeyStore {

    @Test
    void testKeyStore(){

        // create first key store
        char[] keyStorePassword = "key_store_password".toCharArray();
        String janeEmail = "jane@gmail.com";
        String actualPassword = "123456789";
        KeyStore<String,String> store = new KeyStore<>(keyStorePassword);
        // add jane password to original key store
        store.put(janeEmail, actualPassword);
        // create second load function
        char[] newKeyStorePassword = "new_key_store_password".toCharArray();
        KeyStore<String,String> newStore = new KeyStore<>(newKeyStorePassword);
        newStore.put("john@gmail.com", "987654321");
        // merge first keystore with second keystore
        newStore.load(store, keyStorePassword);
        // retrieve jane password from new key store
        String expectedPassword = newStore.get(janeEmail);
        log.info("\nExpected Password: {} \nActual Password: {}",
                expectedPassword, actualPassword);

        Assertions.assertEquals(expectedPassword, actualPassword);

    }

    @Test
    void testGenerateKeyPair(){
        KeyStore<String, Object> store = new KeyStore<>("key_store_password".toCharArray());
        store.generateKeyPair();
    }
}
