
public class Text {
	private Line firstline;
	private Line lastline;
	private Cursor cursor;
	
	public Cursor getCursor() {
		return cursor;
	}
	public void setCursor(Cursor cursor) {
		this.cursor = cursor;
	}
	/**
	 * f�gt eine zeile als letzte zeile vor dem dummy element lastline ein
	 * @param input
	 */
	public void AddLineAtLastLine(String input){
		Line newline = new Line(input);
		// templine als hilfsvariable einf�gen um 
		// den vorg�nger der lastline zu sichern
		Line templine = lastline.prevline;
		// nachfolger von templine wird die neue line
		templine.nextline = newline;
		//vorg�nger von der neuen line ist die templine
		newline.prevline = templine;
		// nachfolger der neuen line ist die lastline
		newline.nextline = lastline;
		// vorg�ner der lastline wird die newline
		lastline.prevline = newline;
	}
	public Text(){
		firstline = new Line("");
		//firstline.setLineText(null);
		lastline = new Line("");
		firstline.prevline = null;
		firstline.nextline = lastline;		
		lastline.prevline = firstline;
		lastline.nextline = null;
		cursor = new Cursor(0, firstline);
	}
	
	//Cursor eine Zeile nach unten bewegen
	public void moveCursorDown(){
		if (cursor.yPos.nextline != null)
		cursor.yPos = cursor.yPos.nextline;
	}
	//Cursor eine Zeile nach oben bewegen
	public void moveCursorUp(){
		if (cursor.yPos.prevline != null)
		cursor.yPos = cursor.yPos.prevline;
	}
	
	
	
	
	// R�ckgabe des gesamten Textes als String (bei gr��eren Texten evtl. beschr�nken auf eine bestimmte Zeilenzahl). 
	public String getWholeText(){
		StringBuffer wholeText = new StringBuffer();
		Line templine = firstline.nextline;
		while (templine.nextline != null){
		wholeText.append(templine.getLineText() + '\n');
		templine = templine.nextline;		
		}
		return wholeText.toString();		
	}
	
	//R�ckgabe der Zeile unter dem Cursor als String
	public String getLineAtCursorPosition(){
		return cursor.yPos.getLineText();		
	}
	//L�schen des Zeichens unter dem Cursor. 
	public void deleteCharAtCursor(){
		cursor.yPos.deleteCharAtPos(cursor.xPos);
	}

}
