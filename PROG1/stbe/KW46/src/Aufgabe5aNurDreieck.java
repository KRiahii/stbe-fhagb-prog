

public class Aufgabe5aNurDreieck 
{
	public static void main(String[] args)
	{
		final int KANTENLÄNGE = 15;
		final char FÜLLZEICHEN = '+';
		
		for(int i = 0;i < (KANTENLÄNGE/2+1);i++)
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
		}
	}
}
