package ciphers;

public interface Cipher {

    default String encrypt() { return null; }
    default String decrypt() { return null; }
    String process();

    int Z_ASCII_POS = 90;
    int A_ASCII_POS = 65;
}