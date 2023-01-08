import com.example.SecretManagement.Secrets.ISecret;
import com.example.SecretManagement.Secrets.Secret;
import com.example.SecretManagement.Secrets.SecretManager;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@Slf4j
public class TestSecretManager {
    @Test
    void testSecretManager(){
        // Simple Secrets Manager
        SecretManager<Secret> manager = new SecretManager<>();
        String email = "dion@gmail.com";
        String rawPassword = "123456789";
        Secret actualEncryptedPassword = new Secret(rawPassword);
        manager.addSecret(email, actualEncryptedPassword);
        Secret expectedPassword =  manager.getSecret(email);
        log.info("\nEmail: {} \nDion Password: {} \nDecrypted: {}\n",
                email,
                actualEncryptedPassword,
                ISecret.decrypt(actualEncryptedPassword.getSecretKey(), actualEncryptedPassword.getPassword())
        );
        Assertions.assertEquals(expectedPassword, actualEncryptedPassword);
    }

    @Test
    void testSecretManagerWithString(){
        // Simple Secrets Manager
        SecretManager<String> manager = new SecretManager<>();
        String email = "dion@gmail.com";
        String rawPassword = "123456789";
        manager.addSecret(email, rawPassword);
        String expectedPassword =  manager.getSecret(email);
        log.info("\nEmail: {} \nActual Password: {} \nExpected Password: {}\n",
                email,
                rawPassword,
                expectedPassword
        );
        Assertions.assertEquals(expectedPassword, rawPassword);
    }
}
