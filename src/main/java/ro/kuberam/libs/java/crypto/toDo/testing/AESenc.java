package ro.kuberam.libs.java.crypto.toDo.testing;

import java.nio.charset.Charset;
import java.security.Key;
import javax.crypto.Cipher;
//import sun.misc.BASE64Encoder;
//import sun.misc.BASE64Decoder;
import java.util.Base64;
import javax.crypto.spec.SecretKeySpec;

import org.bouncycastle.util.Arrays;

public class AESenc {

    private static final String ALGO = "AES";
    private static final byte[] keyValue =
            new byte[] {'s','3','g','u','r','1','d','@','d','b','u','f','3','t','3','d','3','@','s','3','s','0','r','3','s','3','n','s','1','s','t','3','m','@','s'};
    // {'T', 'h', 'e', 'B', 'e', 's', 't', 'S', 'e', 'c', 'r', 'e', 't', 'K', 'e', 'y'};
    private static String llave = "s3gur1d@dbuf3t3d3@s3s0r3s3ns1st3m@s";
    /**
     * Encrypt a string with AES algorithm.
     *
     * @param data is a string
     * @return the encrypted string
     */
    public static String encrypt(String data) throws Exception {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] encVal = c.doFinal(data.getBytes());
        System.out.println(encVal);
        //return new BASE64Encoder().encode(encVal);
        System.out.println(Base64.getEncoder().encodeToString(encVal));
        return Base64.getEncoder().encodeToString(encVal);
    }

    /**
     * Decrypt a string with AES algorithm.
     *
     * @param encryptedData is a string
     * @return the decrypted string
     */
//    public static String decrypt(String encryptedData) throws Exception {
//        Key key = generateKey();
//        Cipher c = Cipher.getInstance(ALGO);
//        c.init(Cipher.DECRYPT_MODE, key);
//        byte[] decordedValue = new BASE64Decoder().decodeBuffer(encryptedData);
//        byte[] decValue = c.doFinal(decordedValue);
//        return new String(decValue);
//    }

    /**
     * Generate a new encryption key.
     */
    private static Key generateKey() throws Exception {
        return new SecretKeySpec(java.util.Arrays.copyOf(llave.getBytes(), 16), ALGO);
    }
    
    
    public static void main(String[] args) throws Exception{
    	encrypt("Hola Mundo");
    }
}