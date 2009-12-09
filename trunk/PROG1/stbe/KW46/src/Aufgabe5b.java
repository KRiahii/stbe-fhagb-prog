

public class Aufgabe5b {
	public static void main(String[] args) throws java.io.IOException 
	{
		System.out.println("Geben sie ein Unicode-Zeichen in der Unicode-Notation \\uxxxx ein!");
 
		//Einhabe von \\u
		char bslash = (char) System.in.read();

		if (bslash != '\\') {
			System.out.println("Eingabe ungültig oder zu kurz! Erstes Zeichen muss ein \\ sein!");
			System.exit(0);
		}

		char charu = (char) System.in.read();

		if (charu != 'u') {
			System.out.println("Eingabe ungültig oder zu kurz! Zweites Zeichen muss ein u sein!");
			System.exit(0);
		}

		//Eingabe der 4 Hexstellen
		char[] hex = new char[4];
		for(int i = 0; i < hex.length; i++)
		{
			hex[i] = (char) System.in.read();

			if (!(hex[i] >= '0' && hex[i] <= '9') 
			 && !(hex[i] >= 'a' && hex[i] <= 'f')
			 && !(hex[i] >= 'A' && hex[i] <= 'F')) 
			{
				System.out.println("Eingabe ungültig oder zu kurz! Zeichen 3-6 müssen 0-9, a-f oder A-F entsprechen!");
				System.exit(0);
			}

		}

		//Überprüfung ob Eingabe länger
		char last = (char) System.in.read();

		if (!(last == '\n' || last == '\r')) {
			System.out
					.println("Eingabe ungültig! Mehr als sechs Zeichen sind nicht zulässig!");
			System.exit(0);
		}

		//Umrechnung Hex -> Dez
		int unicodeAsInt = 0;
		
		for(int i = 0; i < hex.length;i++)
		{
			if ((hex[i] >= '0' && hex[i] <= '9')) 
			{
				unicodeAsInt += (hex[i] - '0') * Math.pow(16, i);
			} 
			else if (hex[i] >= 'a' && hex[i] <= 'f')
			{
				unicodeAsInt += (hex[i] - 'a' + 10) * Math.pow(16, i);
			}
			else
			{
				unicodeAsInt += (hex[i] - 'A' + 10) * Math.pow(16, i);
			}
		}

		char unichar = (char) unicodeAsInt;

		//Ausgabe von Eingabe, Dezimalzahl und Unicode-Zeichen
		System.out.print("Eingabe : " + bslash + charu);
		for(int i = 0; i < hex.length;i++)
		{
			System.out.print(hex[i]);
		}
		System.out.println();
		System.out.println("Unicodezahl als Int: " + unicodeAsInt);
		System.out.println("Unicodezeichen: " + unichar);
	}

}
