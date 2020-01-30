/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw1.sebastianjayramsey;

/**
 *Me and Sebastian found code for rc4 implementation from Stack overflow
 * https://stackoverflow.com/questions/12289717/rc4-encryption-java
 * @author sebastian.braun
 */
public class RC4 {
    
    private final byte[] Message;
    private final byte[] Key;

    public void RC4(byte[] k, byte[] m) {
        Message = m;
        Key = k;

    }

    public byte[] rc4Encryption() {
        byte[] cyphertext = null;

        byte[] message = this.Message;

        return cyphertext;
    }

    public byte[] rc4Decryption(byte[] cyphertext) {
        byte[] cText = cyphertext;

        byte[] message = null;

        return message;
    }
}
