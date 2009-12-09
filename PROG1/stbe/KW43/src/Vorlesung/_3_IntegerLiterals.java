package Vorlesung;

public class _3_IntegerLiterals {
    public static void main(String[] args) {
        int i;
        i = 12;  // decimal literal
        i = 012; // octal literal
        i = 0x12;// hex literal
        System.out.println("dezimaler Wert: " + i);
        System.out.println("hexadezimaler Wert: " + Integer.toHexString(i));
        System.out.println("oktaler Wert: " + Integer.toOctalString(i));
        System.out.println("binärer Wert: " + Integer.toBinaryString(i));
    }
}
