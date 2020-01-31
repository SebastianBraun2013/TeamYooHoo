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
        
        
        String plainText = "";
        String userkey = "";
        System.out.println("Which algorithm would you like to use [R}C4 or [T}ea");
        if(scanner.nextLine().charAt(0) == 'R'){
            System.out.println("[E]ncryption or [D]ecryption");
            if(scanner.nextLine().charAt(0) == 'E'){
                System.out.println("Give message");
                plainText = scanner.nextLine();
                System.out.println("Give key");
                userkey = scanner.nextLine();
                RC4 e = new RC4(hexStringToByteArray(userkey));
                byte[] encrypted = e.encrypt(hexStringToByteArray(plainText));//change this to string2byte[]
                System.out.println(base64(encrypted));
            } else {
                System.out.println("Give message");
                plainText = scanner.nextLine();

                System.out.println("Give key");
                userkey = scanner.nextLine();
                RC4 e = new RC4(hexStringToByteArray(userkey));
                byte[] decrypted = e.decrypt(base64Decode(plainText));//change this to string2byte[]
                System.out.println("" + decrypted.toString());
            }
        } else{
            System.out.println("[E]ncryption or [D]ecryption");
            if(scanner.nextLine().charAt(0) == 'E'){
                System.out.println("Give message");
                plainText = scanner.nextLine();
                System.out.println("Give key");
                userkey = scanner.nextLine();
                RC4 e = new RC4(hexStringToByteArray(userkey));
                byte[] encrypted = e.encrypt(hexStringToByteArray(plainText));//change this to string2byte[]
                System.out.println(base64(encrypted));
            } else {
                System.out.println("Give message");
                plainText = scanner.nextLine();

                System.out.println("Give key");
                userkey = scanner.nextLine();
                RC4 e = new RC4(hexStringToByteArray(userkey));
                byte[] decrypted = e.decrypt(base64Decode(plainText));//change this to string2byte[]
                String output = new String(decrypted);
                System.out.println(output);
            }
        }
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
        // base64Decode(encrypted);
        // base64Decode(decrypted);
         //base64Decode(message);
        
    }
    
    
    
    
    public static String base64(byte[] ty){
        String base64Encode = Base64.getEncoder().encodeToString(ty);
        return base64Encode;
        
    }
    
    
    
    public static byte[] base64Decode(String base64Encode){

        byte[] base64Decode = Base64.getDecoder().decode(base64Encode);
        
        return base64Decode;
        
    }
    

}
