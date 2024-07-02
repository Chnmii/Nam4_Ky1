package AES;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class SymmetricCryp {
    private final String Algorithm = "AES";
    private SecretKey secretKey;   // khóa
    private SecretKeySpec secretKeySpec;  // khóa theo chuỗi cho trước
    private KeyGenerator keyGenerator;   // bản sinh khóa theo thuật toán đã chọn
    private Cipher cipher;  // bản mã

    // Sinh khóa đối xướng
    public SymmetricCryp() throws NoSuchAlgorithmException {
        keyGenerator = KeyGenerator.getInstance(Algorithm);
        secretKey = keyGenerator.generateKey();
    }

    // Táo kháo đối xứng của một chuỗi cho trước
    public SymmetricCryp(String key){
        secretKeySpec = new SecretKeySpec(key.getBytes(), "AES");
    }
    public SecretKey getSecretKey(){
        return secretKey;
    }
    public SecretKey getSecretKeySpec(){
        return secretKeySpec;
    }

    // Mã hóa thông điệp 2 tham số: tham số 1 là bản mã, tham số 2 là khóa bí mật
    // được tạo ở 1.1
    public String encryptText(String msg, SecretKey key)
            throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException {
        cipher = Cipher.getInstance(Algorithm);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return Base64.getEncoder().encodeToString(cipher.doFinal(msg.getBytes(StandardCharsets.UTF_8)));
    }

    // Mã hóa thông điệp có 2 tham số: tham số 1 là bản mã, tham số thứ 2 là khóa bí mật được tạo ở 1.2
    public String encryptText(String msg, SecretKeySpec key) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException {
        cipher = Cipher.getInstance(Algorithm);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return Base64.getEncoder().encodeToString(cipher.doFinal(msg.getBytes(StandardCharsets.UTF_8)));
    }

    // Giả mã có 2 tham số: tham số 1 là bản mã, tham số 2 là khóa bí mật được tạo ở 1.1
    public String decryptText(String msg, SecretKey key) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
        cipher = Cipher.getInstance(Algorithm);
        cipher.init(Cipher.DECRYPT_MODE, key);
        return new String(cipher.doFinal(Base64.getDecoder().decode(msg)), StandardCharsets.UTF_8);
    }


    // Giả mã có 2 tham số: tham số 1 là bản mã, tham số 2 là khóa bí mật được tạo ở 1.2
    public String decryptText(String msg, SecretKeySpec key) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
        cipher = Cipher.getInstance(Algorithm);
        cipher.init(Cipher.DECRYPT_MODE, key);
        return new String(cipher.doFinal(Base64.getDecoder().decode(msg)), StandardCharsets.UTF_8);
    }
}
