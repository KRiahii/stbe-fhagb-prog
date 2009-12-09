import java.io.IOException;
/* Praktikum KW 44
 * Übungsblatt 3
 *
 * Aufgabe 3 (Boolsche Ausdrücke, Scannen von Eingaben)
 *
 * c)   Wir wenden uns noch einmal der Unicode-Ersatzdarstellung zu.
 *		In Aufgabe 2 haben wir die Umwandlung der Ersatzdarstellung in das zugehörige Unicodezeichen dem ? (wem denn?) überlassen. Das wollen wir nun selbst in die Hand nehmen, indem die Ersatzdarstellung für ein Unicode-Zeichen von der Standardeingabe eingelesen und verarbeitet wird.
 *
 *				* Schreiben Sie zunächst ein Programm, das Zeichen für Zeichen von der Standardeingabe liest und prüft, ob die Eingabe von der Form \\uxxxx ist, wobei x jeweils eine der bekannten Hex-Ziffern  (0..9,a..f) sein soll (Großbuchstaben brauchen nicht unbedingt berücksichtigt werden).
 *
 *					Falls diese Syntax bei der Eingabe nicht eingehalten wird, soll eine qualifizierte Fehlermeldung ausgegeben und das Programm beendet werden.
 * 					Als falsche Eingabe gilt auch, wenn diese zu kurz oder zu lang ist.
 * 					
 *				* Erweitern Sie das Programm nun so, dass die eingegebene Ersatzdarstellung in den zugehörigen Zahlwert (int) des Unicode-Zeichens umgewandelt wird. Dazu definieren Sie sich verschiedene Variablen für die Stellen der Hex-Ziffern, rechnen diese ins Dezimalsystem um und fügen diese zu einem Zahlwert zusammen.
 *
 *					Geben Sie diesen Zahlwert und das Unicode-Zeichen selbst auf die Standardausgabe aus.
 *
 *		Auch bei dieser Aufgabe soll (noch) auf Schleifen verzichtet werden, wenn nötig unter Inkaufnahme von Code-Duplikation. Außer System.in.read() und System.out.println()sollen keine Bibliotheksfunktionen verwendet werden.  
 */
public class Aufgabe3c {
	public static void main(String[] args) throws IOException {
		System.out.println("Geben sie ein Unicode-Zeichen in der Unicode-Notation \\uxxxx ein!");
		
		char bslash = (char)System.in.read();
		
		if(bslash != '\\')
		{
			System.out.println("Eingabe ungültig oder zu kurz! Erstes Zeichen muss ein \\ sein!");
			System.exit(0);
		}
		
		char charu = (char)System.in.read();
		
		if(charu != 'u')
		{
			System.out.println("Eingabe ungültig oder zu kurz! Zweites Zeichen muss ein u sein!");
			System.exit(0);
		}
		
		char hex1 = (char)System.in.read();
		
		if(!(hex1 >= '0' && hex1 <= '9')
		 &&!(hex1 >= 'a' && hex1 <= 'f'))
		{
			System.out.println("Eingabe ungültig oder zu kurz! Drittes Zeichen muss 0-9 oder a-f entsprechen!");
			System.exit(0);
		}
		
		char hex2 = (char)System.in.read();
		
		if(!(hex2 >= '0' && hex2 <= '9')
		 &&!(hex2 >= 'a' && hex2 <= 'f'))
		{
			System.out.println("Eingabe ungültig oder zu kurz! Viertes Zeichen muss 0-9 oder a-f entsprechen!");
			System.exit(0);
		}
		
		char hex3 = (char)System.in.read();
		
		if(!(hex3 >= '0' && hex3 <= '9')
		 &&!(hex3 >= 'a' && hex3 <= 'f'))
		{
			System.out.println("Eingabe ungültig oder zu kurz! Fünftes Zeichen muss 0-9 oder a-f entsprechen!");
			System.exit(0);
		}
		
		char hex4 = (char)System.in.read();
		
		if(!(hex4 >= '0' && hex4 <= '9')
		 &&!(hex4 >= 'a' && hex4 <= 'f'))
		{
			System.out.println("Eingabe ungültig oder zu kurz! Sechstes Zeichen muss 0-9 oder a-f entsprechen!");
			System.exit(0);
		}
		
		char last = (char)System.in.read();
		
		if(!(last == '\n' || last == '\r'))
		{
			System.out.println("Eingabe ungültig! Mehr als sechs Zeichen sind nicht zulässig!");
			System.exit(0);
		}
		
		/* Umwandlung einer 4-stelligen Hex-Zahl in Dezimal
		 * 
		 * Die Zeichen 0 - 9 entsprechen in ASCII 30 - 39 Hex bzw 48 - 57 Dez
		 * Die Zeichen a - f entsprechen in ASCII 61 - 66 Hex bzw 97 - 102 Dez
		 * Umwandlung des Zeichen in die jeweilige Zahl ohne Bibliotheksfunktionen
		 * 
		 * Zeichen '5' umgewandelt in eine Integer ergibt die Zahl 35
		 * Diese Integer - 48 ergibt das Zeichen als Zahl
		 * Analog für die Zeichen 0 - 9
		 * 
		 * Zeichen 'c' umgewandelt in eine Integer ergibt die Zahl 99
		 * Diese Integer - 87 ergibt die 12 welcher 'c' in Hex entspricht
		 * Analog für die Zeichen a - f
		 */
		
		int unicodeAsInt = 0;
		
		if((hex4 >= '0' && hex4 <= '9'))
		{
			int hex4AsInt = (int)hex4;
			unicodeAsInt += (hex4AsInt - 48) * 1;
		}
		else
		{
			int hex4AsInt = (int)hex4;
			unicodeAsInt += (hex4AsInt - 87) * 1;	
		}	
		
		if((hex3 >= '0' && hex3 <= '9'))
		{
			int hex3AsInt = (int)hex3;
			unicodeAsInt += (hex3AsInt - 48) * 16;
		}
		else
		{
			int hex3AsInt = (int)hex3;
			unicodeAsInt += (hex3AsInt - 87) * 16;	
		}
		
		if((hex2 >= '0' && hex2 <= '9'))
		{
			int hex2AsInt = (int)hex2;
			unicodeAsInt += (hex2AsInt - 48) * 256;
		}
		else
		{
			int hex2AsInt = (int)hex2;
			unicodeAsInt += (hex2AsInt - 87) * 256;	
		}
		
		if((hex1 >= '0' && hex1 <= '9'))
		{
			int hex1AsInt = (int)hex1;
			unicodeAsInt += (hex1AsInt - 48) * 4096;
		}
		else
		{
			int hex1AsInt = (int)hex1;
			unicodeAsInt += (hex1AsInt - 87) * 4096;	
		}
		
		char unichar = (char) unicodeAsInt;
		
		System.out.println("Eingabe: " + bslash + charu + hex1 + hex2 + hex3 + hex4);
		System.out.println("Unicodezahl als Int: " + unicodeAsInt);
		System.out.println("Unicodezeichen: " + unichar);
	}
}