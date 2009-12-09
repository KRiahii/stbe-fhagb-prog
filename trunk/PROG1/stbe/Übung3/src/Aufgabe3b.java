import java.io.IOException;

/* Praktikum KW 44
 * �bungsblatt 3
 *
 * Aufgabe 3 (Boolsche Ausdr�cke, Scannen von Eingaben)
 *
 * b)   Schreiben Sie nun ein kleines Programm, das einen dyadischen logischen Ausdruck mit einem der unter Teilaufg. a genannten Operatoren einliest, das Ergebnis berechnet und ausgibt. Die logischen Ausdr�cke sollen textuell in einer verk�rzten Form eingegeben werden k�nnen, illustriert durch nachfolgende Beispiele:
		T&F oder T|T oder F^T ...
		D. h. statt true wird der Buchstabe T, statt false der Buchstabe F in der Eingabe verwendet. (Leerzeichen zwischen Operanden und Operatoren sind aus Einfachheitsgr�nden verboten.)
		Verwenden Sie zum zeichenweisen Einlesen System.in.read() (zur Verwendung siehe InputToUppercase in der Vorl.).
		Falls f�lschlicherweise eine verkehrte Buchstabenfolge eingegeben wird, soll eine Fehlermeldung ausgegeben und das Programm vorzeitig beendet werden.
		Das Programm braucht w�hrend eines Laufes nur einen Ausdruck zu berechnen. Es sind also keine Schleifen, auch nicht f�r wiederholte Eingabe, erforderlich.
		Es sind zumindest die Operatoren, die aus einem Zeichen bestehen, zu ber�cksichtigen (| , & , ^ ). Wer sich damit langweilt, sollte auch die Operatoren bestehend aus zwei Zeichen ber�cksichtigen (&&, || ). 
 */
public class Aufgabe3b {
	public static void main(String[] args) throws IOException {
		char bool1, op, bool2, returnchar;
		boolean op1 = true, op2 = true;
		
		System.out.println("Geben sie eine logische Operation der Form Operand Operator Operand ein (ohne Leerzeichen!)");
		System.out.println("M�gliche Operanden : T (f�r true) und F f�r (false)");
		System.out.println("M�gliche Operatoren: | & ^");
		

		bool1 =  (char) System.in.read();
		
		if(bool1 == '\n' || bool1 == '\r')
		{
			System.out.println("Eingabe zu kurz! Programm wird beendet!");
			System.exit(0);
		}
		
		op = (char) System.in.read();
		
		if(op == '\n' || op == '\r')
		{
			System.out.println("Eingabe zu kurz! Programm wird beendet!");
			System.exit(0);
		}
		
		bool2 =  (char) System.in.read();
		
		if(bool2 == '\n' || bool2 == '\r')
		{
			System.out.println("Eingabe zu kurz! Programm wird beendet!");
			System.exit(0);
		}
		
		returnchar = (char) System.in.read();
		
		if(returnchar != '\n' && returnchar != '\r')
		{
			System.out.println("Eingabe zu lang! Programm wird beendet!");
			System.exit(0);
		}
		
		if((bool1 == 'T' || bool1 == 'F') 
		&& (bool2 == 'T' || bool2 == 'F')
		&& (op == '|' || op == '&' || op == '^') )
		{
			/*if(bool1 == 'T')
				op1 = true;
			else
				op1 = false;*/
			
			op1 = bool1 == 'T';
			
			
			/*if(bool2 == 'T')
				op2 = true;
			else
				op2 = false;*/
			
			op2 = bool2 == 'T';
		}
		else
		{
			System.out.println("Eingabe war inkorrekt! Programm wird beendet!");
			System.exit(0);
		}
			
		if(op == '|')
		{
			System.out.println("Operation " + op1 + " | " + op2 + " : " + (op1 | op2));
		}
		
		if(op == '&')
		{
			System.out.println("Operation " + op1 + " & " + op2 + " : " + (op1 & op2));
		}
		
		if(op == '^')
		{
			System.out.println("Operation " + op1 + " ^ " + op2 + " : " + (op1 ^ op2));
		}
	}
}
