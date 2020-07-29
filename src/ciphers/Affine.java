package ciphers;

public class Affine implements Cipher {

    private String text;

    private State state;

    public Affine(String text, String mode) {
        this.text = text.toUpperCase();

        if (mode.equals("encrypt")) state = State.ENCRYPT;
        else if (mode.equals("decrypt")) state = State.DECRYPT;
    }

    @Override
    public String process() {
        return null;
    }

    @Override
    public String encrypt() {
        return null;
    }

    @Override
    public String decrypt() {
        return null;
    }
}
