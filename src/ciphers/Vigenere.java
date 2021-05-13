package ciphers;

public class Vigenere implements Cipher { // encoded with an alphabet square generally

    private String text;
    private String key;
    private StringBuilder sb;
    private State state;

    public Vigenere(String text, String key, String mode) {
        this.text = text.toUpperCase();
        this.key = key.toUpperCase();

        sb = new StringBuilder(text.length());

        if (mode.equals("encrypt")) state = State.ENCRYPT;
        else if (mode.equals("decrypt")) state = State.DECRYPT;
    }

    public String process() {
        int counter = 0;
        for (int i = 0; i < text.length(); i++) {
            char inputChar = text.charAt(i);
            if (inputChar == ' ') {
                sb.append(' ');
                continue;
            }

            if (counter == key.length()) counter = 0; // line up the key with input
            char keyChar = key.charAt(counter);
            counter++;

            int length = 26;
            int newPos = state == State.ENCRYPT ? (int) inputChar + (int) keyChar : (int) inputChar - (int) keyChar;
            sb.append((char) (((newPos + length) % length) + A_ASCII_POS));
        }

        return sb.toString();
    }
}
