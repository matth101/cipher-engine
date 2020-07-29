import ciphers.Atbash;
import ciphers.Caesar;
import ciphers.Vigenere;

public class Main {

    public static void main(String[] args) {
        Caesar caesar = new Caesar("example", 3, "encrypt");
        System.out.println("Caesar test: " + caesar.process());
        Atbash atbash = new Atbash("zmhdvi");
        System.out.println("Atbash test: " + atbash.process());

        Vigenere vigenere = new Vigenere("EKKFZQGHB", "scioly", "decrypt");
        System.out.println("Vigenere test: " + vigenere.process());
    }

}
