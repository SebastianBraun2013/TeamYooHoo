/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw1.sebastianjayramsey;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Base64;
import java.util.UUID;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
/**
 *
 * @author sebastian.braun
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    //*https://stackoverflow.com/questions/140131/
    //convert-a-string-representation-of-a-hex-dump-to-a-byte-array-using-java
    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i + 1), 16));
        }
        return data;
    }

    //String to Byte Array
    public static boolean TEAKeyCheck(byte[] key) {
        return key.length == 16;
    }

    //Base64 encoding
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = "4d68023308dacfac5ee8d54a14d00caa";
        String str2 = "22222222222222222222222222222222";
        byte[] message = hexStringToByteArray(str2);
        byte[] key = hexStringToByteArray(str);
        System.out.println("original");
        for (int i = 0; i < key.length; i++) {
            //https://stackoverflow.com/questions/12310017/
            //how-to-convert-a-byte-to-its-binary-string-representation 
            String s1 = String.format("%8s", Integer.toBinaryString(message[i] & 0xFF)).replace(' ', '0');
            System.out.print(s1 + " ");
        }
        
        System.out.println("");

        //System.out.println(key);
        RC4 oof = new RC4(key);
        RC4 oof2 = new RC4(key);
        byte[] encrypted = oof.encrypt(message);
        byte[] decrypted = oof2.decrypt(encrypted);
        
        
        
        System.out.println("encrypted");
        for (int i = 0; i < key.length; i++) {
            //https://stackoverflow.com/questions/12310017/
            //how-to-convert-a-byte-to-its-binary-string-representation 
            String s1 = String.format("%8s", Integer.toBinaryString(encrypted[i] & 0xFF)).replace(' ', '0');
            System.out.print(s1 + " ");
        }
        
        System.out.println("");
        
        System.out.println("decrypted/original");
        for (int i = 0; i < key.length; i++) {
            //https://stackoverflow.com/questions/12310017/
            //how-to-convert-a-byte-to-its-binary-string-representation 
            String s1 = String.format("%8s", Integer.toBinaryString(decrypted[i] & 0xFF)).replace(' ', '0');
            System.out.print(s1 + " ");
        }
        
        

        
        System.out.println("");
        
        
        base64(encrypted);
        
         base64(decrypted);
         
          base64(message);
          
        System.out.println("AAAAAAAAAAAAA");    
        System.out.println("");
         base64Decode(encrypted);
         base64Decode(decrypted);
         base64Decode(message);
         System.out.println("aaaa");
         System.out.println("");
        stringToByteArray("kdjfkfjslkdjfslkdjfslkd");
    }
    
    
    
    
    public static void base64(byte[] ty){
        String base64Encode = Base64.getEncoder().encodeToString(ty);
        System.out.println(base64Encode);
        
    }
    
    
    
    public static void base64Decode(byte[] ty){
        
        String base64Encode = Base64.getEncoder().encodeToString(ty);
        byte[] base64Decode = Base64.getDecoder().decode(base64Encode);
        System.out.println(Arrays.toString(base64Decode));
        
    }
    
    
    
    public static void stringToByteArray(String s ){
        byte[] by = s.getBytes();
        System.out.println("String to byte array" + Arrays.toString(by));
        
        
        
    }

}
