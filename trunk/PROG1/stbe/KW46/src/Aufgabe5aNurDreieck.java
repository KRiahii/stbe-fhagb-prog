

public class Aufgabe5aNurDreieck 
{
	public static void main(String[] args)
	{
		final int KANTENL�NGE = 15;
		final char F�LLZEICHEN = '+';
		
		for(int i = 0;i < (KANTENL�NGE/2+1);i++)
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
		}
	}
}
