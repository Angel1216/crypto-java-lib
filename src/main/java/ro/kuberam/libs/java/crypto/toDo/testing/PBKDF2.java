package ro.kuberam.libs.java.crypto.toDo.testing;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import org.bouncycastle.util.encoders.Base64;

import ro.kuberam.libs.java.crypto.toDo.*;

public class PBKDF2 {

	/**
	 * 
	 * @param Example AML 2.
	 */
    public static void main(String[] args) {
    	
        try {
        	String str1;
            String str2 = "Hola Mundo";
            String cadena=""; 
            
            byte[] bytes1 = cadena.getBytes(StandardCharsets.UTF_16LE);
            byte[] bytes2 = "asd".getBytes(StandardCharsets.US_ASCII);
            
            
            String salt = "50.eGIYr3ZpxpWw67utH17s/A==";
            //int iterations = Integer.parseInt(salt.substring(0, salt.indexOf('.')));
            
            byte[] saltBytes = salt.getBytes(Charset.forName("UTF-8"));

            //Rfc2898DeriveBytes rfc2898 = new Rfc2898DeriveBytes(str2, saltBytes, iterations);
            Rfc2898DeriveBytes rfc2898 = new Rfc2898DeriveBytes(str2, saltBytes);
            
            byte[] key = rfc2898.getBytes(32);
            str1 = new String(Base64.encode(key));
            
            System.out.println(str1);
            
        } catch (Exception ex) {
            System.out.println("ERROR: " + ex);
        }
    }
// Hola Mundo
// z4yOk99NET92kLaxGpcUKfK5EjZraN2imBUO458P7AY=
// 

}
