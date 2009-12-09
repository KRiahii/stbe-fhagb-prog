public class Aufgabe5c 
{
	public static void main(String[] args) throws Exception 
	{
        final int STATE_INITIAL = 0;
        final int STATE_SIGN = 1;
        final int STATE_DEC = 2;
        final int STATE_WRONG = 3;
        final int STATE_COMPL = 4;
        final int STATE_CLEAR = 5;
        final int STATE_HEX = 6;
        final int STATE_OKT = 7;

        int currentState = STATE_INITIAL;
        int column = 0;
        int sign = 1;
        int value = 0;

        System.out.println("enter decimal literal");
        while (true) {
            char c = (char) System.in.read();
            column++;

            // check input and make state transitions bases on the input
            switch (currentState) {
            case (STATE_INITIAL):
                // reset values
                value = 0;
                sign = 1;
                column = 1;

                if ((c == 'q') || (c == 'Q')) {
                    System.out.println("bye");
                    return;
                } else if ('1' <= c && c <= '9')
                    currentState = STATE_DEC;
                else if (c == '0') {
                    c = (char) System.in.read();
                    column++;
                    if(c == 'x')
                    	currentState = STATE_HEX;
                    else if(c == 'o')
                    	currentState = STATE_OKT;
                    else if((c == '\r') || (c == '\n'))
                    	currentState = STATE_COMPL;
                    else if('0' <= c && c <= '9')
                    	currentState = STATE_DEC;
                    else
                    	currentState = STATE_WRONG;
                } else if ((c == '+') || (c == '-'))
                    currentState = STATE_SIGN;
                else if ((c == '\r') || (c == '\n'))
                    ; // still no real input, nothing to do
                else
                    currentState = STATE_WRONG;
                break;

            case (STATE_SIGN):
                if ('0' <= c && c <= '9')
                    currentState = STATE_DEC;
                else
                    currentState = STATE_WRONG;
                break;

            case (STATE_DEC):
                if ('0' <= c && c <= '9') { // nothing to do
                } else if ((c == '\r') || (c == '\n'))
                    currentState = STATE_COMPL;
                else
                    currentState = STATE_WRONG;
                break;

            case (STATE_CLEAR):
                if ((c == '\r') || (c == '\n'))
                    currentState = STATE_INITIAL;
                break;
                 
            case (STATE_HEX) :
            	if (('0' <= c && c <= '9')
            	 || ('a' <= c && c <= 'f')
            	 || ('A' <= c && c <= 'F')) { // nothing to do
                } else if ((c == '\r') || (c == '\n'))
                    currentState = STATE_COMPL;
                else
                    currentState = STATE_WRONG;
                break;
                
            case (STATE_OKT) :
            	if ('0' <= c && c <= '7') { // nothing to do
                } else if ((c == '\r') || (c == '\n'))
                    currentState = STATE_COMPL;
                else
                    currentState = STATE_WRONG;
                break;
            default:
                System.out.println("Unknown State: " + currentState);
            }

            if (currentState == STATE_WRONG) {
                System.out.println("Fehlerhafte Eingabe an Position : " + column);
                if ((c == '\r') || (c == '\n'))
                    currentState = STATE_INITIAL;
                else
                    currentState = STATE_CLEAR;
                continue;
            }

            if (currentState == STATE_COMPL) {
                System.out.println("ermittelter int-Wert: " + value);
                currentState = STATE_INITIAL;
                continue;
            }

            // interpretation of unicode letter
            int cipherValue = 0;
            if ('0' <= c && c <= '9')
                cipherValue = c - '0';
            else if ('a' <= c && c <= 'f')
            	cipherValue = c - 'a' + 10;
            else if ('A' <= c && c <= 'F')
            	cipherValue = c - 'A' + 10;
            else if (c == '-')
                sign = -1;

            // apply Horner
            switch (currentState) {
            case (STATE_DEC):
            	// Warum die Fallunterscheidung fuer neg. bzw. pos. Vorzeichen
            	// und nicht einfach zum Schluss sign * errechneter Betrag ?
            	// Wertebereich von Int neg > pos????
            	if (sign > 0)
            	    if ((Integer.MAX_VALUE - cipherValue)/10 >= value )
                        value = value * 10 + cipherValue;
                    else {
                        System.out.println("Zahl zu gross");
                        currentState = STATE_CLEAR;
                    }
            
                if (sign < 0)
                    if ((Integer.MIN_VALUE + cipherValue)/10 <= value )
                        value = value * 10 - cipherValue;
                    else {
                        System.out.println("Zahl zu klein");
                        currentState = STATE_CLEAR;
                    }
                break;
            case (STATE_HEX):
            	if((value & 0xF0000000) == 0)
            		value = (value << 4) | cipherValue;
//        		if ((Integer.MAX_VALUE - cipherValue)/16 >= value )
//			        value = value * 16 + cipherValue;
            	else {
	                  System.out.println("Zahl zu gross");
	                  currentState = STATE_CLEAR;
	              }
            	break;
            case (STATE_OKT):
            	if((value & 0x0000000) == 0)
            		value = (value << 3) | cipherValue;
//            	if ((Integer.MAX_VALUE - cipherValue)/8 >= value )
//                    value = value * 8 + cipherValue;
                else {
                    System.out.println("Zahl zu gross");
                    currentState = STATE_CLEAR;
                }
            	break;
            }
        }
    }
}
