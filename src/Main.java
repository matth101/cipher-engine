import ciphers.Atbash;
import ciphers.Caesar;
import ciphers.Vigenere;

import java.util.*;

public class Main {

    // Available: Caesar, Atbash, Vigenere
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // while (true) {
        //     System.out.println("Welcome to the Cipher Engine!");
        //     System.out.println("Cipher options: Caesar, Atbash, Vigenere, Affine");


        // }



        // Caesar caesar = new Caesar("CQNHANVRWMVNRWNNMCXBUNNYNJAURNAJWMCQNHANYANBNWCYNJLNODUWNBBCQJCRJVJKUNCXNWSXHORWJUUHRJVJKRAMLQRAYLQRAY", 17, "decrypt");
        // System.out.println("Caesar test: " + caesar.process());
        // Atbash atbash = new Atbash("zmhdvi");
//        System.out.println("Atbash test: " + atbash.process());

        Vigenere vigenere = new Vigenere("SCIENCEOLYMPIADISCOOL", "SCIOLY", "encrypt");
        System.out.println("Vigenere test: " + vigenere.process());

        sc.close();
    }
}
