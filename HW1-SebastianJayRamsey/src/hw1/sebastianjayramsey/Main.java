/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw1.sebastianjayramsey;

import java.util.Scanner;

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
    

    public static boolean TEAKeyCheck(byte[] key){
        return key.length == 16;
    }
    
    //Base64 encoding

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = "4d68023308dacfac5ee8d54a14d00caa";
        byte[] key = hexStringToByteArray(str);
        for (int i = 0; i < key.length; i++) {
            //https://stackoverflow.com/questions/12310017/
            //how-to-convert-a-byte-to-its-binary-string-representation 
            String s1 = String.format("%8s", Integer.toBinaryString(key[i] & 0xFF)).replace(' ', '0');
            System.out.print(s1 +" ");
        }
                    System.out.println("");
                    System.out.println(key.length);
        System.out.println(TEAKeyCheck(key) +"");
    }

}
