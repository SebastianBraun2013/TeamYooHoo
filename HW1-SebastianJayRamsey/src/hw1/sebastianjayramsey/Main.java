/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw1.sebastianjayramsey;

/**
 *
 * @author sebastian.braun
 */
public class Main {

     /* https://stackoverflow.com/questions/140131/
     * convert-a-string-representation-of-a-hex-dump-to-a-byte-array-using-java
     *
     * @param s
     * @return
     */
    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i + 1), 16));
        }
        return data;
    }

    public static boolean TEACheck(byte[] key){
        return key.length % 16 == 0;
    }
    
    //base64 encoding of encrypted byte array
    //plaintext message -> byte[]
    
    public static void main(String[] args) {

    }

}
