import com.example.SecretManagement.Secrets.SecretManager;
import com.example.SecretManagement.Secrets.ISecret;
import com.example.SecretManagement.Secrets.Secret;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


@Slf4j
public class TestSecretManager {

    @Test
    void testSecretManager(){
        SecretManager<Secret> manager;
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
        Assertions.assertEquals(expectedPassword, actualEncryptedPassword);
    }

}
