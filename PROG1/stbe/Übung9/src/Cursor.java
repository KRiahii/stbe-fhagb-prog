
class Cursor {
	LinkListElement yPos;
	int xPos;
	
	/**
	 * Konstruktor erstellt den Cursor, Zeile übergeben
	 * @param yPos
	 */
	public Cursor(LinkListElement yPos){
		this(yPos, 0);
	}
	
	/**
	 * Konstrukt erstellt den Cursor, Zeile und Zeichen übergeben
	 * @param yPos Zeile in der der Cursor sich befinden soll
	 * @param xPos Position in der Zeile
	 */
	public Cursor(LinkListElement yPos, int xPos){
		this.yPos = yPos; // Was tun wenn in Dummys???
		if(xPos >= 0 && xPos < yPos.data.getLineText().length()){
			this.xPos = xPos;
		}
		else if(xPos >= yPos.data.getLineText().length()) {
			this.xPos = yPos.data.getLineText().length() - 1;
		}
		else if(xPos < 0){
			this.xPos = 0;
		}
	}
}