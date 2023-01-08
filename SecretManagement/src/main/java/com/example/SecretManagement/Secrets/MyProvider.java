package com.example.SecretManagement.Secrets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.*;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;

/**
 * <pre>
 * To create a custom security provider in Java, you can follow these steps:
 *
 * 1. Create a class that extends the java.security.Provider class.
 * Override the getName, getVersion, and getInfo methods to return the
 * name, version, and description of the provider, respectively.
 *
 * 2. Use the put method of the Provider class to add the security services
 * to the provider.
 *
 * 3. Create the security service implementations as subclasses of the relevant
 * Spi (service provider interface) classes. For example, if you are implementing
 * a message digest algorithm, you would create a subclass of MessageDigestSpi.
 *
 * 4. In the custom provider class, override the getService method to return an
 * instance of the security service implementation when requested.
 *
 * 5. To use the custom provider, you can add it to the list of registered providers
 * by calling the Security.addProvider method, passing an instance of the provider
 * class as the argument.
 * </pre>
 */
public class MyProvider extends Provider {
    // Declare serialVersionUID to be compatible with JDK1.1
    private static final long serialVersionUID = -4298000515446427740L;
//    /**
//     * Constructs a provider with the specified name, version number,
//     * and information. Calling this constructor is equivalent to call the
//     * {@link Provider(String, String, String)} with {@code name}
//     * name, {@code Double.toString(version)}, and {@code info}.
//     *
//     * @param name    the provider name.
//     * @param version the provider version number.
//     * @param info    a description of the provider and its services.
//     * @deprecated use {@link Provider(String, String, String)} instead.
//     */
//    protected MyProvider(String name, double version, String info) {
//        super(name, version, info);
//    }

    /**
     * Constructs a provider with the specified name, version string,
     * and information.
     *
     * <p>The version string contains a version number optionally followed
     * by other information separated by one of the characters of '+', '-'.
     * <p>
     * The format for the version number is:
     *
     * <blockquote><pre>
     *     ^[0-9]+(\.[0-9]+)*
     * </pre></blockquote>
     *
     * <p>In order to return the version number in a double, when there are
     * more than two components (separated by '.' as defined above), only
     * the first two components are retained. The resulting string is then
     * passed to {@link Double#valueOf(String)} to generate version number,
     * i.e. {@link #getVersion}.
     * <p>If the conversion failed, value 0 will be used.
     *
     * @since 9
     */
    @Deprecated
    protected MyProvider() {
        super("MyProvider", 1.0, "My security provider");
        put("MessageDigest.SHA-256", "MyMessageDigestSpi");
        put("KeyPairGenerator.RSA", "MyKeyPairGeneratorSpi");
        put("Cipher.AES", "MyAESCipherSpi");

    }
    /******************************************************************************
     * Implementing the MyAESCipherSpi class to provide the AES cipher functionality
     * is a non-trivial task, as it requires a detailed understanding of the AES
     * algorithm and the javax.crypto.CipherSpi class. Here is an example of a possible
     * implementation of the MyAESCipherSpi class
     */
    public static class MyAESCipherSpi extends IAESCipherSpi {
        private static final Logger log = LoggerFactory.getLogger(MyAESCipherSpi.class);

        private static final int BLOCK_SIZE = 16; // AES has a block size of 128 bits (16 bytes)
        private static final String ALGORITHM = "AES";

        private int mode;

        private AlgorithmParameters params;

        private int stateBuffer;

        private String padding;
        private SecretKeySpec keySpec;
        private IvParameterSpec ivSpec;

        /**
         * <pre>
         * The engineSetMode method of the javax.crypto.CipherSpi class is
         * used to set the mode of the cipher (e.g. ECB, CBC, etc.). This
         * method is typically not needed when implementing a custom cipher,
         * as the mode is usually specified as part of the transformation
         * string when initializing the cipher.
         *
         * To implement this method, we parse the mode string and validate
         * that it is a supported mode for the AES cipher. If supported we
         * save it to the this.mode variable.
         *
         * </pre>
         * @param mode the supported mode names for the AES cipher: "ECB", "CBC",
         *             "PCBC", "CTR", "CTS", "CFB", "CFB8", "CFB16", "CFB24", "CFB32",
         *             "CFB40", "CFB48", "CFB56", "CFB64", "OFB", "OFB8", "OFB16",
         *             "OFB24", "OFB32", "OFB40", "OFB48", "OFB56", "OFB64", "GCM".
         * @throws NoSuchAlgorithmException
         */
        @Override
        protected void engineSetMode(String mode) throws NoSuchAlgorithmException {
            try {
                /*
                 * Check if the mode string is null or empty. If it is, throw we
                 * NullPointerException or an IllegalArgumentException, respectively.
                 */
                if (mode == null || mode.isEmpty()) {
                    throw new NullPointerException("Mode cannot be null or empty");
                }
                /*
                 * Convert the mode string to upper case using the toUpperCase method of
                 * the String class.
                 */
                mode = mode.toUpperCase();
                /*
                 * Check if the mode string is equal to one of the supported mode
                 * names for the AES cipher. If the mode string does not match any of these names,
                 * throw an IllegalArgumentException.
                 */
                if (
                        !mode.equals("ECB") && !mode.equals("CBC") && !mode.equals("PCBC") && !mode.equals("CTR") && !mode.equals("CTS") &&
                        !mode.equals("CFB") && !mode.equals("CFB8") && !mode.equals("CFB16") && !mode.equals("CFB24") && !mode.equals("CFB32") &&
                        !mode.equals("CFB40") && !mode.equals("CFB48") && !mode.equals("CFB56") && !mode.equals("CFB64") && !mode.equals("OFB") &&
                        !mode.equals("OFB8") && !mode.equals("OFB16") && !mode.equals("OFB24") && !mode.equals("OFB32") && !mode.equals("OFB40") &&
                        !mode.equals("OFB48") && !mode.equals("OFB56") && !mode.equals("OFB64") && !mode.equals("GCM")
                ) {
                    throw new IllegalArgumentException("Unsupported mode: " + mode);
                }
                // store it in the 'mode' field
                this.mode = mode.toCharArray().length;
            } catch (IllegalArgumentException | NullPointerException e){
                log.error(e.getMessage());
                e.printStackTrace();
            }
        }

        /**
         * The engineSetPadding method of the javax.crypto.CipherSpi class is
         * used to set the padding scheme for the cipher. This method is
         * typically not needed when implementing a custom cipher, as the
         * padding scheme is usually specified as part of the transformation
         * string when initializing the cipher.
         *
         * To implement we parse the padding string and validate that
         * it is a supported padding scheme for the AES cipher.
         * Check if the padding string is equal to one of the supported
         * padding names for the AES cipher: "PKCS5PADDING", "PKCS7PADDING",
         * "ISO10126PADDING".
         *
         * Keep in mind that the engineSetPadding method will be called by
         * the Cipher class after the cipher has been initialized, so you
         * will need to take that into account.
         *
         * @param padding
         * @throws NoSuchPaddingException
         */
        @Override
        protected void engineSetPadding(String padding) throws NoSuchPaddingException {
            try {
                /*
                 * Check if the padding string is null or empty. If it is, throw a
                 * NullPointerException
                 */
                if (padding == null || padding.isEmpty()) {
                    throw new NullPointerException("Padding cannot be null or empty");
                }
                /*
                 * Convert the padding string to upper case using the toUpperCase
                 * method of the String class.
                 */
                padding = padding.toUpperCase();
                /*
                 * Check if the padding string is equal to one of the supported padding
                 * names for the AES cipher: "PKCS5PADDING", "PKCS7PADDING", "ISO10126PADDING".
                 * If the padding string does not match any of these names, throw an
                 * IllegalArgumentException.
                 */
                if (!padding.equals("PKCS5PADDING") &&
                    !padding.equals("PKCS7PADDING") &&
                    !padding.equals("ISO10126PADDING")
                ) {
                    throw new IllegalArgumentException("Unsupported padding: " + padding);
                }
                // Store the padding for later use
                this.padding = padding;
            } catch (NullPointerException | IllegalArgumentException e){
                log.error(e.getMessage());
                e.printStackTrace();
            }

        }

        /**
         * The engineGetBlockSize method of the javax.crypto.CipherSpi class is
         * used to get the block size of the cipher. The block size is the size
         * of the input and output blocks that the cipher processes, in bytes.
         *
         * The block size of the AES cipher is 16 bytes (128 bits). You can
         * simply return this value as the result of the engineGetBlockSize method.
         *
         * Keep in mind that the block size is fixed for a given cipher, and cannot
         * be changed. It is determined by the underlying encryption algorithm being used.
         *
         * @return
         */
        @Override
        protected int engineGetBlockSize() {
            return BLOCK_SIZE;
        }

        /**
         * The engineGetOutputSize method of the javax.crypto.CipherSpi
         * class is used to get the size of the output buffer that is
         * needed to process a block of input data with the cipher. This
         * is useful when allocating a buffer to hold the output data
         * from the engineUpdate or engineDoFinal methods.
         *
         * The size of the output buffer will depend on the mode of operation,
         * the padding scheme, and other factors. For example, in the case of
         * the AES cipher, the output buffer will be the same size as the input
         * buffer when using the ECB or CTR modes, but it will be larger when
         * using the CBC, CFB, OFB, or GCM modes, due to the need for padding
         * or other overhead.
         *
         * We will need to take these factors into account when calculating
         * the size of the output buffer. We can use the getOutputSize method
         * of the javax.crypto.Cipher class to get the size of the output buffer,
         * or we can calculate it manually based on the mode and padding scheme
         * being used.
         * @param inputLen
         * @return Return the size of the output buffer required for the given input length
         */
        @Override
        protected int engineGetOutputSize(int inputLen) {
            int blocks = inputLen / BLOCK_SIZE;
            if (inputLen % BLOCK_SIZE != 0) {
                blocks++;
            }
            int padding = (blocks * BLOCK_SIZE) - inputLen;
            return inputLen + padding;
        }

        /**
         * The engineGetIV method of the javax.crypto.CipherSpi class is
         * used to get the initialization vector (IV) for the cipher. The
         * IV is a block of data that is used in certain modes of operation
         * (e.g. CBC, CFB, OFB) to ensure that the same input data encrypted
         * with the same key will produce different output data. We can also
         * retrieve the IV from the ivSpec.
         *
         * Keep in mind that the IV is typically generated randomly when the
         * cipher is initialized, so you will need to take that into account
         * when storing and returning the IV.
         *
         * @return {@link  Byte}[]
         */
        @Override
        protected byte[] engineGetIV() {
            return ivSpec.getIV();
        }

        /**
         * An AlgorithmParameters object for managing the parameters for a particular
         * algorithm can be obtained by calling one of the getInstance factory methods
         * (static methods that return instances of a given class).
         *
         * Once an AlgorithmParameters object is obtained, it must be initialized via
         * a call to init, using an appropriate parameter specification or parameter encoding.
         *
         * A transparent parameter specification is obtained from an AlgorithmParameters
         * object via a call to getParameterSpec, and a byte encoding of the parameters
         * is obtained via a call to getEncoded.
         *
         * Every implementation of the Java platform is required to support the following
         * standard AlgorithmParameters algorithms:
         * <UL>
         *     <LI>AES
         *     <LI>DES
         *     <LI>DESede
         *     <LI>DiffieHellman
         *     <LI>DSA
         * These algorithms are described in the AlgorithmParameters section of the Java Security Standard Algorithm Names Specification. Consult the release documentation for your implementation to see if any other algorithms are supported.
         * Since:
         * @return
         */
        @Override
        protected AlgorithmParameters engineGetParameters() {
            return this.params;
        }

        @Override
        protected void engineInit(int opmode, Key key, AlgorithmParameters params, SecureRandom random)
                throws InvalidKeyException, InvalidAlgorithmParameterException {
            try {
                this.params = params;
                this.mode = opmode;
                this.keySpec = (SecretKeySpec) key;
                this.ivSpec =  params.getParameterSpec(IvParameterSpec.class);
            } catch (InvalidParameterSpecException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        protected void engineInit(int opmode, Key key, AlgorithmParameterSpec params, SecureRandom random)
                throws InvalidKeyException, InvalidAlgorithmParameterException {
            this.params = (AlgorithmParameters) params;
            this.mode = opmode;
            this.keySpec = (SecretKeySpec) key;
            this.ivSpec = (IvParameterSpec) params;
        }

        @Override
        protected void engineInit(int opmode, Key key, SecureRandom random) throws InvalidKeyException {
            this.mode = opmode;
            this.keySpec = (SecretKeySpec) key;
        }

        @Override
        protected byte[] engineUpdate(byte[] input, int inputOffset, int inputLen) {
            try {
                Cipher cipher = Cipher.getInstance(ALGORITHM);
                cipher.init(mode, keySpec, ivSpec);
                return cipher.update(input, inputOffset, inputLen);
            } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException |
                     InvalidAlgorithmParameterException e) {
                throw new RuntimeException(e);
            }
        }

        /**
         * The engineUpdate method processes a block of input data and store the
         * output in the specified buffer. We are using the update method of the
         * javax.crypto.Cipher class to process a block of input data and store
         * the output in the specified buffer. The update method returns the
         * number of bytes written to the output buffer, which we are returning
         * as the result of the engineUpdate method.
         *
         * Keep in mind that the engineUpdate method may be called multiple times
         * with different blocks of input data, so you will need to take that into
         * account when processing the data. In which case we can use an internal
         * buffer to store the intermediate state of the cipher if needed.
         *
         * @param input
         * @param inputOffset
         * @param inputLen
         * @param output
         * @param outputOffset
         * @return
         * @throws ShortBufferException
         */
        @Override
        protected int engineUpdate(byte[] input, int inputOffset, int inputLen, byte[] output, int outputOffset) throws ShortBufferException {
            try {
                Cipher cipher = Cipher.getInstance(ALGORITHM);
                cipher.init(mode, keySpec, ivSpec);
                int numBytes = cipher.update(input, inputOffset, inputLen, output, outputOffset);
                this.stateBuffer = numBytes;
                return this.stateBuffer;
            } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | InvalidAlgorithmParameterException e) {
                throw new RuntimeException(e);
            }
        }

        /**
         * The doFinal method of the javax.crypto.Cipher class to process the
         * remaining input data, perform any necessary final operations, and
         * return the output. The doFinal method handles padding and other
         * final operations automatically, based on the padding scheme and
         * mode of operation specified for the cipher.
         *
         * Keep in mind that the engineDoFinal method should only be called
         * after all the input data has been processed using the engineUpdate
         * method. It should not be called multiple times with different
         * blocks of input data.
         *
         * @param input
         * @param inputOffset
         * @param inputLen
         * @return
         * @throws IllegalBlockSizeException
         * @throws BadPaddingException
         */
        @Override
        protected byte[] engineDoFinal(byte[] input, int inputOffset, int inputLen)  {
            try {
                Cipher cipher = Cipher.getInstance(ALGORITHM);
                cipher.init(mode, keySpec, ivSpec);
                return cipher.doFinal(input, inputOffset, inputLen);
            } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | InvalidAlgorithmParameterException |
                    IllegalBlockSizeException | BadPaddingException e) {
                throw new RuntimeException(e);
            }
        }

        /**
         * In the doFinal method of the javax.crypto.Cipher class to process the
         * remaining input data, perform any necessary final operations, and store
         * the output in the specified buffer. The doFinal method handles padding
         * and other final operations automatically, based on the padding scheme
         * and mode of operation specified for the cipher. The doFinal method returns
         * the number of bytes written to the output buffer, which we are returning
         * as the result of the engineDoFinal method.
         *
         * Keep in mind that the engineDoFinal method should only be called after
         * all the input data has been processed using the engineUpdate method. It
         * should not be called multiple times with different blocks of input data.
         *
         * @param input
         * @param inputOffset
         * @param inputLen
         * @param output
         * @param outputOffset
         * @return
         * @throws ShortBufferException
         * @throws IllegalBlockSizeException
         * @throws BadPaddingException
         */
        @Override
        protected int engineDoFinal(byte[] input, int inputOffset, int inputLen, byte[] output, int outputOffset)
                throws ShortBufferException, IllegalBlockSizeException, BadPaddingException {
            try {
                Cipher cipher = Cipher.getInstance(ALGORITHM);
                cipher.init(mode, keySpec, ivSpec);
                return cipher.doFinal(input, inputOffset, inputLen, output, outputOffset);
            } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | InvalidAlgorithmParameterException e) {
                throw new RuntimeException(e);
            }
        }
    }
        /******************************************************************************/

}
