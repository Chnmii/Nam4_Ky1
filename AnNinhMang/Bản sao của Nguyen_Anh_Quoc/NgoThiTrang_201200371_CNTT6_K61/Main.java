import java.security.*;

public class Main {
    public static void main(String[] args) {
        try {
            // Tạo cặp khóa
            KeyPair keyPair = KeyGen.generateKeyPair();

            // Chuỗi cần ký
            String message = "Hello, World!";

            // Ký số
            String digitalSignature = DigitalSignature.sign(message, keyPair.getPrivate());
            System.out.println("Digital Signature: " + digitalSignature);

            // Xác minh chữ ký số
            boolean verified = DigitalSignature.verify(message, digitalSignature, keyPair.getPublic());
            System.out.println("Signature Verified: " + verified);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}