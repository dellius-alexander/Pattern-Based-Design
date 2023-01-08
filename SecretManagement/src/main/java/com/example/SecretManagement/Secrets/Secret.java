package com.example.SecretManagement.Secrets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.*;
import java.security.*;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;


/**
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
 */

public class Secret implements ISecret {
    static final long serialVersionUID = -6603384152749567656L;
    private static final Logger log = LoggerFactory.getLogger(Secret.class);
    /**
     * AES (128)
     * DES (56)
     * DESede (168)
     * HmacSHA1
     * HmacSHA256
     */
    private final String ALGORITHM = "AES";  // algorithm

    private static final int GCM_TAG_LENGTH = 256;  // greatest common multiple length
    /////////////////////////////////////////////////////////////////
    @Deprecated
    protected MyProvider provider = new MyProvider();
    /**
     * The Binary encoded {@link SecretKey}
     */
    protected SecretKey secretKey;
    /**
     * The Base64 encrypted password.
     */
    protected String password;

    private boolean initialized = false;
    /////////////////////////////////////////////////////////////////

    /**
     * Creates an Secrets Object.
     * @param password the plaintext password
     */
    public Secret(String password) {
        try{
            log.info("\nNew Raw Secrets String: {}", password);
            secretKey = generateKey(GCM_TAG_LENGTH);
            log.info(secretKey.toString());
            setInitialized(true);
            this.password = ISecret.encrypt(password,  secretKey);
            log.info("\nNew Encrypted Secrets: {}", this.password);
        } catch (Exception e){
            log.error(e.getMessage());
            e.printStackTrace();
        }
    }
    /**
     * Resets the password currently in use, to a new password.
     * The oldPassword is required to reset to a new password.
     *
     * @param newPassword the new password
     * @param oldPassword the password currently in use
     */
    @Override
    public void resetPassword(String newPassword, String oldPassword){
        try{
            if (secretKey == null){
                throw new IllegalStateException(
                        "SecretKey is null. Unable to reset Password.\n" +
                        "Implying that password has not yet been set."
                );
            }
            // if oldPassword == newPassword
            if (Objects.equals(oldPassword, ISecret.decrypt(secretKey, password))){
                password = ISecret.encrypt(newPassword, secretKey);
            } else {
                throw new IllegalStateException(
                        "Password mismatch.\n" +
                        "Unable to reset password."
                );
            }
            log.info("\nNew Encrypted Secrets: {}", password);
        } catch (Exception e){
            log.error(e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Returns the SecretKey
     * @return the secret key
     */
    @Override
    public SecretKey getSecretKey(){return secretKey;}


    @Override
    public boolean isInitialized() {
        return this.initialized;
    }

    @Override
    public void setInitialized(boolean initialized) {
        this.initialized = initialized;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
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
    @Override
    public SecretKey generateKey(int size, String algorithm) {
        try {
            KeyGenerator key = KeyGenerator.getInstance(algorithm, this.provider);
            key.init(size);
            secretKey = key.generateKey();
            log.info("\nEncoded Secrets Key: {}", secretKey.getEncoded());
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

}