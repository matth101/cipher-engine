package ciphers;

// The Affine cipher uses an alphabet of size m with keys a and b 
// such that a,b are integers, and a and m are coprime 
// E(x)=(ax+b) mod m.
// D(x)=a^(−1)*(x−b)mod m
public class Affine implements Cipher {

    private String text;
    private State state;
    private int a, b, m;

    private StringBuilder sb;

    public Affine(String text, int a, int b, int m, String mode) {
        this.text = text.toUpperCase();
        this.a = a;
        this.b = b;
        this.m = m;

        sb = new StringBuilder();

        if (mode.equals("encrypt")) state = State.ENCRYPT;
        else if (mode.equals("decrypt")) state = State.DECRYPT;
    }

    @Override
    public String process() {
        if (state == State.ENCRYPT) return encrypt();
        else return decrypt();
    }

    @Override
    public String encrypt() {
        for (int i = 0; i < text.length(); i++) {
            char curr = text.charAt(i);
            if (curr != ' ') {
                sb.append((char) ((a*(curr - A_ASCII_POS) + b) % m) + A_ASCII_POS);
            }
            else {
                sb.append(' ');
            }      
        }
        return sb.toString();
    }

    @Override
    public String decrypt() {
        int inverse = 0;
        for (int i = 0; i < m; i++) {
            if ((a*i) % 26 == 1) { // find t, the multiplicative inverse
                inverse = i;
            }
        }

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != ' ') {
                sb.append((char) (inverse * (text.charAt(i) - A_ASCII_POS - b) % m) + 'A');
            }
            else {
                sb.append(' ');
            }
        }

        return sb.toString();
    }
}
