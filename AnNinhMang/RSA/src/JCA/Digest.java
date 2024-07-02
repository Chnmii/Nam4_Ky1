package JCA;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Digest {
//     MD5
    public String md5Digest(String msg) throws NoSuchAlgorithmException {
        MessageDigest md = null;
        md = MessageDigest.getInstance("MD5");
        md.update(msg.getBytes(StandardCharsets.UTF_8),0,msg.length());
        return printHexBinary(md.digest());
    }

    private String printHexBinary(byte[] bytes) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : bytes) {
            stringBuilder.append(String.format("%02X", b));
        }
        return stringBuilder.toString();
    }

    // sha-1
    public String sha1Digest(String msg) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        md.update(msg.getBytes(StandardCharsets.UTF_8),0, msg.length());
        return new BigInteger(1, md.digest()).toString(16);
    }
    public String sha1Digest1(String msg) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        md.update(msg.getBytes(StandardCharsets.UTF_8),0, msg.length());
        return printHexBinary(md.digest());
    }


    // SHA-256
    public String getHashSHA256(String origin) throws Exception{
        MessageDigest msg = MessageDigest.getInstance("SHA-256");
        msg.update(origin.getBytes(StandardCharsets.UTF_8), 0, origin.length());
        return  new BigInteger(1, msg.digest()).toString(16);
    }

    public void writeToFile(String path){

    }
}
