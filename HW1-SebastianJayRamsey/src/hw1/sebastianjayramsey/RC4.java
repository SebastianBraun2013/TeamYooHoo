/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw1.sebastianjayramsey;

/**
 * Me and Sebastian found code for rc4 implementation from Stack overflow
 * https://stackoverflow.com/questions/12289717/rc4-encryption-java
 *
 * @author sebastian.braun
 */
public class RC4 {

    private final byte[] S = new byte[256];
    private final byte[] T = new byte[256];
    private int keyLength;

    public void RC4(final byte[] key) {
        if (key.length < 1 || key.length > 256) {
            throw new IllegalArgumentException(
                    "key must be between 1 and 256 bytes");
        } else {
            keyLength = key.length;
            for (int i = 0; i < 256; i++) {
                S[i] = (byte) i;
                T[i] = key[i % keyLength];
            }
            int j = 0;
            byte temp;
            for (int i = 0; i < 256; i++) {
                j = (j + S[i] + T[i]) & 0xFF;
                temp = S[j];
                S[j] = S[i];
                S[i] = temp;
            }

        }

    }

    public byte[] rc4Encryption(final byte[] plaintext) {
        final byte[] ciphertext = new byte[plaintext.length];
        int i = 0, j = 0, k, t;
        byte temp;
        for (int count = 0; count < plaintext.length; count++) {
            i = (i + 1) & 0xFF;
            j = (j + S[i]) & 0xFF;
            temp = S[j];
            S[j] = S[i];
            S[i] = temp;
            t = (S[i] + S[j]) & 0xFF;
            k = S[t];
            ciphertext[count] = (byte) (plaintext[count] ^ k);

        }

        return ciphertext;
    }

    public byte[] rc4Decryption(byte[] ciphertext) {
        return rc4Encryption(ciphertext);
    }
}
