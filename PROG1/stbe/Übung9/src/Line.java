
class Line {
	Line prevLine;
	Line nextLine;
	private StringBuffer lineText;

	public Line(){}
	
	public Line(String lineText){
		this.lineText = new StringBuffer(lineText);
	}
	
	public Line(String lineText, Line nextLine, Line prevLine){
		this(lineText);
		this.nextLine = nextLine;
		this.prevLine = prevLine;	
	}
	
	public String getLineText() {
		return lineText.toString();
	}

	public void setLineText(String lineText) {
		this.lineText = new StringBuffer(lineText);
	}
	
	/**
	 * Löscht ein Zeichen an eine bestimmten Stelle
	 * @param xPos Stelle an der das Zeichen gelöscht werden
	 */
	void deleteCharAtPos(int pos){
		lineText.deleteCharAt(pos);
	}
	
	/**
	 * Ersetzt ein Zeichen an einer Position mit einem anderen Zeichen
	 * @param pos Position des zu ersetzten Zeichen
	 * @param replaceChar Zeichen durch das ersetzt wird
	 */
	void replaceCharAtPos(int pos, char replaceChar){
		lineText.replace(pos, pos + 1, String.valueOf(replaceChar));
	}
	
	/**
	 * Fügt ein Zeichen an einer Position ein
	 * @param pos Position zum Einfügen
	 * @param insertChar Zeichen das eingefügt werden soll
	 */
	void insertAtPos(int pos, char insertChar){
		lineText.insert(pos, insertChar);
	}
	
	/**
	 * Fügt eine Zeichenkette an einer Position ein
	 * @param pos Position zum Einfügen
	 * @param insertString Zeichenkette die eingefügt werden soll
	 */
	void insertAtPos(int pos, String insertString){
		lineText.insert(pos, insertString);
	}
}
