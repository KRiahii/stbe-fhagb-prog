
public class Text {
	public Line firstLine;
	public Line lastLine;
	private Cursor cursor;
	
	public Text(){
		this.firstLine = new Line("", null, null);
		this.lastLine = new Line("", null, this.firstLine);
		this.firstLine.nextLine = this.lastLine;
		this.cursor = new Cursor(firstLine);
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
	
	public String getWholeText(){
		StringBuffer wholeText = new StringBuffer();
		Line aktLine = firstLine.nextLine;
		
		while(aktLine.nextLine != null){
			wholeText.append(aktLine.getLineText() + "\n");
			
			aktLine = aktLine.nextLine;
		}
		
		return wholeText.toString();
	}
	
	public static void main(String args[]){
		Text myText = new Text();
		
		myText.addLine("Test");
		myText.addLine("Test2");
		myText.addLine("Test3");
		myText.addLine("Test4");
		
		String text = myText.getWholeText();
		
		System.out.println(text);
	}
}
