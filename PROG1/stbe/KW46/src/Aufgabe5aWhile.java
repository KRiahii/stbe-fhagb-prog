

public class Aufgabe5aWhile {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final int KANTENLÄNGE = 16;
		final char FÜLLZEICHEN = '+';

		int i = 0;
		boolean up = true;

		while ( (i < (KANTENLÄNGE/2 + 1) && up) || (i >= 0	&& !up) )
		{
			for (int j = 0; j < i; j++) 
			{
				System.out.print(" ");
			}
			for (int j = i; j < KANTENLÄNGE - i; j++) 
			{
				System.out.print(FÜLLZEICHEN);
			}
			
			System.out.println();
			
			if(i < (KANTENLÄNGE / 2) && up)
			{
				i++;
			}
			else if(up)
			{
					up = false;
					i--;
			}
			else
			{
					i--;
			}
		}
	}
}
