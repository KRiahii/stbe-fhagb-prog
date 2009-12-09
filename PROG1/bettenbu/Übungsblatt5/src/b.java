
public class b {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		final char zeichen = '+';
		int ende = 5;
		
		for (int i = 1; i <= 6; i++){
			if (i >= 2 & i <= 3) ende = ende-2;
			else if (i >= 5) ende = ende+2;
			for (int k = 1; k <= (5-ende)/2; k++ )
				System.out.print((char)32); 			
			for (int j = 1; j <= ende; j++)
				System.out.print(zeichen);
			System.out.print('\r');
			
		
		}
		
	}

}
