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
 * TEA Message must be 32 Characters. Didn't get to padding
 *
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


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = "";
        String userkey = "";
        
        //User prompt logic
        System.out.println("Which algorithm would you like to use [R}C4 or [T}ea");
        if (scanner.nextLine().charAt(0) == 'R') {
            System.out.println("[E]ncryption or [D]ecryption");
            if (scanner.nextLine().charAt(0) == 'E') {
                
                System.out.println("Give message");
                text = scanner.nextLine();
                System.out.println("Give key");
                userkey = scanner.nextLine();
                
                RC4 e = new RC4(hexStringToByteArray(userkey));
                byte[] encrypted = e.encrypt(stringToByteArray(text));
                
                System.out.println(base64(encrypted));
            } else {
                
                System.out.println("Give message");
                text = scanner.nextLine();
                System.out.println("Give key");
                userkey = scanner.nextLine();
                
                RC4 e = new RC4(hexStringToByteArray(userkey));
                byte[] decrypted = e.decrypt(base64Decode(text));
                
                System.out.println(new String(decrypted));
            }
        } else {
            System.out.println("[E]ncryption or [D]ecryption");
            if (scanner.nextLine().charAt(0) == 'E') {
                
                System.out.println("Give message");
                text = scanner.nextLine();
                System.out.println("Give key");
                userkey = scanner.nextLine();
                
                TEA e = new TEA(stringToByteArray(text), hexStringToByteArray(userkey));
                byte[] encrypted = e.Tencryption();
                
                System.out.println(base64(encrypted));
            } else {
                
                System.out.println("Give message");
                text = scanner.nextLine();
                System.out.println("Give key");
                userkey = scanner.nextLine();
                
                TEA e = new TEA(base64Decode(text), hexStringToByteArray(userkey));
                byte[] decrypted = e.Tdecryption();
                
                String output = new String(decrypted);
                System.out.println(output);
            }
        }
    }
    //encodes byte array to base64
    public static String base64(byte[] ty) {
        String base64Encode = Base64.getEncoder().encodeToString(ty);
        return base64Encode;

    }
    //decodes base64 string to byte array
    public static byte[] base64Decode(String base64Encode) {

        byte[] base64Decode = Base64.getDecoder().decode(base64Encode);

        return base64Decode;

    }
    //converts normal string to byte array
    public static byte[] stringToByteArray(String s) {
        byte[] by = s.getBytes();
        return by;
    }

}
