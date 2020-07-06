package ciphers;

public interface Cipher {

    public default String encrypt() { return null; }
    public default String decrypt() { return null; }
    public String process();

}