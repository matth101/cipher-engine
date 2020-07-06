import ciphers.Caesar;

public class Main {

    public static void main(String[] args) {
        Caesar caesar = new Caesar("Matthew", 3, "decrypt");
        System.out.println(caesar.process());
    }

}
