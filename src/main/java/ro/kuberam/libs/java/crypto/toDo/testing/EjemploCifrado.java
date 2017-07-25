package ro.kuberam.libs.java.crypto.toDo.testing;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

import java.util.Base64;

/**
 *
 * @author Vicente
 */
public class EjemploCifrado {
    
    private Cipher cifrado;
    private byte[] iv;
    private Cipher descifrado;
    private ByteArrayOutputStream outputStream;
    
    public EjemploCifrado(){
       
        KeyGenerator kgen;
        
        try {
            
            // Se genera la key
            kgen = KeyGenerator.getInstance("AES");
            kgen.init(256);
            SecretKey aesKey = kgen.generateKey();

            // Cifrado
            cifrado = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cifrado.init(Cipher.ENCRYPT_MODE, aesKey);
            
            // Descifrado
            descifrado = Cipher.getInstance("AES/CBC/PKCS5Padding");
            iv = cifrado.getIV();
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);
            descifrado.init(Cipher.DECRYPT_MODE, aesKey, ivParameterSpec);
            
        } catch (NoSuchAlgorithmException | InvalidKeyException | NoSuchPaddingException | InvalidAlgorithmParameterException ex) {
            Logger.getLogger(EjemploCifrado.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    public byte[] cifrarMensaje(String mensaje){
        
        String mensajeCifrado = null;
        byte[] BytesEncriptados = null;
        
        try {
            outputStream = new ByteArrayOutputStream();
            try (CipherOutputStream cipherOutputStream = new CipherOutputStream(outputStream, cifrado)) {
                cipherOutputStream.write(mensaje.getBytes());
                cipherOutputStream.flush();
            }
            BytesEncriptados = outputStream.toByteArray();
            
        } catch (IOException ex) {
            Logger.getLogger(EjemploCifrado.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return BytesEncriptados;
        
    }
    
    public String descifrarMensaje(byte[] mensaje){
        
        outputStream = new ByteArrayOutputStream();
        ByteArrayInputStream inStream = new ByteArrayInputStream(mensaje);
        CipherInputStream cipherInputStream = new CipherInputStream(inStream, descifrado);
        byte[] buf = new byte[1024];
        int bytesRead;
        try {
            while ((bytesRead = cipherInputStream.read(buf)) >= 0) {
                outputStream.write(buf, 0, bytesRead);
            }
        } catch (IOException ex) {
            Logger.getLogger(EjemploCifrado.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return new String(outputStream.toByteArray());
        
    }
    
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        String mensaje = "Hola Mundo";
        byte[] mensajeCifrado;
        String mensajeDescifrado;
        
        EjemploCifrado ejemplo = new EjemploCifrado();
        
        mensajeCifrado = ejemplo.cifrarMensaje(mensaje);
        mensajeDescifrado = ejemplo.descifrarMensaje(mensajeCifrado);
        
        System.out.println(mensaje);
        System.out.println(Base64.getEncoder().encodeToString(mensajeCifrado));
        System.out.println(mensajeDescifrado);
         
    }
    
    
}