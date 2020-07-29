package ciphers;

public class Caesar implements Cipher {

    private String text;
    private int key;
    private String result;

    private StringBuilder sb;

    public State state;

    public Caesar(String text, int key) {
        this.text = text.toUpperCase();
        this.key = key;
    }

    public Caesar(String text, int key, String mode) {
        this(text, key);

        sb = new StringBuilder(text.length());

        if (mode.equals("encrypt")) state = State.ENCRYPT;
        else if (mode.equals("decrypt")) state = State.DECRYPT;
    }

    @Override
    public String process() {
        String holder = "";
        for (int i = 0; i < text.length(); i++) {
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

        holder = sb.toString();
        return holder;
    }

    public String getText() { return text; }
    public int getKey() { return key; }
    public void setText(String text) { this.text = text; }
    public void setKey(int key) { this.key = key; }
}
