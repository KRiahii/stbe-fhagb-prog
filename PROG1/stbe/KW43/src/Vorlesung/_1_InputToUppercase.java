package Vorlesung;

/** reads one char from standard in,
 * checks if it is of type lower case letter,
 * if yes converts to upper case letter.
 */
public class _1_InputToUppercase  {
   public static void main(String[] args) throws Exception {
       
       int i;
       
       // read code of one character from standard in
       i = System.in.read(); // value is in the range 0..255
       
       if (! (i>='a' && i<='z'))  {
           System.out.println("No lowercase character, nothing to do!");
           return; // exit main()
       }     
       
       i = i - 'a' + 'A'; // translation
       
       char c = (char) i; // return to char type
       
       System.out.println("uppercase: " + c);          
   }
}


