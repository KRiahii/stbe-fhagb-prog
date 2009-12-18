
public class Austestklasse {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//testkommentar
		Text testtext = new Text();
		testtext.AddLineAtLastLine("Hallo Welt1");
		testtext.AddLineAtLastLine("Hallo Welt2");
		testtext.AddLineAtLastLine("Hallo Welt3");
		testtext.AddLineAtLastLine("Hallo Welt4");
//		testtext.AddLineAtLastLine("Hallo Welt5");
//		testtext.AddLineAtLastLine("Hallo Welt6");
		// Rückgabe des gesamten Textes als String (bei größeren Texten evtl. beschränken auf eine bestimmte Zeilenzahl). 
		
		//System.out.println(testtext.getWholeText());
		
		//Rückgabe der Zeile unter dem Cursor als String
		testtext.moveCursorDown();
		//System.out.println(testtext.getLineAtCursorPosition());
		
		//Löschen des Zeichens unter dem Cursor. 

//		Cursor nach rechts und links bewegen		
//		testtext.moveCursorRight();
//		testtext.moveCursorRight();
//		testtext.moveCursorLeft();
//		testtext.deleteCharAtCursor();
//		System.out.println(testtext.getWholeText());

	//Ersetzen des Zeichens unter dem Cursor durch ein neues Zeichen (spezifiziert als Übergabeparameter). 
		testtext.replaceCharAtCursor('ö');
		testtext.moveCursorRight();
		testtext.insertStringAtCursor("chen");
		System.out.println(testtext.getWholeText());
		testtext.moveCursorDown();
		System.out.println("Der Cursor befindet sich in Zeile: " + testtext.returnCursorYpos());
		System.out.println("Der Cursor befindet sich in Spalte: " + testtext.returnCursorXpos());
		System.out.println("Lösche dieses Zeichen jetzt");
		testtext.deleteCharAtCursor();
		System.out.println(testtext.getWholeText());
	}

}
