

public class Aufgabe5aWhile {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final int KANTENL�NGE = 16;
		final char F�LLZEICHEN = '+';

		int i = 0;
		boolean up = true;

		while ( (i < (KANTENL�NGE/2 + 1) && up) || (i >= 0	&& !up) )
		{
			for (int j = 0; j < i; j++) 
			{
				System.out.print(" ");
			}
			for (int j = i; j < KANTENL�NGE - i; j++) 
			{
				System.out.print(F�LLZEICHEN);
			}
			
			System.out.println();
			
			if(i < (KANTENL�NGE / 2) && up)
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
