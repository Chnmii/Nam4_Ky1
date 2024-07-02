/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keygen;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author DzungLM
 */
public class KeyGen {
    public static void main(String[] args) 
            throws NoSuchAlgorithmException, 
            IOException
    {
        KeyGenerator kg = new KeyGenerator(1024);
        kg.writeToFile("D:/Keys/PublicKey", 
                kg.getPublicKey().getEncoded());
        kg.writeToFile("D:/Keys/PrivateKey", 
                kg.getPrivateKey().getEncoded());
        System.out.println("Keys were generated!!!!");
    }
}
