
class Cursor {
	Line yPos;
	int xPos;
	
	public Cursor(Line yPos){
		this(yPos, 0);
	}
	
	public Cursor(Line yPos, int xPos){
		this.yPos = yPos;
		this.xPos = xPos;
	}
}