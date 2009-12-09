/* Praktikum KW 44
 * Übungsblatt 3
 *
 * Aufgabe 3 (Boolsche Ausdrücke, Scannen von Eingaben)
 *
 * a) Was macht folgendes Programm? 
 * (Erklären Sie die einzelnen Zeilen und beschreiben Sie das Gesamtergebnis!) 
 *    
 * Ergänzen Sie das Programm jeweils um ein analoges "Code-Stück" für die Operatoren || , | , & , ^ . 
 *
 */
public class Aufgabe3a 
{
	public static void main(String[] args) 
	{
		 boolean op1 = false;
	     boolean op2 = false;
	 
	     //Gibt die Zeichen && und den Wert von op2 sowie dem negierten op2 aus getrennt durch |
	     System.out.println(" &&   | " + op2 + " | " + !op2);
	     //Gibt die Zeichenkette  ------|-------|------  aus
	     System.out.println("------|-------|------");
	     //Gibt den Wert von op1 sowie von den Operationen op1 && op2 und op1 && !op2 getrennt durch |
	     System.out.println(op1 + " | " + (op1 && op2) + " | " + (op1 && !op2));
	     //Negiert den Wert von op1
	     op1 = !op1;
	     //Gibt den Wert von op1 sowie von den Operationen op1 && op2 und op1 && !op2 getrennt durch |
	     System.out.println(op1 + "  | " + (op1 && op2) + " | " + (op1 && !op2));
	     /*	
	      * Das Ergebnis bildet eine Matrix die die einzelnen Fälle der && Operation zweier Wahrheitswerte
	      *  &&   | false | true
		  * ------|-------|------
		  * false | false | false
		  * true  | false | true     
	      */
	     
	     System.out.println("");
	     
	     op1 = false;
	     op2 = false;
	 
	     //Gibt die Zeichen && und den Wert von op2 sowie dem negierten op2 aus getrennt durch |
	     System.out.println(" ||   | " + op2 + " | " + !op2);
	     //Gibt die Zeichenkette  ------|-------|------  aus
	     System.out.println("------|-------|------");
	     //Gibt den Wert von op1 sowie von den Operationen op1 || op2 und op1 || !op2 getrennt durch |
	     System.out.println(op1 + " | " + (op1 || op2) + " | " + (op1 || !op2));
	     //Negiert den Wert von op1
	     op1 = !op1;
	     //Gibt den Wert von op1 sowie von den Operationen op1 || op2 und op1 || !op2 getrennt durch |
	     System.out.println(op1 + "  | " + (op1 || op2) + "  | " + (op1 || !op2));
	     /*	
	      * Das Ergebnis bildet eine Matrix die die einzelnen Fälle der || Operation zweier Wahrheitswerte
	      *  ||   | false | true
		  * ------|-------|------
		  * false | false | true
		  * true  | true  | true     
	      */
	     
	     System.out.println("");
	     
	     op1 = false;
	     op2 = false;
	 
	     //Gibt die Zeichen && und den Wert von op2 sowie dem negierten op2 aus getrennt durch |
	     System.out.println(" &    | " + op2 + " | " + !op2);
	     //Gibt die Zeichenkette  ------|-------|------  aus
	     System.out.println("------|-------|------");
	     //Gibt den Wert von op1 sowie von den Operationen op1 && op2 und op1 && !op2 getrennt durch |
	     System.out.println(op1 + " | " + (op1 & op2) + " | " + (op1 & !op2));
	     //Negiert den Wert von op1
	     op1 = !op1;
	     //Gibt den Wert von op1 sowie von den Operationen op1 && op2 und op1 && !op2 getrennt durch |
	     System.out.println(op1 + "  | " + (op1 & op2) + " | " + (op1 & !op2));
	     /*	
	      * Das Ergebnis bildet eine Matrix die die einzelnen Fälle der & Operation zweier Wahrheitswerte
	      *  &    | false | true
		  * ------|-------|------
		  * false | false | false
		  * true  | false | true     
	      */
	     
	     System.out.println("");
	     
	     op1 = false;
	     op2 = false;
	 
	     //Gibt die Zeichen && und den Wert von op2 sowie dem negierten op2 aus getrennt durch |
	     System.out.println(" |    | " + op2 + " | " + !op2);
	     //Gibt die Zeichenkette  ------|-------|------  aus
	     System.out.println("------|-------|------");
	     //Gibt den Wert von op1 sowie von den Operationen op1 | op2 und op1 | !op2 getrennt durch |
	     System.out.println(op1 + " | " + (op1 | op2) + " | " + (op1 | !op2));
	     //Negiert den Wert von op1
	     op1 = !op1;
	     //Gibt den Wert von op1 sowie von den Operationen op1 | op2 und op1 | !op2 getrennt durch |
	     System.out.println(op1 + "  | " + (op1 | op2) + "  | " + (op1 | !op2));
	     /*	
	      * Das Ergebnis bildet eine Matrix die die einzelnen Fälle der | Operation zweier Wahrheitswerte
	      *  |    | false | true
		  * ------|-------|------
		  * false | false | true
		  * true  | true  | true     
	      */
	     
	     System.out.println("");
	     
	     op1 = false;
	     op2 = false;
	 
	     //Gibt die Zeichen && und den Wert von op2 sowie dem negierten op2 aus getrennt durch |
	     System.out.println(" ^    | " + op2 + " | " + !op2);
	     //Gibt die Zeichenkette  ------|-------|------  aus
	     System.out.println("------|-------|------");
	     //Gibt den Wert von op1 sowie von den Operationen op1 ^ op2 und op1 ^ !op2 getrennt durch |
	     System.out.println(op1 + " | " + (op1 ^ op2) + " | " + (op1 ^ !op2));
	     //Negiert den Wert von op1
	     op1 = !op1;
	     //Gibt den Wert von op1 sowie von den Operationen op1 ^ op2 und op1 ^ !op2 getrennt durch |
	     System.out.println(op1 + "  | " + (op1 ^ op2) + "  | " + (op1 ^ !op2));
	     /*	
	      * Das Ergebnis bildet eine Matrix die die einzelnen Fälle der ^ Operation zweier Wahrheitswerte
	      *  ^    | false | true
		  * ------|-------|------
		  * false | false | true
		  * true  | true  | false     
	      */
	}

}
