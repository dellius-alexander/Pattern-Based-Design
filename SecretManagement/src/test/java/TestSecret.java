import com.example.SecretManagement.Secrets.ISecret;
import com.example.SecretManagement.Secrets.Secret;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

@Slf4j
public class TestSecret {
    @Test
    void CreateSecret(){
        try {
            String actualPassword = "0123456789";
            Secret password = new Secret(actualPassword);
            String expectedPassword = ISecret.decrypt(password.getSecretKey(), password.getPasswordToString());
            log.info("\n|-----------------------------------------| " +
                     "\nNew Encrypted Base64 Password: {}", password);
            log.info("\n|-----------------------------------------| " +
                     "\nDecrypted Plaintext Password: {}", expectedPassword);
            log.info("\n|-----------------------------------------| " +
                            "\nNew Encrypted Password String: {}",
                    password.getPasswordToString());
            Assertions.assertEquals(expectedPassword, actualPassword);


        }catch (Exception e){
            log.error(e.getMessage());
            log.info(Arrays.stream(e.getStackTrace()).map(
                    x -> x + "\n"
            ).collect(Collectors.toList()).toString());
        }
    }
}
