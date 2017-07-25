package ro.kuberam.libs.java.crypto.toDo.testing;

import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.stream.Stream;

//import org.bouncycastle.util.encoders.Base64;

import ro.kuberam.libs.java.crypto.toDo.*;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.bouncycastle.jce.provider.JCEBlockCipher.AES;

import java.util.Base64;
import java.util.Random;



public class PBKDF2 {

	/**
	 * 
	 * @param Example AML 2.
	 */
    public static void main(String[] args) {
    	
        try {
            String EncryptionKey = "s3gur1d@dbuf3t3d3@s3s0r3s3ns1st3m@s";
            String clearText="Hola Pinche Mundo"; 
            byte[] clearBytes = clearText.getBytes(StandardCharsets.UTF_16LE);
            byte[] bytes2 = EncryptionKey.getBytes(StandardCharsets.US_ASCII);
            Rfc2898DeriveBytes pdb = new Rfc2898DeriveBytes(EncryptionKey, bytes2);
            SecretKeySpec secretKeySpec = new SecretKeySpec(pdb.getBytes(32), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            IvParameterSpec iv = new IvParameterSpec(pdb.getBytes(16));
            cipher.init(Cipher.ENCRYPT_MODE,secretKeySpec,iv);
            java.io.ByteArrayOutputStream memoryStream = new java.io.ByteArrayOutputStream();
            CipherOutputStream cryptoStream = new CipherOutputStream(memoryStream, cipher);
            cryptoStream.write(clearBytes);
            cryptoStream.close();
            String base64 = Base64.getEncoder().encodeToString( memoryStream.toByteArray() );
            //System.out.println("base64");
            System.out.println(base64);
            
        } catch (Exception ex) {
            System.out.println("ERROR: " + ex);
        }
    }
// Hola Mundo
// z4yOk99NET92kLaxGpcUKfK5EjZraN2imBUO458P7AY=
//   z4yOk99NET92kLaxGpcUKfK5EjZraN2imBUO458P7AY=
// 
    
    //Hola Pinche Mundo
    // dF8GYak6XjP1QFgljxpqrWbdD+drl/eQjM7hXhn7iVHE+nIjHoUp7Nqt+fDLB1LQ //C#
    // dF8GYak6XjP1QFgljxpqrWbdD+drl/eQjM7hXhn7iVHE+nIjHoUp7Nqt+fDLB1LQ //JAVA
    // Version Final

}
