package com.example.SecretManagement.Secrets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.Arrays;
import java.util.Base64;

public interface ISecret extends Serializable, Key {
    long serialVersionUID = -63L;
    Logger log = LoggerFactory.getLogger(ISecret.class);
    int GCM_TAG_LENGTH = 256;  // greatest common multiple length
    String TRANSFORMATION = "AES/CBC/PKCS5Padding";


    /**
     * Automated method call setSecretKey() will create new random
     * secretKey at runtime or startup.
     * Key Sizes are: 1024, 2048, 3072, 4096, 8192, etc.
     */
    static SecretKey createSecretKey(String algorithm, Integer key_size) {
        try{
            KeyGenerator key = KeyGenerator.getInstance(algorithm);
            key.init(key_size);
            SecretKey secretKey = key.generateKey();
            log.info("Secrets Key: {}", secretKey);
            return secretKey;
        }catch (Exception e){
            log.error(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Tests if rawPassword matches encrypted secret.
     * @param rawPassword a raw secret string
     * @param secret an encrypted secret object
     * @return true if they match, false if no match found
     */
    public static boolean matches(String rawPassword, Secret secret){
        return rawPassword.equalsIgnoreCase(decrypt(secret.getSecretKey(),
                secret.getPasswordToString()));
    }
    /**
     * Tests if rawPassword matches encrypted password.
     * @param password1 an encrypted password string
     * @param password2 an encrypted password string
     * @return true if they match, false if no match found
     */
    public static boolean matches(String password1, String password2){
        return password1.trim().equalsIgnoreCase(password2.trim());
    }
    /**
     * Tests if rawPassword matches encrypted password.
     * @param secret1 an encrypted password Object
     * @param secret2 an encrypted password Object
     * @return true if they match, false if no match found
     */
    public static boolean matches(Secret secret1, Secret secret2){
        return decrypt(secret1.getSecretKey(), secret1.getPasswordToString())
                .equalsIgnoreCase(
                        decrypt(secret2.getSecretKey(), secret2.getPasswordToString())
                );
    }

    /**
     * V is a pseudo-random value and has the same size as the block
     * that is encrypted. We can use the SecureRandom class to generate
     * a random IV.
     * @return IvParameterSpec
     */
    public static IvParameterSpec generateIv() {
        byte[] iv = new byte[GCM_TAG_LENGTH];
        new SecureRandom().nextBytes(iv);
        return new IvParameterSpec(iv);
    }


    /**
     * To implement input string encryption, we first need to generate the
     * secret key and IV according to the previous section. As the next step,
     * we create an instance from the Cipher class by using the getInstance()
     * method.
     * Additionally, we configure a cipher instance using the init() method
     * with a secret key, IV, and encryption mode. Finally, we encrypt the
     * input string by invoking the doFinal() method. This method gets bytes
     * of input and returns ciphertext in bytes
     * @param plaintext plaintext string
     * @param secretKey {@link SecretKey}
     * @return ciphertext in bytes
     */
    public static String encrypt(String plaintext, SecretKey secretKey) {

        try {
            log.info("Block Size of plaintext: {}",plaintext.getBytes(StandardCharsets.UTF_8).length);
            log.info("SecretKey Algorithm: {}",secretKey.getAlgorithm());
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            final int blockSize = cipher.getBlockSize();
            log.info("Block Size: {}", blockSize);
            byte[] initVector = new byte[blockSize];
            (new SecureRandom()).nextBytes(initVector);
            log.info("Init Vector: {}",initVector.length);
            IvParameterSpec ivSpec =  new IvParameterSpec(initVector);
            log.info("IvParameterSpec: {}", ivSpec.getIV());
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivSpec);
            byte[] encoded = plaintext.toString().getBytes(java.nio.charset.StandardCharsets.UTF_8);
            byte[] cipherText = new byte[initVector.length + cipher.getOutputSize(encoded.length)];
            for (int i=0; i < initVector.length; i++)
            {
                cipherText[i] = initVector[i];
            }
            // Perform encryption & return the number of bytes stored in output
            int num_of_encrypted_bits = cipher.doFinal(encoded, 0, encoded.length, cipherText, initVector.length);
            String base64EncodedString = Base64.getEncoder().withoutPadding().encodeToString(cipherText);
            log.info("New Encrypted CipherText Length: {}, " +
                            "\nEncrypted CipherText Value: {}, " +
                            "\nEncoding Length of Original PlainText String: {}, " +
                            "\nNumber of Bits of NEW Encrypted CipherText: {}" +
                            "\nBase64 Encoded String of Encypted CipherText: {}",
                    cipherText.length,
                    cipherText,
                    encoded.length,
                    num_of_encrypted_bits,
                    base64EncodedString);
            return  base64EncodedString;
            //  return cipherText;
        } catch (Exception e)
        {
            log.error(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    /**
     * To implement input string encryption, we first need to generate the
     * secret key and IV according to the previous section. As the next step,
     * we create an instance from the Cipher class by using the getInstance()
     * method.
     * Additionally, we configure a cipher instance using the init() method
     * with a secret key, IV, and encryption mode. Finally, we encrypt the
     * input string by invoking the doFinal() method. This method gets bytes
     * of input and returns ciphertext in bytes
     * @param plaintext plaintext string
     * @param privateKey {@link PrivateKey}
     * @return ciphertext in bytes
     */
    static String encrypt(String plaintext, PrivateKey privateKey) {

        try {
            byte[] cipherText;
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            final int blockSize = cipher.getBlockSize();
            log.info("Block Size: {}", blockSize);
            byte[] initVector = new byte[blockSize];
            (new SecureRandom()).nextBytes(initVector);
            log.info("Init Vector: {}",initVector.length);
            IvParameterSpec ivSpec = new IvParameterSpec(initVector);
            log.info("IvParameterSpec: {}", ivSpec.getIV());
            cipher.init(Cipher.ENCRYPT_MODE, privateKey, ivSpec);
            byte[] encoded = plaintext.getBytes(java.nio.charset.StandardCharsets.UTF_8);
            cipherText = new byte[initVector.length + cipher.getOutputSize(encoded.length)];
            for (int i=0; i < initVector.length; i++) {
                cipherText[i] = initVector[i];
            }
            // Perform encryption & return the number of bytes stored in output
            int num_of_encrypted_bits = cipher.doFinal(encoded, 0, encoded.length, cipherText, initVector.length);
            String base64EncodedString = Base64.getEncoder().withoutPadding().encodeToString(cipherText);
            log.info("New Encrypted CipherText Length: {}, " +
                            "\nEncrypted CipherText Value: {}, " +
                            "\nEncoding Length of Original PlainText String: {}, " +
                            "\nNumber of Bits of NEW Encrypted CipherText: {}" +
                            "\nBase64 Encoded String of Encypted CipherText: {}",
                    cipherText.length,
                    cipherText,
                    encoded.length,
                    num_of_encrypted_bits,
                    base64EncodedString);
            return base64EncodedString;
        } catch (NoSuchPaddingException | InvalidAlgorithmParameterException | ShortBufferException |
                 BadPaddingException | IllegalBlockSizeException | InvalidKeyException | NoSuchAlgorithmException e)
        {
            /* None of these exceptions should be possible if pre-condition is met. */
            throw new IllegalStateException(e.toString());
        }
    }

    /**
     * To implement input string encryption, we first need to generate the
     * secret key and IV according to the previous section. As the next step,
     * we create an instance from the Cipher class by using the getInstance()
     * method.
     * Additionally, we configure a cipher instance using the init() method
     * with a secret key, IV, and encryption mode. Finally, we encrypt the
     * input string by invoking the doFinal() method. This method gets bytes
     * of input and returns ciphertext in bytes
     * @param plaintext plaintext String
     * @param publicKey {@link PublicKey}
     * @return ciphertext in bytes
     */
    static String encrypt(String plaintext, PublicKey publicKey) {
        try {
            byte[] cipherText;
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);

            final int blockSize = cipher.getBlockSize();
            log.info("Block Size: {}", blockSize);
            byte[] initVector = new byte[blockSize];
            (new SecureRandom()).nextBytes(initVector);
            log.info("Init Vector: {}",initVector.length);
            IvParameterSpec ivSpec = new IvParameterSpec(initVector);
            log.info("IvParameterSpec: {}", ivSpec.getIV());
            cipher.init(Cipher.ENCRYPT_MODE, publicKey, ivSpec);
            byte[] encoded = plaintext.getBytes(java.nio.charset.StandardCharsets.UTF_8);
            cipherText = new byte[initVector.length + cipher.getOutputSize(encoded.length)];
            for (int i=0; i < initVector.length; i++) {
                cipherText[i] = initVector[i];
            }
            // Perform encryption & return the number of bytes stored in output
            int num_of_encrypted_bits = cipher.doFinal(encoded, 0, encoded.length, cipherText, initVector.length);
            String base64EncodedString = Base64.getEncoder().withoutPadding().encodeToString(cipherText);
            log.info("New Encrypted CipherText Length: {}, " +
                            "\nEncrypted CipherText Value: {}, " +
                            "\nEncoding Length of Original PlainText String: {}, " +
                            "\nNumber of Bits of NEW Encrypted CipherText: {}" +
                            "\nBase64 Encoded String of Encypted CipherText: {}",
                    cipherText.length,
                    cipherText,
                    encoded.length,
                    num_of_encrypted_bits,
                    base64EncodedString);
            return base64EncodedString;
        } catch (NoSuchPaddingException | InvalidAlgorithmParameterException | ShortBufferException |
                 BadPaddingException | IllegalBlockSizeException | InvalidKeyException | NoSuchAlgorithmException e)
        {
            /* None of these exceptions should be possible if pre-condition is met. */
            throw new IllegalStateException(e.toString());
        }
    }
    /**
     * For decrypting an input string, initialize our cipher using the
     * DECRYPT_MODE to decrypt the content:
     * @param cipherText cipherText String
     * @param privateKey {@link PrivateKey}
     * @return a decrypted password string
     */
    static String decrypt(String cipherText, PrivateKey privateKey) {
        try {
            byte[] cipherTextBytes = Base64.getDecoder().decode(cipherText);
//            byte[] cipherTextBytes = cipherText;

            log.info("Cypher text length: {} , Value: {}", cipherTextBytes.length, cipherTextBytes);
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            final int blockSize = cipher.getBlockSize();
            log.info("Block Size: {}",blockSize);
            byte[] initVector = Arrays.copyOfRange(cipherTextBytes, 0, blockSize);
            log.info("InitVector: {}", initVector.length);
            IvParameterSpec ivSpec = new IvParameterSpec(initVector);
            log.info("IvParameterSpec: {}",ivSpec.getIV());
            cipher.init(Cipher.DECRYPT_MODE, privateKey, ivSpec);
            byte[] plaintext = cipher.doFinal(cipherTextBytes, blockSize, cipherTextBytes.length - blockSize);
            return new String(plaintext);
        } catch (NoSuchPaddingException | InvalidAlgorithmParameterException |
                 InvalidKeyException | BadPaddingException | IllegalBlockSizeException |  NoSuchAlgorithmException e)
        {
            /* None of these exceptions should be possible if precond is met. */
            throw new IllegalStateException(e.toString());
        }
    }
    /**
     * For decrypting an input string, initialize our cipher using the
     * DECRYPT_MODE to decrypt the content:
     * @param cipherText cipherText String
     * @param secretKey {@link SecretKey}
     * @return a decrypted password string
     */
    static String decrypt(SecretKey secretKey, String cipherText) {
        try {
            byte[] cipherTextBytes = Base64.getDecoder().decode(cipherText);
//            byte[] cipherTextBytes = cipherText;

            log.info("Cypher text length: {} , Value: {}", cipherTextBytes.length, cipherTextBytes);
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            final int blockSize = cipher.getBlockSize();
            log.info("Block Size: {}",blockSize);
            byte[] initVector = Arrays.copyOfRange(cipherTextBytes, 0, blockSize);
            log.info("InitVector: {}", initVector.length);
            IvParameterSpec ivSpec = new IvParameterSpec(initVector);
            log.info("IvParameterSpec: {}",ivSpec.getIV());
            cipher.init(Cipher.DECRYPT_MODE, secretKey, ivSpec);
            byte[] plaintext = cipher.doFinal(cipherTextBytes, blockSize, cipherTextBytes.length - blockSize);
            return new String(plaintext);
        } catch (NoSuchPaddingException | InvalidAlgorithmParameterException |
                 InvalidKeyException | BadPaddingException | IllegalBlockSizeException |  NoSuchAlgorithmException e)
        {
            /* None of these exceptions should be possible if precond is met. */
            throw new IllegalStateException(e.toString());
        }
    }

    /**
     * For decrypting an input string, initialize our cipher using the
     * DECRYPT_MODE to decrypt the content:
     * @param cipherText cipherText String
     * @param publicKey {@link PublicKey}
     * @return a decrypted password string
     */
    static String decrypt(PublicKey publicKey, String cipherText) {
        try {
            byte[] cipherTextBytes = Base64.getDecoder().decode(cipherText);
//            byte[] cipherTextBytes = cipherText;

            log.info("Cypher text length: {} , Value: {}", cipherTextBytes.length, cipherTextBytes);
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            final int blockSize = cipher.getBlockSize();
            log.info("Block Size: {}",blockSize);
            byte[] initVector = Arrays.copyOfRange(cipherTextBytes, 0, blockSize);
            log.info("InitVector: {}", initVector.length);
            IvParameterSpec ivSpec = new IvParameterSpec(initVector);
            log.info("IvParameterSpec: {}",ivSpec.getIV());
            cipher.init(Cipher.DECRYPT_MODE, publicKey, ivSpec);
            byte[] plaintext = cipher.doFinal(cipherTextBytes, blockSize, cipherTextBytes.length - blockSize);
            return new String(plaintext);
        } catch (NoSuchPaddingException | InvalidAlgorithmParameterException |
                 InvalidKeyException | BadPaddingException | IllegalBlockSizeException |  NoSuchAlgorithmException e)
        {
            /* None of these exceptions should be possible if precond is met. */
            throw new IllegalStateException(e.toString());
        }
    }

}
