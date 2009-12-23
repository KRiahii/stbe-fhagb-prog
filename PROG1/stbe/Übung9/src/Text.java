
public class Text {
	public LinkListElement firstLine;
	public LinkListElement lastLine;
	private Cursor cursor;

	/**
	 * Standardkonstruktor für Test
	 * Erstellt ein Dummyobjekt für Start und Ende
	 * Erstellt einen Cursor am Anfang des Textes
	 */
	public Text(){
		this.firstLine = new LinkListElement("", null, null);
		this.lastLine = new LinkListElement("", null, this.firstLine);
		this.firstLine.next = this.lastLine;
		this.cursor = new Cursor(firstLine);
	}
	
	/**
	 * Bewegt den Cursor in eine bestimmte Zeile
	 * @param targetLine Zeile in die der Cursor bewegt wird
	 */
	public void moveCursorToLine(LinkListElement targetLine){
		if(targetLine.next != null && targetLine.prev != null)
			cursor.yPos = targetLine;
	}
	
	/**
	 * Bewegt den Cursor zu einem Zeichen
	 * @param charInLine Positionen zu der der Cursor bewegt werden soll
	 */
	public void moveCursorToChar(int charInLine){
		if(charInLine >= 0 && charInLine < cursor.yPos.data.getLineText().length()){
			cursor.xPos = charInLine;
		}
		else if(charInLine >= cursor.yPos.data.getLineText().length()) {
			cursor.xPos = cursor.yPos.data.getLineText().length() - 1;
		}
		else if(charInLine < 0){
			cursor.xPos = 0;
		}
	}
	
	/**
	 * Cursor wird um eine Stelle nach links bewegt
	 */
	public void moveCursorLeft(){
		if(cursor.xPos > 0)
			cursor.xPos--;
		else if(cursor.xPos == 0 && cursor.yPos.prev != null){
			cursor.yPos = cursor.yPos.prev;
			cursor.xPos = cursor.yPos.data.getLineText().length() - 1;
		}
	}
	
	/**
	 * Cursor wird um eine Stelle nach rechts bewegt
	 */
	public void moveCursorRight(){
		if(cursor.xPos < cursor.yPos.data.getLineText().length() - 1)
			cursor.xPos++;
		else if(cursor.xPos == cursor.yPos.data.getLineText().length()-1 && cursor.yPos.next != null){
			cursor.yPos = cursor.yPos.next;
			cursor.xPos = 0;
		}
	}
	
	/**
	 * Cursor wird um eine Zeile nach oben bewegt
	 * Fals die neue Zeile kürzer ist als die alte Zeile wird der Cursor ans Ende der Zeile gesetzt
	 */
	public void moveCursorUp(){
		if(cursor.yPos.prev != null){
			cursor.yPos = cursor.yPos.prev;
			if(cursor.yPos.data.getLineText().length() <= cursor.xPos)
				cursor.xPos = cursor.yPos.data.getLineText().length() - 1;
		}
		
	}

	/**
	 * Cursor wird um eine Zeile nach unten bewegt
	 * Fals die neue Zeile kürzer ist als die alte Zeile wird der Cursor ans Ende der Zeile gesetzt
	 */
	public void moveCursorDown(){
		if(cursor.yPos.next != null){
			cursor.yPos = cursor.yPos.next;
			if(cursor.yPos.data.getLineText().length() <= cursor.xPos)
				cursor.xPos = cursor.yPos.data.getLineText().length() - 1;
		}
	}
	
	/**
	 * Fügt eine Zeile am Ende des Texts an
	 * @param input
	 */
	public void addLine(String input){
		LinkListElement tempLine = this.lastLine.prev;
		LinkListElement newLine = new LinkListElement(input,this.lastLine, tempLine);
		this.lastLine.prev = newLine;
		tempLine.next = newLine;
		if(cursor.yPos.prev == null){
			moveCursorDown();
		}
	}
	
	/**
	 * Gibt den kompletten Text zurück, max 255 Zeilen
	 * @return Ein String der den kompletten Text enthält
	 */
	public String getWholeText(){
		StringBuffer wholeText = new StringBuffer(); 
		LinkListElement aktLine = firstLine.next;
		int i = 1;
		
		while(aktLine.next != null && i <= 255){
			wholeText.append(aktLine.data.getLineText() + "\n");
			
			aktLine = aktLine.next;
			i++;
		}
		
		return wholeText.toString();
	}
	
	/**
	 * Gibt die Zeile in der sich der Cursor befindet zurück
	 * @return String mit dem Inhalt der Zeile
	 */
	public String getLineAtCursor(){
		if(cursor.yPos.next != null && cursor.yPos.prev != null){
			return cursor.yPos.data.getLineText();
		}
		else{
			return "";
		}
	}
	
	/**
	 * Löscht das Zeichen an der Stelle an der sich der Cursor befindet
	 */
	public void deleteCharAtCursor(){
		cursor.yPos.data.deleteCharAtPos(cursor.xPos);
	}
	
	/**
	 * Ersetzt ein Zeichen am Cursor durch ein anderes Zeichen
	 * @param replaceChar Zeichen durch das ersetzt wird
	 */
	public void replaceCharAtCursor(char replaceChar){
		cursor.yPos.data.replaceCharAtPos(cursor.xPos, replaceChar);
	}
	
	/**
	 * Fügt ein Zeichen an Stelle des Cursor ein
	 * @param insertChar Einzufügendes Zeichen
	 */
	public void insertAtCursor(char insertChar){
		cursor.yPos.data.insertAtPos(cursor.xPos, insertChar);
	}
	
	/**
	 * Fügt eine Zeichenkette an Stelle des Cursors ein
	 * @param insertString Zeichenkette die eingesetzt werden soll  
	 */
	public void insertAtCursor(String insertString){
		cursor.yPos.data.insertAtPos(cursor.xPos, insertString);
	}
	
	/**
	 * Ermittelt die Zeile in der Cursor sich befindet
	 * @return Zeilennummer in der sich der Cursor befindet
	 */
	public int getCursorLine(){
		int counter = 1;
		LinkListElement aktElement = firstLine.next;
		while(aktElement != cursor.yPos){
			aktElement = aktElement.next;
			counter++;
		}
		
		return counter;
	}
	
	/**
	 * Gibt das Zeichen an dem sich der Cursor sich befindet zurück
	 * @return Nummer des Zeichens an dem sich der Cursor befindet
	 */
	public int getCursorXPos(){
		return cursor.xPos;
	}
	
	/**
	 * Löscht die Zeile an Stelle des Cursors
	 * Bewegt den Cursor eine Zeile nach oben
	 */
	public void deleteLineAtCursor(){
		LinkListElement tempElement = cursor.yPos;
		this.cursor.yPos = this.cursor.yPos.prev;
		this.cursor.xPos = 0;
		this.cursor.yPos.next = tempElement.next;
		tempElement.next.prev = cursor.yPos;
	}
	
	/**
	 * Fügt eine Zeile in der Zeile nach dem Coursor an
	 * @param input Text für die neue Zeile
	 */
	
	public void addLineAfterCursor(String input){
		LinkListElement tempLine = cursor.yPos.next;
		LinkListElement newLine = new LinkListElement(input, tempLine, cursor.yPos);
		cursor.yPos.next = newLine;
		tempLine.prev = newLine;
		if(cursor.yPos.prev == null){
			moveCursorDown();
		}
	}
	
	/**
	 * Einfügen einer neuen Zeile vor dem Cursor
	 * @param input Text für die neue Zeile
	 */
	public void addLineInFrontOfCursor(String input){
		LinkListElement tempLine = cursor.yPos.prev;
		LinkListElement newLine = new LinkListElement(input, cursor.yPos, tempLine);
		tempLine.next = newLine;
		cursor.yPos.prev = newLine;
	}
	
	/**
	 * Gibt die Anzahl der Zeichen an die die Zeile enthält in der sich der Cursor befindet
	 * @return
	 */
	public int getLineLengthAtCursor(){
		return cursor.yPos.data.getLineText().length();
	}
	
	/**
	 * Gibt die Länge des gesamten Textes zurück
	 * @return Anzahl der Zeichen die der Text enthält
	 */
	public int getWholeTextLength(){
		LinkListElement aktElement = firstLine.next;
		int length = 0;
		
		while(aktElement.next != null){
			length += aktElement.data.getLineText().length();
			aktElement = aktElement.next;
		}
		
		return length;
	}
	
//	public static void main(String args[]){
//		Text myText = new Text();
//		
//		myText.addLine("Test");
//		myText.addLine("Test2");
//		myText.addLine("Test3");
//		myText.addLine("Test4");
//		
//		String text = myText.getWholeText();
//		System.out.println(text);
//		
//		myText.moveCursorDown();
//		myText.moveCursorDown();
//		
//		System.out.println(myText.getLineAtCursor());
//		System.out.println(myText.getLineLengthAtCursor());
//		System.out.println(myText.getWholeTextLength());
//	}
}

class LinkListElement {
	LinkListElement prev;
	Line data;
	LinkListElement next;
	
	public LinkListElement(String lineText, LinkListElement next, LinkListElement prev){
		this.next = next;
		this.prev = prev;
		this.data = new Line(lineText);
	}
}