import java.util.concurrent.CountDownLatch;


public class Text {
	public Line firstLine;
	public Line lastLine;
	private Cursor cursor;
	
	public Cursor getCursor() {
		return cursor;
	}
	
	public Text(){
		this.firstLine = new Line("", null, null);
		this.lastLine = new Line("", null, this.firstLine);
		this.firstLine.nextLine = this.lastLine;
		this.cursor = new Cursor(firstLine);
	}
	
	/**
	 * Bewegt den Cursor in eine bestimmte Zeile
	 * @param targetLine Zeile in die der Cursor bewegt wird
	 */
	public void moveCursorToLine(Line targetLine){
		if(targetLine.nextLine != null && targetLine.prevLine != null)
			cursor.yPos = targetLine;
	}
	
	/**
	 * Bewegt den Cursor zu einem Zeichen
	 * @param charInLine Positionen zu der der Cursor bewegt werden soll
	 */
	public void moveCursorToChar(int charInLine){
		if(charInLine >= 0 && charInLine < cursor.yPos.getLineText().length()){
			cursor.xPos = charInLine;
		}
		else if(charInLine >= cursor.yPos.getLineText().length()) {
			cursor.xPos = cursor.yPos.getLineText().length() - 1;
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
	}
	
	/**
	 * Cursor wird um eine Stelle nach rechts bewegt
	 */
	public void moveCursorRight(){
		if(cursor.xPos < cursor.yPos.getLineText().length() - 1)
			cursor.xPos++;
	}
	
	/**
	 * Cursor wird um eine Zeile nach oben bewegt
	 * Fals die neue Zeile kürzer ist als die alte Zeile wird der Cursor ans Ende der Zeile gesetzt
	 */
	public void moveCursorUp(){
		if(cursor.yPos.prevLine != null){
			cursor.yPos = cursor.yPos.prevLine;
			if(cursor.yPos.getLineText().length() <= cursor.xPos)
				cursor.xPos = cursor.yPos.getLineText().length() - 1;
		}
		
	}

	/**
	 * Cursor wird um eine Zeile nach unten bewegt
	 * Fals die neue Zeile kürzer ist als die alte Zeile wird der Cursor ans Ende der Zeile gesetzt
	 */
	public void moveCursorDown(){
		if(cursor.yPos.nextLine != null){
			cursor.yPos = cursor.yPos.nextLine;
			if(cursor.yPos.getLineText().length() <= cursor.xPos)
				cursor.xPos = cursor.yPos.getLineText().length() - 1;
		}
	}
	
	/**
	 * Fügt eine Zeile am Ende des Texts an
	 * @param input
	 */
	public void addLine(String input){
		Line tempLine = this.lastLine.prevLine;
		Line newLine = new Line(input,this.lastLine, tempLine);
		this.lastLine.prevLine = newLine;
		tempLine.nextLine = newLine;
	}
	
	/**
	 * Fügt eine Zeile in der Zeile nach dem Coursor an
	 * @param input
	 */
	public void addLineAtCursor(String input){
		Line tempLine = cursor.yPos.nextLine;
		Line newLine = new Line(input, tempLine, cursor.yPos);
		cursor.yPos = newLine;
		tempLine.prevLine = newLine;
	}
	
	/**
	 * Gibt den kompletten Text zurück, max 255 Zeilen
	 * @return Ein String der den kompletten Text enthält
	 */
	public String getWholeText(){
		StringBuffer wholeText = new StringBuffer(); 
		Line aktLine = firstLine.nextLine;
		int i = 1;
		
		while(aktLine.nextLine != null && i <= 255){
			wholeText.append(aktLine.getLineText() + "\n");
			
			aktLine = aktLine.nextLine;
			i++;
		}
		
		return wholeText.toString();
	}
	
	/**
	 * Gibt die Zeile in der sich der Cursor befindet zurück
	 * @return String mit dem Inhalt der Zeile
	 */
	public String getLineAtCursor(){
		if(cursor.yPos.nextLine != null && cursor.yPos.prevLine != null){
			return cursor.yPos.getLineText();
		}
		else{
			return "";
		}
	}
	
	/**
	 * Löscht das Zeichen an der Stelle an der sich der Cursor befindet
	 */
	public void deleteCharAtCursor(){
		cursor.yPos.deleteCharAtPos(cursor.xPos);
	}
	
	/**
	 * 
	 * @param args
	 */
	public void replaceCharAtCursor(char replaceChar){
		cursor.yPos.replaceCharAtPos(cursor.xPos, replaceChar);
	}
	
	public void insertAtCursor(char insertChar){
		cursor.yPos.insertAtPos(cursor.xPos, insertChar);
	}
	
	public void insertAtCursor(String insertString){
		cursor.yPos.insertAtPos(cursor.xPos, insertString);
	}
	
	public static void main(String args[]){
		Text myText = new Text();
		
		myText.addLine("Test");
		myText.addLine("Test2");
		myText.addLine("Test3");
		myText.addLine("Test4");
		
//		String text = myText.getWholeText();
//		System.out.println(text);
		
		myText.moveCursorDown();
		myText.moveCursorToChar(3);
		
		System.out.println(myText.getLineAtCursor());
		
		myText.deleteCharAtCursor();
		
		myText.moveCursorLeft();
		
		myText.replaceCharAtCursor('A');
		
		System.out.println(myText.getLineAtCursor());
	}
}
