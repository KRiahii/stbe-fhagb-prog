/* Praktikum KW 43
 * Übungsblatt 2
 *
 * Aufgabe 2 (Unicode und "Grundrechenarten") 
 * 
 * "Entwickeln" Sie eine HelloWorld-Applikation
 *
 * b) Schreiben Sie ein kleines Programm, in dem solche Ausdrücke berechnet 
 *    und die Ergebnisse auf dem Bildschirm ausgegeben werden. Setzen Sie dabei 
 *    als Operanden sowohl ganze Zahlen als auch reelle Zahlen ein. 
 *    Verwenden Sie dafür einfach Literale (siehe Beispiele für Literale in der Vorlesung),
 *    indem Sie nachfolgende Anweisung als Vorlage benutzen und die Operanden 
 *    durchvariieren:
 *    
 *    System.out.println("4.5 + 3.8 = " + (4.5 + 3.8));
 *
 */

public class Grundrechenarten
{
	public static void main(String[] args)
	{
		//Ganze Zahlen
		System.out.println("\n //Ganze Zahlen");
		System.out.println("9 + 3 = " + (9 + 3)); // +
		System.out.println("9 - 3 = " + (9 - 3)); // -
		System.out.println("9 * 3 = " + (9 * 3)); // *
		System.out.println("9 / 3 = " + (9 / 3)); // /
		
		//Reelle Zahlen
		System.out.println("\n //Reelle Zahlen");
		System.out.println("9.5 + 3.8 = " + (9.5 + 3.8)); // +
		System.out.println("9.5 - 3.8 = " + (9.5 - 3.8)); // -
		System.out.println("9.5 * 3.8 = " + (9.5 * 3.8)); // *
		System.out.println("9.5 / 3.8 = " + (9.5 / 3.8)); // /

		//Ungerade Zahl / 2
		System.out.println("\n //Ungerade Zahl / 2 \nBeispiel 5/2:");
		int w1 = 5 / 2;
		System.out.println("Ziel int: " + w1);
		float w2 = 5.0f / 2.0f;
		System.out.println("Ziel float: " + w2);

		//lange Zieffernfolge als Literal
		System.out.println("\n //lange Zieffernfolge als Literal");
		//w1 = 23676325679876534;
		//w2 = 3.0e39f;
		System.out.println("Fehler da Wertebereich ueberschritten");

		System.out.println(Integer.MAX_VALUE + 1);
		System.out.println(Float.MAX_VALUE + 1);
		
		//Addition bzw. Multiplikation zweier großer Zahlen INT
		System.out.println("\n //Addition bzw. Multiplikation zweier großer Zahlen INT");
		int i1 = Integer.MAX_VALUE - 10;
		int i2 = Integer.MAX_VALUE - 20;
		
		System.out.println("Operanden O1 = " + i1 + " O2 = " + i2); 
		System.out.println("Addition: " + (i1 + i2));
		System.out.println("Multiplikation: " + (i1 * i2));
		
		//Addition bzw. Multiplikation zweier großer Zahlen FLOAT
		System.out.println("\n //Addition bzw. Multiplikation zweier großer Zahlen FLOAT");
		float f1 = Float.MAX_VALUE - 10;
		float f2 = Float.MAX_VALUE - 20;

		float f3 = f1 + f2;
		float f4 = f1 * f2;
		float f5 = f3 + f4;
		float f6 = f3 - f4;
		float f7 = f3 * f4;
		float f8 = f3 / f4;		

		System.out.println("Operanden O1 = " + f1 + " O2 = " + f2); 
		System.out.println("Addition: " + f3);
		System.out.println("Multiplikation: " + f4);
		System.out.println("Inf + Inf: " + f5);
		System.out.println("Inf - Inf: " + f6);
		System.out.println("Inf * Inf: " + f7);
		System.out.println("Inf / Inf: " + f8);
		
		//Division durch 0 Integer
		System.out.println("\n //Division durch 0 Integer");
		System.out.println("gerade Zahl");
		//int gerade = 6 / 0;
		System.out.println("Fehler da Division durch 0 unmöglich! Kompilerfehler");
		System.out.println("ungerade Zahl");
		//int ungerade = 3 / 0;
		System.out.println("Fehler da Division durch 0 unmöglich! Kompilerfehler");
		System.out.println("0 / 0");
		//int nulldivnull = 0 / 0;
		System.out.println("Fehler da Division durch 0 unmöglich! Interpreterfehler");

		//Division durch 0 Float
		System.out.println("\n //Division durch 0 Float");
		System.out.println("gerade Zahl");
		float fgerade = 6.0f / 0.0f;
		System.out.println("6.0 / 0.0 : " + fgerade);
		System.out.println("ungerade Zahl");
		float fungerade = 3.0f / 0.0f;
		System.out.println("3.0 / 0.0 : " + fungerade );
		System.out.println("0 / 0");
		float fnulldivnull = 0.0f / 0.0f;
		System.out.println("0.0 / 0.0 : " + fnulldivnull);
	}
}
