package com.example.SecretManagement.Secret;

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
 * The Secret.class uses AES encryption algorithm to generate a random 256 bit
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

public class Secret implements Serializable, Key {
    static final long serialVersionUID = -64L;
    private static final Logger log = LoggerFactory.getLogger(Secret.class);
    private final String ALGORITHM = "AES";  // algorithm
    private final String KEY_PAIR_ALGORITHM = "RSA"; // KEY PAIR ALGORITHM
    private static final String TRANSFORMATION = "AES/CBC/PKCS5Padding";

    private final String KEY_FORMAT = "RAW"; // What format to return the key in?
    private static final int GCM_TAG_LENGTH = 32;  // greatest common multiple length
    /////////////////////////////////////////////////////////////////
    protected SecretKey secretKey;

    protected String password = null;

    private boolean initialized = false;
    /////////////////////////////////////////////////////////////////
    public Secret() {secretKey = generateKey(256);}

    /**
     * Creates an Secret Object.
     * @param password the plaintext password
     */
    public Secret(String password)
    {
        try{

            log.info("New Raw Secret String: {}", password);
            secretKey = generateKey(256);
            log.info(secretKey.toString());
            initialized = true;
            this.password =  encrypt(String.valueOf(password),  secretKey);
            log.info("New Encrypted Secret: {}", this.password);
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
            log.info("New Raw Secret String: {}", rawPassword);
            this.password = encrypt(String.valueOf(rawPassword), secretKey);
            log.info("New Encrypted Secret: {}", this.password);
        } catch (Exception e){
            log.error(e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Automated method call setSecretKey() will create new random
     * secretKey at runtime or startup.
     * Key Sizes are: 1024, 2048, 3072, 4096, 8192, etc.
     */
    protected void setSecretKey(Integer key_size) {
        try{
            secretKey = generateKey(key_size);
        }catch (Exception e){
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
            try {
                KeyGenerator key = KeyGenerator.getInstance(ALGORITHM);
                key.init(size);
                SecretKey secretKey = key.generateKey();
                log.info("Secret Key: {}", secretKey);
                return secretKey;
            } catch (NoSuchAlgorithmException e) {
                throw new IllegalStateException(e.toString());
            }
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
            log.info("Secret Key: {}", this);
            return this.secretKey;
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e.toString());
        }
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
            byte[] encoded = plaintext.getBytes(java.nio.charset.StandardCharsets.UTF_8);
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
            return base64EncodedString;
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
    public static String encrypt(String plaintext, PrivateKey privateKey) {

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
    public static String encrypt(String plaintext, PublicKey publicKey) {

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
    public static String decrypt(String cipherText, PrivateKey privateKey) {
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
    public static String decrypt(SecretKey secretKey, String cipherText) {
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
    public static String decrypt(PublicKey publicKey, String cipherText) {
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
     * Equals this object
     * @param o Secret object
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
        return "Secret{\n" +
//                "\"Id\":" + this.getId() + ",\n" +
                "\"password\":\"" + this.getPasswordToString() + "\",\n" +
                "\"secretKey\":\"{\n\t" +
                "\"encoding\":\"" + Arrays.toString(this.getSecretKey().getEncoded()) + "\",\n\t" +
                "\"format\":\"" + this.getSecretKey().getFormat() + "\",\n\t" +
                "\"algorithm\":\"" + this.getSecretKey().getAlgorithm() + "\"" +
                "\n}\",\n" +
                "\"isInitialized\":\"" + initialized + "\",\n" +
                "}";
    }


    public static void main(String[] args)
    {
        try {

            Secret password1 = new Secret("LendIT_Book_Kiosk");
            log.info("-----------------------------------------| New Secret Object: {}", password1);
            log.info("-----------------------------------------| Decrypted Plaintext Password1: {}",
                    Secret.decrypt(password1.getSecretKey(), password1.getPasswordToString()));
            log.info("-----------------------------------------| New Encrypted Password1: {}",
                    password1.getPasswordToString());
            Secret password2 = new Secret("password");
            log.info("-----------------------------------------| New Secret Object: {}", password2);
            log.info("-----------------------------------------| Decrypted Plaintext Password2: {}",
                    Secret.decrypt(password2.getSecretKey(), password2.getPasswordToString()));
            log.info("-----------------------------------------| New Encrypted Password2: {}",
                    password2.getPasswordToString());


        }catch (Exception e){
            log.error(e.getMessage());
            log.info(Arrays.stream(e.getStackTrace()).map(
                    x -> x + "\n"
            ).collect(Collectors.toList()).toString());
        }
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
}