package ro.kuberam.libs.java.crypto.toDo.testing;

import java.nio.charset.Charset;

import org.bouncycastle.util.encoders.Base64;

import ro.kuberam.libs.java.crypto.toDo.*;

public class PBKDF2 {

	/**
	 * 
	 * @param Example AML
	 */
    public static void main(String[] args) {
        try {
            String password = "iamtwentycharacterss";
            String salt = "50.eGIYr3ZpxpWw67utH17s/A==";
            int iterations = Integer.parseInt(salt.substring(0, salt.indexOf('.')));
            byte[] saltBytes = salt.getBytes(Charset.forName("UTF-8"));

            Rfc2898DeriveBytes rfc2898 = new Rfc2898DeriveBytes(password, saltBytes, iterations);
            byte[] key = rfc2898.getBytes(64);
            String hash = new String(Base64.encode(key));
            System.out.println(hash);
        } catch (Exception ex) {
            System.out.println("ERROR: " + ex);
        }
    }

}
