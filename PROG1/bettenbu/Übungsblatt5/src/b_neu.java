
public class b_neu {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
final int SEITENLAENGE = 21;
final char FUELLZEICHEN = '+';
int zaehler = SEITENLAENGE;

for (int i = 1; i <= SEITENLAENGE+1; i++){	
	for (int k = 1; k<= (SEITENLAENGE-zaehler)/2; k++)
		System.out.print(' ');
	for (int j=1; j<= zaehler; j++){
		System.out.print(FUELLZEICHEN);
		}
	System.out.println();
	if (i < (SEITENLAENGE+1)/2)
		zaehler -= 2;
	else if (i == (SEITENLAENGE+1)/2)
		zaehler = 1;
	else zaehler += 2;
	
	
}

	}

}