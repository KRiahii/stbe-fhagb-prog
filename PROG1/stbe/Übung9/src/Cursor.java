
class Cursor {
	LinkListElement yPos;
	int xPos;
	
	public Cursor(LinkListElement yPos){
		this(yPos, 0);
	}
	
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