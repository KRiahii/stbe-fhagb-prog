
public class Line {
	public Line nextline;	
	public Line prevline;
	// gleich einen stringbuffer erstellen, dann wirds f�r alle methoden leichter
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
	
	//Zeichen an bestimmter Position l�schen, aufgerufen durch Text Klasse
	public void deleteCharAtPos(int x){
		lineText.deleteCharAt(x);		
	}

}
