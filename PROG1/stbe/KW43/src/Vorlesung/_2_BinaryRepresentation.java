package Vorlesung;

public class _2_BinaryRepresentation {
    public static void main(String[] args) {
        int i = -1;  
        System.out.println("bin�rer Wert von i: " + Integer.toBinaryString(i));
        float f = -1;
        System.out.println("bin�rer Wert von f: " + 
                           Integer.toBinaryString(Float.floatToIntBits(f)));
    }
}