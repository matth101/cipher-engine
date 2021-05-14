package ciphers;

// Cipher where alphabet essentially becomes a mirror 
// (A corresponds to Z, B corresponds to Y, C corresponds to X, etc.).
public class Atbash implements Cipher {

    private String text;
    private StringBuilder sb;

    public Atbash(String text) {
        this.text = text.toUpperCase();

        sb = new StringBuilder(text.length());
    }

    public String process() { // implementation is the same, won't split into decrypt() and encrypt()
        String holder = "";

        for (int i = 0; i < text.length(); i++) {
            int letterPos = text.charAt(i);
            int newPos = (Z_ASCII_POS - letterPos) + A_ASCII_POS; // shift back up to ASCII

            sb.append((char) newPos);
        }

        holder = sb.toString();
        return holder;
    }

    public String getText() { return text; }
    public void setText(String text) { this.text = text; }

}
