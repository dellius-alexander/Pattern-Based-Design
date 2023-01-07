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
import java.util.Objects;
import java.util.stream.Collectors;


/**
 * The Secrets.class uses AES encryption algorithm to generate a random 256 bit
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
 */

public class Secret implements ISecret{
    static final long serialVersionUID = -64L;
    private static final Logger log = LoggerFactory.getLogger(Secret.class);
    /**
     * AES (128)
     * DES (56)
     * DESede (168)
     * HmacSHA1
     * HmacSHA256
     */
    private final String ALGORITHM = "AES";  // algorithm

    private static final String TRANSFORMATION = "AES/CBC/PKCS5Padding";

    private final String KEY_FORMAT = "RAW"; // What format to return the key in?

    private static final int GCM_TAG_LENGTH = 256;  // greatest common multiple length
    /////////////////////////////////////////////////////////////////

    protected SecretKey secretKey;

    protected String password;

    private boolean initialized = false;
    /////////////////////////////////////////////////////////////////

    /**
     * Creates an Secrets Object.
     * @param password the plaintext password
     */
    public Secret(String password) {
        try{
            log.info("New Raw Secrets String: {}", password);
            secretKey = generateKey(GCM_TAG_LENGTH);
            log.info(secretKey.toString());
            initialized = true;
            this.password = ISecret.encrypt(password,  secretKey);
            log.info("New Encrypted Secrets: {}", this.password);
        } catch (Exception e){
            log.error(e.getMessage());
            e.printStackTrace();
        }
    }
    /**
     * Encrypts the raw password String and assigns encrypted value
     * to inner password field.
     * @param rawPassword the raw password String
     */
    public void setPassword(String rawPassword){
        try{
            if (secretKey != null){
                initialized = true;
                log.info(secretKey.toString());
            }
            log.info("New Raw Secrets String: {}", rawPassword);
            this.password = ISecret.encrypt(rawPassword, secretKey);
            log.info("New Encrypted Secrets: {}", this.password);
        } catch (Exception e){
            log.error(e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Returns the SecretKey
     * @return the secret key
     */
    public SecretKey getSecretKey(){return secretKey;}


    public boolean isInitialized() {
        return this.initialized;
    }

    public void setInitialized(boolean initialized) {
        this.initialized = initialized;
    }

    public String getPassword() {
        return this.password;
    }

    public void setSecretKey(SecretKey secretKey) {
        this.secretKey = secretKey;
    }

    /**
     * Gets the encrypted password string.
     * @return the encrypted password string
     */
    public String getPasswordToString(){return this.password;}
    /**
     * For generating a secret key, we can use the KeyGenerator class.
     * Let’s define a method for generating the AES key with the size
     * of n (128, 192, and 256) bits.
     * AES (128)
     * DES (56)
     * DESede (168)
     * HmacSHA1
     * HmacSHA256
     * @param size number of bits [128, 192, 256]
     * @return SecretKey
     */
    public SecretKey generateKey(int size) {
        try {
            return generateKey(size, ALGORITHM);
        } catch (Exception e){
            log.error(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
    /**
     * For generating a secret key, we can use the KeyGenerator class.
     * Let’s define a method for generating the AES key with the size
     * of n (128, 192, and 256) bits.
     * AES (128)
     * DES (56)
     * DESede (168)
     * HmacSHA1
     * HmacSHA256
     * @param size number of bits [128, 192, 256]
     * @param algorithm algoritms available include: [ RSA, AES, DES ]
     * @return SecretKey
     */
    public SecretKey generateKey(int size, String algorithm) {
        try {
            KeyGenerator key = KeyGenerator.getInstance(algorithm);
            key.init(size);
            this.secretKey = key.generateKey();
            log.info("Secrets Key: {}", this);
            return this.secretKey;
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e.toString());
        }
    }


    /**
     * Equals this object
     * @param o Secrets object
     * @return {@literal boolean}
     */
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Secret)) return false;
        final Secret other = (Secret) o;
        if (!other.canEqual( this)) return false;
        final String this$secret = this.getPasswordToString();
        final String other$secret = other.getPasswordToString();
        if (!Objects.equals(this$secret, other$secret)) return false;
        return true;
    }

    protected boolean canEqual(final Secret other) {
        return other instanceof Secret;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final String $secret = this.getPasswordToString();
        result = result * PRIME + ($secret == null ? 43 : $secret.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Secrets{\n" +
                "\"password\":\"" + this.getPasswordToString() + "\",\n" +
                "\"secretKey\":\"{\n\t" +
                "\"encoding\":\"" + Arrays.toString(this.getSecretKey().getEncoded()) + "\",\n\t" +
                "\"format\":\"" + this.getSecretKey().getFormat() + "\",\n\t" +
                "\"algorithm\":\"" + this.getSecretKey().getAlgorithm() + "\"" +
                "\n}\",\n" +
                "\"isInitialized\":\"" + initialized + "\",\n" +
                "}";
    }

    /**
     * Returns the standard algorithm name for this key. For
     * example, "DSA" would indicate that this key is a DSA key.
     * See the <a href=
     * "{@docRoot}/../specs/security/standard-names.html">
     * Java Security Standard Algorithm Names</a> document
     * for more information.
     *
     * @return the name of the algorithm associated with this key.
     */
    @Override
    public String getAlgorithm() {
        return secretKey.getAlgorithm();
    }

    /**
     * Returns the name of the primary encoding format of this key,
     * or null if this key does not support encoding.
     * The primary encoding format is
     * named in terms of the appropriate ASN.1 data format, if an
     * ASN.1 specification for this key exists.
     * For example, the name of the ASN.1 data format for public
     * keys is <I>SubjectPublicKeyInfo</I>, as
     * defined by the X.509 standard; in this case, the returned format is
     * {@code "X.509"}. Similarly,
     * the name of the ASN.1 data format for private keys is
     * <I>PrivateKeyInfo</I>,
     * as defined by the PKCS #8 standard; in this case, the returned format is
     * {@code "PKCS#8"}.
     *
     * @return the primary encoding format of the key.
     */
    @Override
    public String getFormat() {
        return secretKey.getFormat();
    }

    /**
     * Returns the key in its primary encoding format, or null
     * if this key does not support encoding.
     *
     * @return the encoded key, or null if the key does not support
     * encoding.
     */
    @Override
    public byte[] getEncoded() {
        return secretKey.getEncoded();
    }

    public static void main(String[] args)
    {
        try {

            Secret password1 = new Secret("LendIT_Book_Kiosk");
            log.info("-----------------------------------------| New Secrets Object: {}", password1);
            log.info("-----------------------------------------| Decrypted Plaintext Password1: {}",
                    ISecret.decrypt(password1.getSecretKey(), password1.getPasswordToString()));
            log.info("-----------------------------------------| New Encrypted Password1: {}",
                    password1.getPasswordToString());
            Secret password2 = new Secret("password");
            log.info("-----------------------------------------| New Secrets Object: {}", password2);
            log.info("-----------------------------------------| Decrypted Plaintext Password2: {}",
                    ISecret.decrypt(password2.getSecretKey(), password2.getPasswordToString()));
            log.info("-----------------------------------------| New Encrypted Password2: {}",
                    password2.getPasswordToString());
        }catch (Exception e){
            log.error(e.getMessage());
            log.info(Arrays.stream(e.getStackTrace()).map(
                    x -> x + "\n"
            ).collect(Collectors.toList()).toString());
        }
    }
}