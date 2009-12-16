
class Cursor {
	Line yPos;
	int xPos;
	
	public Cursor(Line yPos){
		this(yPos, 0);
	}
	
	public Cursor(Line yPos, int xPos){
		this.yPos = yPos; // Was tun wenn in Dummys???
		if(xPos >= 0 && xPos < yPos.getLineText().length()){
			this.xPos = xPos;
		}
		else if(xPos >= yPos.getLineText().length()) {
			this.xPos = yPos.getLineText().length() - 1;
		}
		else if(xPos < 0){
			this.xPos = 0;
		}
	}
}