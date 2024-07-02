package RSA;

import java.security.*;

public class RSAKeyGen {
    private KeyPairGenerator keyGen;
    private KeyPair keyPair;
    private PublicKey publicKey;
    private PrivateKey privateKey;

    public PublicKey getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(PublicKey publicKey) {
        this.publicKey = publicKey;
    }

    public PrivateKey getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(PrivateKey privateKey) {
        this.privateKey = privateKey;
    }

    // Sinh bộ khóa theo thuật toán RSA
    public RSAKeyGen(int keyLength) throws NoSuchAlgorithmException {
        keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(keyLength);
        keyPair = keyGen.generateKeyPair();
        setPublicKey(keyPair.getPublic());
        setPrivateKey(keyPair.getPrivate());
    }

    // Lưu bộ khóa ra file
}
