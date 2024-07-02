package JCA;

import java.security.NoSuchAlgorithmException;

public class runMain {
    public static void main(String[] args) throws Exception {
        Digest digest = new Digest();
        String msg = "Hello word";
        String md5Hash = digest.md5Digest(msg);
        System.out.println("MD5 Hash: " + md5Hash);
        String sha1Hash = digest.sha1Digest(msg);
        System.out.println("SHA-1 Hash: " + sha1Hash);
        String sha1Hash1 = digest.sha1Digest1(msg);
        System.out.println("SHA-1 Hash: " + sha1Hash1);
        String sha256Hash = digest.getHashSHA256(msg);
        System.out.println("SHA-256 Hash: " + sha256Hash);

    }
}
