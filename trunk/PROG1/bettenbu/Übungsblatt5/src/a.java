
public class a {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	final char zeichen = '+';
	int ende = 5;
	
	for (int i = 1; i <= 3; i++){
		for (int k = 1; k <= i-1; k++ )
			System.out.print((char)32); 			
		for (int j = 1; j <= ende; j++)
			System.out.print(zeichen);
		System.out.print('\r');
		ende = ende-2;
	
	}
	
	}
		
		
		
			
		
	

			

	

}
