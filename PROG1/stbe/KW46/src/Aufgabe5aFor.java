

public class Aufgabe5aFor {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final int KANTENL�NGE = 16;
		final char F�LLZEICHEN = '+';

		int inkrement = 1;
		boolean countup = true;

		for(int i = 0; i >= 0 && i < (KANTENL�NGE/2+1);i+= inkrement)
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
			
			if(i < (KANTENL�NGE / 2) && countup) 		//oberer Teil des Stundenglas
			{
				inkrement = 1;
			}
			else if(countup)	//Erste Zeile unteres Stundenglas
			{
				countup = false;
				inkrement = -1;
			}
			else										//Unterer Teil des Stundenglas
			{
				inkrement = -1;
			}
		}
	}
}
