package Vorlesung;

public class _5_CharLiterals {
    public static void main(String[] args) {
        char a = 'a';      // the obvious way
        char b = 98;       // 98 is the ordinal number of 'b'
        char c = '\n';     // escape sequence for new line
        char d = '\u0064'; // unicode escape sequence       
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
    }
}
