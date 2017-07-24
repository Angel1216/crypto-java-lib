package ro.kuberam.libs.java.crypto.toDo.testing;

import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.stream.Stream;

import org.bouncycastle.util.encoders.Base64;

import ro.kuberam.libs.java.crypto.toDo.*;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class PBKDF2 {

	/**
	 * 
	 * @param Example AML 2.
	 */
    public static void main(String[] args) {
    	
        try {
        	String str1;
            String str2 = "s3gur1d@dbuf3t3d3@s3s0r3s3ns1st3m@s";
            String cadena="Hola Mundo"; 
            
            byte[] bytes1 = cadena.getBytes(StandardCharsets.UTF_16LE);
            byte[] bytes2 = str2.getBytes(StandardCharsets.US_ASCII);
            
            
            String salt = "50.eGIYr3ZpxpWw67utH17s/A==";
            //int iterations = Integer.parseInt(salt.substring(0, salt.indexOf('.')));
            
            //byte[] saltBytes = salt.getBytes(Charset.forName("UTF-8"));

            //Rfc2898DeriveBytes rfc2898 = new Rfc2898DeriveBytes(str2, saltBytes, iterations);
            //Rfc2898DeriveBytes rfc2898 = new Rfc2898DeriveBytes(str2, saltBytes);
            Rfc2898DeriveBytes rfc2898 = new Rfc2898DeriveBytes(str2, bytes2);
            
            RijndaelCrypt rijndaelCrypt = new RijndaelCrypt(rfc2898.toString());

            
            
            System.out.println(rijndaelCrypt.encrypt(bytes1));
//            java.io.ByteArrayOutputStream memoryStream = new java.io.ByteArrayOutputStream();
            
            
            
            
            
               
            //CipherInputStream cryptoStream = new CryptoStream((Stream)memoryStream, encryptor, CryptoStreamMode.Write);
//            CipherOutputStream cryptoStream = new CipherOutputStream(arg0, arg1)
//    		cryptoStream.Write(bytes1, 0, bytes1.length);
//    		cryptoStream.FlushFinalBlock();
            //cryptoStream.write(bytes1);
//            cryptoStream.flush();

    		
            
            byte[] key2 = rfc2898.getBytes(32);
            str1 = new String(Base64.encode(key2));
            
            System.out.println(str1);
            
        } catch (Exception ex) {
            System.out.println("ERROR: " + ex);
        }
    }
// Hola Mundo
// z4yOk99NET92kLaxGpcUKfK5EjZraN2imBUO458P7AY=
// 

}
