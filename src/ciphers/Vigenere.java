package ciphers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public String process() {
        if (text.contains(" ")) {
            text.replaceAll(" ", "");
        }

        List<Character> inputChars = getCharArray(text); // put characters of word into list
        List<Character> keyChars = getCharArray(key); // same for key

        int counter = 0;
        for (int i = 0; i < inputChars.size(); i++) {
            char inputChar = inputChars.get(i);
            if (counter == keyChars.size()) counter = 0; // line up the key with input

            char keyChar = keyChars.get(counter);
            counter++;

            int length = 26;
            int newPos = state == State.ENCRYPT ? (int) inputChar + (int) keyChar : (int) inputChar - (int) keyChar;
            sb.append((char) (((newPos + length) % length) + A_ASCII_POS));
        }

        return sb.toString();
    }

    public List<Character> getCharArray(String string) {
        return string.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
    }

}
