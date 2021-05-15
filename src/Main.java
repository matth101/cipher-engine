import ciphers.Affine;
import ciphers.Atbash;
import ciphers.Caesar;
import ciphers.Vigenere;

import java.util.*;

public class Main {

    private Scanner sc;

    public Main() {
        sc = new Scanner(System.in);
    }

    // Options: Caesar, Atbash, Vigenere, Affine
    public static void main(String[] args) {
        // Caesar c = new Caesar(new String[] {"Caesar", "abc", "de", "2", "encrypt"});
        // System.out.println(c.process());
        new Main().run();
    }

    public void run() {
        System.out.println();
        System.out.println("\nWelcome to the Cipher Engine!");
        System.out.println("Cipher options: Caesar, Atbash, Vigenere, Affine\n");
        System.out.println("Type according to these input formats:");
        System.out.println("Caesar [text] [key number] [mode]");
        System.out.println("Atbash [text]");
        System.out.println("Vigenere [text] [key phrase] [mode]");
        System.out.println("Affine [text] [a] [b] [m] [mode]");
        System.out.println("Example: \"Caesar APCSP 9 encrypt\"\n");
        System.out.println("Type \"X\" to exit the engine!\n");     
        
        ArrayList<String> display = new ArrayList<>();

        while (true) {
            String[] input;
            do {
                try {
                    System.out.print(":: ");
                    input = sc.nextLine().split(" ");
                    if (input[0].toUpperCase().equals("X")) {
                        exit();
                    }

                    String mode = input[input.length-1].toUpperCase();                    
                    boolean reprompt = false;
                    if (!(mode.equals("ENCRYPT") || mode.equals("DECRYPT"))) {
                        reprompt = true;
                    }

                    if (reprompt) {
                        System.out.println("Invalid input, please use according to the description above.\n");
                        continue;
                    }
                    else {
                        break;
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input, please use according to the description above.\n");
                }
            } while (true);

            if (input[0].equals("X")) {
                System.out.println("Exiting Cipher Engine...");
                break;
            }
            
            if (input[0].toUpperCase().equals("CAESAR") && Integer.parseInt(input[input.length-2]) < 0) {
                System.out.println("Error: key cannot be negative.\n");
                continue;
            }
            chooseCipher(input, display); // input = {"Caesar", "Computer", "7,", "encrypt"}
          
            System.out.println();
            printList(display);
        }
        sc.close();
    }

    private void chooseCipher(String[] input, ArrayList<String> display) {
        String output = "";
        switch (input[0].toUpperCase()) {
            case "CAESAR":
                output = new Caesar(input).process();
                System.out.println(output);
                display.add("CAESAR: " + output);
                break;
            case "ATBASH":
                output = new Atbash(input[1]).process();
                System.out.println(output);
                display.add("ATBASH: " + output);
                break;
            case "VIGENERE":
                output = new Vigenere(input).process();
                System.out.println(output);
                display.add("VIGENERE: " + output);
                break;
            case "AFFINE":
                output = new Affine(input).process();
                System.out.println(output);
                display.add("AFFINE: " + output);
                break;
        }  
    }

    private void printList(ArrayList<String> list) {
        System.out.print("[");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            if (i != list.size()-1) {
                System.out.print(", ");
            }
        }
        System.out.print("]\n");
    }

    private void exit() {
        System.out.println("Exiting Cipher Engine...");
        System.exit(1);
    }
}
