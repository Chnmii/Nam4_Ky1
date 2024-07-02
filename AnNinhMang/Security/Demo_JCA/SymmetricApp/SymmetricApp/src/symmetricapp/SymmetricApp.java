/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package symmetricapp;

import java.security.NoSuchAlgorithmException;

/**
 *
 * @author DzungLM
 */
public class SymmetricApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
            throws Exception {
        // TODO code application logic here
        SymmetricCryptor SC = new SymmetricCryptor();
        String msg = "Nguyễn Văn An";
        String encrypted_msg = 
                SC.encryptText(msg, SC.getSecretKey());
        System.out.println("Plain text: " + msg);
        System.out.println("Encrypted text: " + encrypted_msg);
        String decrypted_msg =
                SC.decryptText(encrypted_msg, SC.getSecretKey());
        System.out.println("Decrypted text: " + decrypted_msg);
    }
    
}
