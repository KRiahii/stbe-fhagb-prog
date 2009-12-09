import java.io.IOException;

/* Praktikum KW 44
 * Übungsblatt 3
 *
 * Aufgabe 3 (Boolsche Ausdrücke, Scannen von Eingaben)
 *
 * b)   Schreiben Sie nun ein kleines Programm, das einen dyadischen logischen Ausdruck mit einem der unter Teilaufg. a genannten Operatoren einliest, das Ergebnis berechnet und ausgibt. Die logischen Ausdrücke sollen textuell in einer verkürzten Form eingegeben werden können, illustriert durch nachfolgende Beispiele:
		T&F oder T|T oder F^T ...
		D. h. statt true wird der Buchstabe T, statt false der Buchstabe F in der Eingabe verwendet. (Leerzeichen zwischen Operanden und Operatoren sind aus Einfachheitsgründen verboten.)
		Verwenden Sie zum zeichenweisen Einlesen System.in.read() (zur Verwendung siehe InputToUppercase in der Vorl.).
		Falls fälschlicherweise eine verkehrte Buchstabenfolge eingegeben wird, soll eine Fehlermeldung ausgegeben und das Programm vorzeitig beendet werden.
		Das Programm braucht während eines Laufes nur einen Ausdruck zu berechnen. Es sind also keine Schleifen, auch nicht für wiederholte Eingabe, erforderlich.
		Es sind zumindest die Operatoren, die aus einem Zeichen bestehen, zu berücksichtigen (| , & , ^ ). Wer sich damit langweilt, sollte auch die Operatoren bestehend aus zwei Zeichen berücksichtigen (&&, || ). 
 */
public class Aufgabe3b {
	public static void main(String[] args) throws IOException {
		char bool1, op, bool2, returnchar;
		boolean op1 = true, op2 = true;
		
		System.out.println("Geben sie eine logische Operation der Form Operand Operator Operand ein (ohne Leerzeichen!)");
		System.out.println("Mögliche Operanden : T (für true) und F für (false)");
		System.out.println("Mögliche Operatoren: | & ^");
		

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
