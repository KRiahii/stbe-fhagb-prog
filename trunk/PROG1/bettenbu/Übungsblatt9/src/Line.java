
public class Line {
	public Line nextline;	
	public Line prevline;
	private String lineText;

	
	
	public Line(String input){
		lineText = input;
	}




	public String getLineText() {
		return lineText;
	}




	public void setLineText(String lineText) {
		this.lineText = lineText;
	}

}
