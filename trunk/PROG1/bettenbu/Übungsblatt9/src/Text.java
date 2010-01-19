
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
	 * fügt eine zeile als letzte zeile vor dem dummy element lastline ein
	 * @param input
	 */
	public void AddLineAtLastLine(String input){
		Line newline = new Line(input);
		// templine als hilfsvariable einfügen um 
		// den vorgänger der lastline zu sichern
		Line templine = lastline.prevline;
		// nachfolger von templine wird die neue line
		templine.nextline = newline;
		//vorgänger von der neuen line ist die templine
		newline.prevline = templine;
		// nachfolger der neuen line ist die lastline
		newline.nextline = lastline;
		// vorgäner der lastline wird die newline
		lastline.prevline = newline;
		
		//Cursor in erste Zeile setzen, falls Vorgänger firstline ist
		if (newline.prevline == firstline)
			cursor.yPos = newline;
			
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
	
	//Cursor nach rechts bewegen
	public void moveCursorRight(){
		if (cursor.xPos < cursor.yPos.getLineText().length()-1)
			cursor.xPos += 1;
		else{
			cursor.xPos = 0;
			cursor.yPos = cursor.yPos.nextline;
		}
			
	}
	
	//Cursor nach links bewegen
	public void moveCursorLeft(){
		if (cursor.xPos > 0)
			cursor.xPos -= 1;
		else{
			cursor.xPos = cursor.yPos.prevline.getLineText().length()-1;
			cursor.yPos = cursor.yPos.prevline;
		}
	}
	
	
	// Rückgabe des gesamten Textes als String (bei größeren Texten evtl. beschränken auf eine bestimmte Zeilenzahl). 
	public String getWholeText() {
		StringBuffer wholeText = new StringBuffer();
		Line templine = firstline.nextline;
		while (templine.nextline != null) {
			wholeText.append(templine.getLineText() + '\n');
			templine = templine.nextline;
		}
		return wholeText.toString();
	}

	//Rückgabe der Zeile unter dem Cursor als String
	public String getLineAtCursorPosition(){
		return cursor.yPos.getLineText();		
	}
	//Löschen des Zeichens unter dem Cursor. 
	public void deleteCharAtCursor(){
		cursor.yPos.deleteCharAtPos(cursor.xPos);
	}
	
	//Ersetzen des Zeichens unter dem Cursor durch ein neues Zeichen (spezifiziert als Übergabeparameter). 
	public void replaceCharAtCursor(char newChar){
		cursor.yPos.replaceCharAtPos(cursor.xPos, newChar);
	}

	//Einfügen eines Zeichens (Übergabeparameter) bzw. einer Zeichenfolge an der aktuellen Cursor-Position. 
	public void insertStringAtCursor(String insertString){
		cursor.yPos.insertStringAtPos(cursor.xPos, insertString);
	}
	
	//Erfragen der Zeilennummer, bzw. der exakten Position des Cursors. 
	// Zeilennummer
	public int returnCursorYpos(){
		int i = 1;
		Line templine = new Line("");
		templine = firstline.nextline;
		while(templine != cursor.yPos){
			i++;
			templine = templine.nextline;
		}		
		return i;
	}
	//Erfragen der Zeilennummer, bzw. der exakten Position des Cursors. 
	// xPos
	public int returnCursorXpos(){
		return cursor.xPos;
	}
	
	
	//Löschen der gesamten Zeile unter dem Cursor.
	public void deleteLineAtCursour(){
		//cursor ypos sichern in templine
		Line templine = new Line("");
		templine = cursor.yPos;
		//cursor auf zeile nach der gelöschten setzen
		cursor.yPos = cursor.yPos.nextline;
		//vorgänger setzen
		cursor.yPos.prevline = templine.prevline;
		//nachfolger setzen
		templine.prevline.nextline = cursor.yPos;
		
	}
	
	//Einfügen einer neuen Zeile (mit spezifiziertem Inhalt) vor dem Cursor. 
	public void insertLineInFrontOfCursor(String insertString){
		Line insertLine = new Line(insertString);
		//Vorgänger des Cursors adressieren, dessen nextline auf insertline setzen
		cursor.yPos.prevline.nextline = insertLine;
		// Vorgänger der insertLine = Vorgänger des Cursors setzen 
		insertLine.prevline = cursor.yPos.prevline;
		// Vorgänger des Cursors = insertLine
		cursor.yPos.prevline = insertLine;
		insertLine.nextline = cursor.yPos;		
	}
	//Erfragen der Länge der Zeile, auf der der Cursor steht (Zahl der Zeichen!). 
	public int getLengthOfLineAtCursor(){
		return cursor.yPos.getLineText().length();		
	}
	//Erfragen der Länge des gesamten Texts
	public int getLengthOfWholeText(){
		Line templine = new Line("");
		templine = firstline.nextline;
		int length = 0;
		while (templine.nextline != null){
			length += templine.getLineText().length();
			templine = templine.nextline;
		}
		return length;
	}
}
