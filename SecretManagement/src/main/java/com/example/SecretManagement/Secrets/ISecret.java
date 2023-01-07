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


/**
 * <pre>
 * The Secrets uses AES encryption algorithm to generate a random 256 bit
 * secretKey used to encrypt plaintext string password. The password hash can
 * only be accessed via getter. Both the secretkey and encrypted are needed to
 * decrypt the password back to plaintext.
 *
 * Every implementation of the Java platform is required to support the following
 * standard Cipher transformations with the keysizes in parentheses:
 * AES/CBC/NoPadding (128) <br/>
 * AES/CBC/PKCS5Padding (128) <br/>
 * AES/ECB/NoPadding (128) <br/>
 * AES/ECB/PKCS5Padding (128) <br/>
 * DES/CBC/NoPadding (56) <br/>
 * DES/CBC/PKCS5Padding (56) <br/>
 * DES/ECB/NoPadding (56) <br/>
 * DES/ECB/PKCS5Padding (56) <br/>
 * DESede/CBC/NoPadding (168) <br/>
 * DESede/CBC/PKCS5Padding (168) <br/>
 * DESede/ECB/NoPadding (168) <br/>
 * DESede/ECB/PKCS5Padding (168) <br/>
 * RSA/ECB/PKCS1Padding (1024, 2048) <br/>
 * RSA/ECB/OAEPWithSHA-1AndMGF1Padding (1024, 2048) <br/>
 * RSA/ECB/OAEPWithSHA-256AndMGF1Padding (1024, 2048) <br/>
 * The Key interface is the top-level interface for all keys. It
 * defines the functionality shared by all key objects. All keys
 * have three characteristics:
 *
 * <UL>
 *
 * <LI>An Algorithm
 *
 *
 * <P>This is the key algorithm for that key. The key algorithm is usually
 * an encryption or asymmetric operation algorithm (such as DSA or
 * RSA), which will work with those algorithms and with related
 * algorithms (such as MD5 with RSA, SHA-1 with RSA, Raw DSA, etc.)
 * The name of the algorithm of a key is obtained using the
 * {@link #getAlgorithm() getAlgorithm} method.
 *
 * <LI>An Encoded Form
 *
 * <P>This is an external encoded form for the key used when a standard
 * representation of the key is needed outside the Java Virtual Machine,
 * as when transmitting the key to some other party. The key
 * is encoded according to a standard format (such as
 * X.509 {@code SubjectPublicKeyInfo} or PKCS#8), and
 * is returned using the {@link #getEncoded() getEncoded} method.
 * Note: The syntax of the ASN.1 type {@code SubjectPublicKeyInfo}
 * is defined as follows:
 *
 * <pre>
 * SubjectPublicKeyInfo ::= SEQUENCE {
 *   algorithm AlgorithmIdentifier,
 *   subjectPublicKey BIT STRING }
 *
 * AlgorithmIdentifier ::= SEQUENCE {
 *   algorithm OBJECT IDENTIFIER,
 *   parameters ANY DEFINED BY algorithm OPTIONAL }
 * </pre>
 *
 * For more information, see
 * <a href="http://tools.ietf.org/html/rfc5280">RFC 5280:
 * Internet X.509 Public Key Infrastructure Certificate and CRL Profile</a>.
 *
 * <LI>A Format
 *
 * <P>This is the name of the format of the encoded key. It is returned
 * by the {@link #getFormat() getFormat} method.
 *
 * </UL>
 *
 * Keys are generally obtained through key generators, certificates,
 * or various Identity classes used to manage keys.
 * Keys may also be obtained from key specifications (transparent
 * representations of the underlying key material) through the use of a key
 * factory (see {@link KeyFactory}).
 *
 * <p> A Key should use KeyRep as its serialized representation.
 * Note that a serialized Key may contain sensitive information
 * which should not be exposed in untrusted environments.  See the
 * <a href="https://docs.oracle.com/en/java/javase/11/security/preface.html#GUID-C49D47BA-EA16-4F4F-90CE-DAD9B984D823">
 * Security Developer’s Guide</a>
 * of the Serialization Specification for more information.
 *
 * </pre>
 *
 * @see PublicKey
 * @see PrivateKey
 * @see KeyPair
 * @see KeyPairGenerator
 * @see KeyFactory
 * @see KeyRep
 * @see java.security.spec.KeySpec
 *
 * @since 1.1
 */
public interface ISecret extends Serializable, Key {
    long serialVersionUID = -6603384152749567655L;
    Logger log = LoggerFactory.getLogger(ISecret.class);
    int initialization_vector = 2048;  // greatest common multiple length
    String TRANSFORMATION = "AES/CBC/PKCS5Padding";


    /**
     * Automated method call setSecretKey() will create new random
     * secretKey at runtime or startup.
     * Key Sizes are: 32, 64, 128, 256, 512, 1024, 2048, 3072, 4096 etc.
     * @param algorithm the key algorithm
     * @param key_size the key size
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
     * The Initialization Vector (IV) is a pseudo-random value and has the same size as the block
     * that is encrypted. We can use the SecureRandom class to generate
     * a random IV. Once this is done we use the IV to initialize the {@linkplain Cipher}.
     * @param plaintext raw password
     * @param key  {@link Key}
     * @return {@link Cipher}
     */
    public static byte[] getEncodedCipher(String plaintext, Key key) {
        try {
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            final int blockSize = cipher.getBlockSize();
            log.info("Block Size: {}", blockSize);
            byte[] initVector = new byte[blockSize];
            (new SecureRandom()).nextBytes(initVector);
            log.info("Init Vector: {}",initVector.length);
            IvParameterSpec ivSpec =  new IvParameterSpec(initVector);
            log.info("IvParameterSpec: {}", ivSpec.getIV());
            cipher.init(Cipher.ENCRYPT_MODE, key, ivSpec);
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
            return cipherText;
        } catch (NoSuchPaddingException | InvalidAlgorithmParameterException | ShortBufferException |
                 IllegalBlockSizeException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException e){
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
     * @param secretKey {@link SecretKey}
     * @return ciphertext in bytes
     */
    public static String encrypt(String plaintext, SecretKey secretKey) {

        try {
            log.info("Block Size of plaintext: {}",plaintext.getBytes(StandardCharsets.UTF_8).length);
            log.info("SecretKey Algorithm: {}",secretKey.getAlgorithm());
            byte[] cipherText = getEncodedCipher(plaintext, secretKey);
            return Base64.getEncoder().withoutPadding().encodeToString(cipherText);
            //  return cipherText;
        } catch (Exception e) {
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
            byte[] cipherText = getEncodedCipher(plaintext, privateKey);
            return Base64.getEncoder().withoutPadding().encodeToString(cipherText);
        } catch (Exception e) {
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
     * @param plaintext plaintext String
     * @param publicKey {@link PublicKey}
     * @return ciphertext in bytes
     */
    static String encrypt(String plaintext, PublicKey publicKey) {
        try {
            byte[] cipherText = getEncodedCipher(plaintext, publicKey);
            return Base64.getEncoder().withoutPadding().encodeToString(cipherText);
        } catch (Exception e) {
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
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
        return null;

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

    /**
     * Resets the password currently in use, to a new password.
     *
     * @param newPassword the new password
     * @param oldPassword the password currently in use
     */
    void resetPassword(String newPassword, String oldPassword);

    /**
     * Returns the SecretKey
     *
     * @return the secret key
     */
    SecretKey getSecretKey();

    /**
     * Check if the password has been initialized.
     * @return {@link Boolean}
     */
    boolean isInitialized();

    /**
     * Must be implemented from a private context.
     * Set the password as initialized.
     * @param initialized {@link Boolean}
     */
    void setInitialized(boolean initialized);

    String getPassword();

    /**
     * Must be implemented from a private context.
     * Generates and sets the {@link SecretKey} {@link Object}
     * @param secretKey {@link SecretKey}
     */
    void setSecretKey(SecretKey secretKey);

    /**
     * For generating a secret key, we can use the KeyGenerator class.
     * Let’s define a method for generating the AES key with the size
     * of n (128, 192, and 256) bits.
     * AES (128)
     * DES (56)
     * DESede (168)
     * HmacSHA1
     * HmacSHA256
     *
     * @param size      number of bits [128, 192, 256]
     * @param algorithm algoritms available include: [ RSA, AES, DES ]
     * @return SecretKey
     */
    SecretKey generateKey(int size, String algorithm);

}
