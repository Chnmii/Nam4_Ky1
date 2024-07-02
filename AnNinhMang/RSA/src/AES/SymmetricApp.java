package AES;

import java.security.NoSuchAlgorithmException;

// Sử dụng SymmetricApp  để mã hóa 1 chuỗi cho trước hoặc giả mã ra bản rõ trước đó.
public class SymmetricApp {
    public static void main(String[] args) throws Exception {
        SymmetricCryp sc = new SymmetricCryp();
        String msg = "Nguyễn Thị Ngũ";
        String encrypted_msg = sc.encryptText(msg, sc.getSecretKey());
        System.out.println("Plain text: " + msg);
        System.out.println("Encrypted text: " + encrypted_msg);

        String decrypted_msg = sc.decryptText(encrypted_msg, sc.getSecretKey());
        System.out.println("Decrypted text: "+ decrypted_msg);



        SymmetricCryp cs2 = new SymmetricCryp("stackjava.com.if");
        String msg2 = "Ngô Văn Khải";
        String encrypted_msg2 = sc.encryptText(msg2, cs2.getSecretKeySpec());
        System.out.println("Plain text: " + msg2);
        System.out.println("Encrypted text: " + encrypted_msg2);

        String decrypted_msg2 = sc.decryptText(encrypted_msg2, cs2.getSecretKeySpec());
        System.out.println("Decrypted text: "+ decrypted_msg2);
    }
}
