
public class Line {
	public Line nextline;	
	public Line prevline;
	// gleich einen stringbuffer erstellen, dann wirds für alle methoden leichter
	private StringBuffer lineText;

	
	
	public Line(String input){
		lineText = new StringBuffer(input);
	}




	public String getLineText() {
		return lineText.toString();
	}




	public void setLineText(String input) {
		lineText = new StringBuffer(input);
	}
	
	//Zeichen an bestimmter Position löschen, aufgerufen durch Text Klasse
	public void deleteCharAtPos(int x){
		lineText.deleteCharAt(x);		
	}


	//Ersetzen des Zeichens unter dem Cursor durch ein neues Zeichen (spezifiziert als Übergabeparameter). 
	public void replaceCharAtPos(int x, char y){
		lineText.setCharAt(x, y);
	}
	//Einfügen eines Zeichens (Übergabeparameter) bzw. einer Zeichenfolge an der aktuellen Cursor-Position. 
	public void insertStringAtPos(int x, String insertString){
		lineText.insert(x, insertString);
	}
	
	
}
