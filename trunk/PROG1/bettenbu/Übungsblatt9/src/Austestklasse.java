
public class Austestklasse {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Text testtext = new Text();
		testtext.AddLineAtLastLine("Hallo Welt1");
		testtext.AddLineAtLastLine("Hallo Welt2");
		testtext.AddLineAtLastLine("Hallo Welt3");
		// R�ckgabe des gesamten Textes als String (bei gr��eren Texten evtl. beschr�nken auf eine bestimmte Zeilenzahl). 
		
		//System.out.println(testtext.getWholeText());
		
		//R�ckgabe der Zeile unter dem Cursor als String
		testtext.moveCursorDown();
		testtext.moveCursorDown();
		testtext.moveCursorUp();
		System.out.println(testtext.getLineAtCursorPosition());

	}

}
