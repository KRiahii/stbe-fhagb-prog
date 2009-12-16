
class Line {
	Line prevLine;
	Line nextLine;
	private String lineText;

	public Line(){}
	
	public Line(String lineText){
		this.lineText = lineText;
	}
	
	public Line(String lineText, Line nextLine, Line prevLine){
		this(lineText);
		this.nextLine = nextLine;
		this.prevLine = prevLine;	
	}
	
	public String getLineText() {
		return lineText;
	}

	public void setLineText(String lineText) {
		this.lineText = lineText;
	}	
}
