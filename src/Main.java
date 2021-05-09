import ciphers.Atbash;
import ciphers.Caesar;
import ciphers.Vigenere;

public class Main {

    // Available: Caesar, Atbash, Vigenere
    public static void main(String[] args) {
        Caesar caesar = new Caesar("CQNHANVRWMVNRWNNMCXBUNNYNJAURNAJWMCQNHANYANBNWCYNJLNODUWNBBCQJCRJVJKUNCXNWSXHORWJUUHRJVJKRAMLQRAYLQRAY", 17, "decrypt");
        System.out.println("Caesar test: " + caesar.process());
        Atbash atbash = new Atbash("zmhdvi");
//        System.out.println("Atbash test: " + atbash.process());

        Vigenere vigenere = new Vigenere("JMMGIXMGDOPKFUSBWXCXAZMRROMGHTMDZWOMYUUSBUBFHOVAMZXFWM", "CZOMM", "encrypt");
        System.out.println("Vigenere test: " + vigenere.process());

    }
}
