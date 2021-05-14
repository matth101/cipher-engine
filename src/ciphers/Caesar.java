package ciphers;

public class Caesar implements Cipher {

    private String text;
    private int key;

    private StringBuilder sb;

    public State state;

    public Caesar(String text, int key) {
        this.text = text.toUpperCase();
        this.key = key;
    }

    public Caesar(String[] input) {
        this(input[1], Integer.parseInt(input[2]));

        sb = new StringBuilder(text.length());

        if (input[3].toUpperCase().equals("ENCRYPT")) state = State.ENCRYPT;
        else if (input[3].toUpperCase().equals("DECRYPT")) state = State.DECRYPT;
    }

    public String process() {
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                sb.append(' ');
                continue;
            }
                
            int letterPos = text.charAt(i);
            int newPos = 0;

            if (state == State.ENCRYPT) {
                newPos = letterPos + key;
            }
            else if (state == State.DECRYPT) {
                newPos = letterPos - key; // subtract down from ASCII and shift by the key value
            }

            int alphabetLength = 26;
            if (newPos > Z_ASCII_POS && state == State.ENCRYPT) { // go around alphabet's beginning and end corners
                newPos -= alphabetLength;
            } else if (newPos < A_ASCII_POS && state == State.DECRYPT) {
                newPos += alphabetLength;
            }

            sb.append((char) newPos);
        }

        return sb.toString();
    }

    public String getText() { return text; }
    public int getKey() { return key; }
    public void setText(String text) { this.text = text; }
    public void setKey(int key) { this.key = key; }
}
