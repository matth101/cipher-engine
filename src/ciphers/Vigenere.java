package ciphers;

public class Vigenere implements Cipher { // encoded with an alphabet square generally

    private String text;
    private String key;
    private StringBuilder sb;
    private State state;

    public Vigenere(String[] input) {
        this.text = input[1].toUpperCase();
        this.key = input[2].toUpperCase();

        sb = new StringBuilder(text.length());

        if (input[3].toUpperCase().equals("ENCRYPT")) state = State.ENCRYPT;
        else if (input[3].toUpperCase().equals("DECRYPT")) state = State.DECRYPT;
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
