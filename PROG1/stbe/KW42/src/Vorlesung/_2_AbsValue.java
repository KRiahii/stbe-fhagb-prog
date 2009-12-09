package Vorlesung;
/** 
 * calculates the absolute value of an integer
 */
 public class _2_AbsValue {
    public static void main(String[] args) {
        int number = -3; // get value from anywhere
        
        /* replace value of number by its absolute value
           which means do nothing if it is already positive */
        if (number < 0)
            number = -number;
            
        System.out.println("The value of number is " + number); 
    }
}
