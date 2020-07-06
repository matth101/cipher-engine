package ciphers;

import java.util.HashMap;

public class Caesar implements Cipher {

    private String text;
    private int key;
    private String result;

    private StringBuilder sb;
    private HashMap<Integer, String> alphabet;

    public enum State {
        ENCRYPT,
        DECRYPT
    }
    public State state;

    public Caesar(String text, int key) {
        this.text = text.toUpperCase();
        this.key = key;
    }

    public Caesar(String text, int key, String mode) {
        this(text, key);

        sb = new StringBuilder(text.length());

        alphabet = new HashMap<Integer, String>(26);
        for (int i = 65; i <= 90; i++) {
            alphabet.put(i - 64, String.valueOf((char) i)); // initialize map with alphabet
        }

        if (mode == "encrypt") state = State.ENCRYPT;
        else if (mode == "decrypt") state = State.DECRYPT;
    }

    @Override
    public String process() {
        String holder = "";
        for (int i = 0; i < text.length(); i++) {
            int letterPos = (int) text.charAt(i);
            int newPos = 0;

            if (state == State.ENCRYPT) {
                newPos = letterPos - 64 + key;
            }
            else if (state == State.DECRYPT) {
                newPos = letterPos - 64 - key; // subtract down from ASCII and shift by the key value
            }

            if (newPos > 26 && state == State.ENCRYPT) {
                newPos -= 26;
            } else if (newPos < 0 && state == State.DECRYPT) {
                newPos += 26;
            }

            sb.append(alphabet.get(newPos));
        }

        holder = sb.toString();
        return holder;
    }

    public String getText() { return text; }
    public int getKey() { return key; }
    public void setText(String text) { this.text = text; }
    public void setKey(int key) { this.key = key; }
}
