package ciphers;

import java.util.ArrayList;
import java.util.List;

public class Vigenere implements Cipher {
    // encoded with an alphabet square generally

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
        String holder = "";
        String combinedText = "";

        if (text.contains(" ")) {
            String[] words = text.split(" ");
            for (String word : words) {
                combinedText += word;
            }
        } else {
            combinedText = text;
        }

        List<Character> inputChars = getCharArray(combinedText); // put characters of word into Arraylist
        List<Character> keyChars = getCharArray(key); // same for keys

        int secondaryCounter = 0;
        for (int i = 0; i < inputChars.size(); i++) {
            char inputChar = inputChars.get(i);
            if (secondaryCounter == keyChars.size()) { // line up the key with input
                secondaryCounter = 0;
            }
            char keyChar = keyChars.get(secondaryCounter);
            secondaryCounter++;

            int alphabetLength = 26;
            int newPos = state == State.ENCRYPT ? (int) inputChar + (int) keyChar : (int) inputChar - (int) keyChar;
            sb.append((char) (((newPos + alphabetLength) % alphabetLength) + A_ASCII_POS));
        }

        holder = sb.toString();
        return holder;
    }

    public List<Character> getCharArray(String string) {
        List<Character> characterList = new ArrayList<>();

        for (char c : string.toCharArray()) {
            characterList.add(c);
        }

        return characterList;
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
