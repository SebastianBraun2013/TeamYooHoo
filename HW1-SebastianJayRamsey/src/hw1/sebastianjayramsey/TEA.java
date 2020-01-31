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
public class TEA {

    private byte[] message;
    private byte[] key;
    private final int delta = 0x9E3779B9;
    private int sum;

    public TEA(byte[] m, byte[] k) {
        if (key.length != 16) {
            throw new IllegalArgumentException(
                    "key must be 128 bits");
        } else {
            message = m;
            key = k;
        }

    }

    public byte[] Tencryption() {
        int[] ciphertext = new int[message.length];

        for (int j = 0, k = 1; j < message.length && k < message.length; j = j + 2, k = k + 2) {
            sum = 0;
            int l = message[j];
            int r = message[k];
            for (int i = 0; i < 32; i++) {
                sum = sum + delta;
                l = l + (((r << 4) + key[0]) ^ (r + sum) ^ ((r >> 5) + key[1]));
                r = r + (((l << 4) + key[2]) ^ (l + sum) ^ ((l >> 5) + key[3]));
            }
            ciphertext[j] = l;
            ciphertext[k] = r;
        }
        return this.Inttobyte(ciphertext);

    }

    public byte[] Tdecryption() {
        int[] plaintext = new int[message.length];

        for (int j = 0, k = 1; j < message.length && k < message.length; j = j + 2, k = k + 2) {
            sum = delta << 5;
            int l = message[j];
            int r = message[k];
            for (int i = 0; i < 32; i++) {
                r = r - (((l << 4) + key[2]) ^ (l + sum) ^ ((l >> 5) + key[3]));
                l = l - (((r << 4) + key[0]) ^ (r + sum) ^ ((r >> 5) + key[1]));
                sum = sum - delta;
            }
            plaintext[j] = l;
            plaintext[k] = r;
        }
        return this.Inttobyte(plaintext);
    }
    // from https://stackoverflow.com/questions/44059116/how-to-convert-int-array-to-base64-string-in-java

    private byte[] Inttobyte(int[] ints) {
        byte[] bytes = new byte[ints.length];
        for (int i = 0; i < ints.length; i++) {
            bytes[i] = (byte) ints[i];
        }
        return bytes;
    }
}
