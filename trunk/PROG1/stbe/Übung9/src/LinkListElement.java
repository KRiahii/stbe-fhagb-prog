class LinkListElement {
	LinkListElement prev;
	Line data;
	LinkListElement next;
	
	public LinkListElement(String lineText, LinkListElement next, LinkListElement prev){
		this.next = next;
		this.prev = prev;
		this.data = new Line(lineText);
	}
}