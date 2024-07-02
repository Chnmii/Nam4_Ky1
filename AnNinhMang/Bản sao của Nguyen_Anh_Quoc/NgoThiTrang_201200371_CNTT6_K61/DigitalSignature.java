import java.security.*;
import java.util.Base64;

public class DigitalSignature {
    public static String sign(String message, PrivateKey privateKey)
            throws Exception {
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initSign(privateKey);
        byte[] messageBytes = message.getBytes();
        signature.update(messageBytes);
        byte[] digitalSignature = signature.sign();
        return Base64.getEncoder().encodeToString(digitalSignature);
    }

    public static boolean verify(String message, String digitalSignature, PublicKey publicKey)
            throws Exception {
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initVerify(publicKey);
        byte[] messageBytes = message.getBytes();
        signature.update(messageBytes);
        byte[] digitalSignatureBytes = Base64.getDecoder().decode(digitalSignature);
        return signature.verify(digitalSignatureBytes);
    }
}