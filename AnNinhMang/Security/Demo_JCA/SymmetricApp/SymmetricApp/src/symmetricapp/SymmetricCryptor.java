/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package symmetricapp;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

/**
 *
 * @author DzungLM
 */
public class SymmetricCryptor {
    //hằng xác định thuật toán mã hóa
    private final String Algorithm = "AES";
    //khóa
    private SecretKey secretKey;
    //bộ sinh khóa theo thuật toán đã chọn
    private KeyGenerator keyGen;
    //bộ mã
    private Cipher cipher;

    public SymmetricCryptor() 
            throws NoSuchAlgorithmException 
    {
        //khởi tạo bộ sinh khóa
        keyGen = KeyGenerator.getInstance(Algorithm);
        //sinh khóa
        secretKey = keyGen.generateKey(); 
        String key = "mothaibabonnamsa";
        secretKeySpec = new secretKeySpec(key.getBytes(), algorithm);
    }

    public SecretKey getSecretKey() {
        return secretKey;  
    }
    public String encryptText(String msg, SecretKey key) 
            throws NoSuchAlgorithmException, 
            NoSuchPaddingException,
            InvalidKeyException,
            UnsupportedEncodingException,
            IllegalBlockSizeException,
            BadPaddingException
    {
        //tạo bộ mã
        cipher = Cipher.getInstance(Algorithm);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return Base64.getEncoder().encodeToString(
            cipher.doFinal(msg.getBytes("UTF-8")));
    }
    public String decryptText(String msg, SecretKey key) 
            throws NoSuchAlgorithmException, 
            NoSuchPaddingException,
            InvalidKeyException,
            IllegalBlockSizeException,
            BadPaddingException,
            UnsupportedEncodingException
    {
        // khởi tạo bộ mã
        cipher = Cipher.getInstance(Algorithm);
        // xác lập chế độ giải mã
        cipher.init(Cipher.DECRYPT_MODE, key);
        // để giải mã dùng hàm doFinal của đối tượng cipher
        // tham số vào là luồng bit cần giải mã
        return new String(cipher.doFinal(
                Base64.getDecoder().decode(msg)),"UTF-8");
    }
}
