/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keygen;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

/**
 *
 * @author DzungLM
 */
public class KeyPairGen {
    //Bộ sinh cặp khóa
    private KeyPairGenerator keyGen;
    //lưu trữ Cặp khóa public và private
    private KeyPair keypair;
    //đối tượng lưu trữ khoá bí mật
    private PrivateKey privateKey;
    //đối tượng lưu trữ khoá công khai
    private PublicKey publicKey;

    public KeyPairGen(int keylength) 
            throws NoSuchAlgorithmException {
        //tạo bộ sinh khóa
        keyGen = KeyPairGenerator.getInstance("RSA");
        //khởi tạo bộ sinh khoá với tham số dâuù vào là số byte
        keyGen.initialize(keylength);
        //sinh khóa
        keypair = keyGen.generateKeyPair();
        //lấy khoá bí mật
        privateKey = keypair.getPrivate();
        //lấy khoá công khai
        publicKey = keypair.getPublic();
    }
    
    //lưu trữ khóa ra file
    public void writeToFile(String path, byte[] key) 
            throws FileNotFoundException, IOException
    {
        File f = new File(path);
        //tạo thư mục chung chứa cặp khóa
        f.getParentFile().mkdir();
        //lưu khóa ra file tương ứng
        FileOutputStream fos = new FileOutputStream(f);
        fos.write(key);
        fos.flush();
        fos.close();
    }
    
    
    public PrivateKey getPrivateKey() {
        return privateKey;
    }

    public PublicKey getPublicKey() {
        return publicKey;
    }
    
    
}
