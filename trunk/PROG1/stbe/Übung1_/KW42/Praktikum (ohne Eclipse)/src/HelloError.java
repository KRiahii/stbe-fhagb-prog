/* Praktikum KW 42
 * �bungsblatt 1
 *
 * Aufgabe 1 (Pr�senzaufgabe)
 *  
 * "Entwickeln" Sie eine HelloWorld-Applikation
 *
 * c) Bauen Sie absichtlich Fehler in Ihr Quellprogramm ein
 *    und beobachten Sie, wie der Compiler reagiert. 
 *
 */

public class HelloError
{
	public static void main(String[] args)
	{
		system.out.println("Hello Stefan!"); //Falsch da System klein (case-sensitive)
		System.out.println("Hello World!")   //Falsch da ; fehlt
	}
}