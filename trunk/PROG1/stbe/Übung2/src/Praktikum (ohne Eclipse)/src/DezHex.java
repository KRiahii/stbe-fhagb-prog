/* Praktikum KW 43
 * Übungsblatt 2
 *
 * Aufgabe 2 (Unicode und "Grundrechenarten") 
 * 
 * "Entwickeln" Sie eine HelloWorld-Applikation
 *
 * a) Schreiben Sie ein kleines Programm, 
 *    welches jeweils in einer Zeile durch ein Leerzeichen getrennt 
 *    den dezimalen Wert, den hexadezimalen Wert und das durch diesen Hexwert 
 *    codierte Unicode-Zeichen auf dem Bildschirm ausgibt 
 *    (Escape-Sequenz für Unicode-Zeichen zur Darstellung verwenden!).
 *    Erweitern Sie diese Ausgabe durch zusätzliche Zeilen im selben Format so, 
 *    dass die "Umgebung" dieser Werte dargestellt wird. 
 *    Das heißt, Sie zählen die oben errechneten Hexwerte (im Kopf!) jeweils um 1 
 *    (und evtl. 2) hoch und runter und geben die zugehörigen Unicodezeichen aus.
 *
 */

public class DezHex 
{
	public static void main(String[] args)
	{
		//Wert 48
		System.out.println("\n //Wert 48");
		
		System.out.println("Dezimal: 48");
		System.out.println("Hex: 30");
		System.out.println("Unicode: \u0030");
		
		System.out.println(" - 1");
		
		System.out.println("Dezimal: 47");
		System.out.println("Hex: 2f");
		System.out.println("Unicode: \u002f");
		
		System.out.println(" + 1");
		
		System.out.println("Dezimal: 49");
		System.out.println("Hex: 31");
		System.out.println("Unicode: \u0031");

		//Wert 65
		System.out.println("\n //Wert 65");
		
		System.out.println("Dezimal: 65");
		System.out.println("Hex: 41");
		System.out.println("Unicode: \u0041");
		
		System.out.println(" - 1");
		
		System.out.println("Dezimal: 64");
		System.out.println("Hex: 40");
		System.out.println("Unicode: \u0040");
		
		System.out.println(" + 1");
		
		System.out.println("Dezimal: 66");
		System.out.println("Hex: 42");
		System.out.println("Unicode: \u0042");
		
		//Wert 122
		System.out.println("\n //Wert 122");
		
		System.out.println("Dezimal: 122");
		System.out.println("Hex: 7A");
		System.out.println("Unicode: \u007A");
		
		System.out.println(" - 1");
		
		System.out.println("Dezimal: 121");
		System.out.println("Hex: 79");
		System.out.println("Unicode: \u0079");
		
		System.out.println(" + 1");
		
		System.out.println("Dezimal: 123");
		System.out.println("Hex: 7B");
		System.out.println("Unicode: \u007B");
	}
}
