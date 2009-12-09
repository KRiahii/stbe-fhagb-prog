package Vorlesung;

public class _2_BinaryRepresentation {
    public static void main(String[] args) {
        int i = -1;  
        System.out.println("binärer Wert von i: " + Integer.toBinaryString(i));
        float f = -1;
        System.out.println("binärer Wert von f: " + 
                           Integer.toBinaryString(Float.floatToIntBits(f)));
    }
}