import com.example.SecretManagement.Secrets.ISecret;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

@Slf4j
public class TestISecret {

    @Test
    void testISecret(){
        try {
            SecretKey secretKey =  KeyGenerator.getInstance("AES").generateKey();
            log.info("\nSecret Key: {}",secretKey.getEncoded());
            String rawPassword = "123456789";
            String encryptedPassword = ISecret.encrypt(rawPassword, secretKey);
            String decryptedPassword = ISecret.decrypt(secretKey,encryptedPassword);
            log.info("\nExpected Password: {}, Actual Password: {}",
                    decryptedPassword, rawPassword);
            Assertions.assertEquals(decryptedPassword, rawPassword);
        } catch (Exception e){
            log.error(e.getMessage());
            e.printStackTrace();
        }

    }
}
