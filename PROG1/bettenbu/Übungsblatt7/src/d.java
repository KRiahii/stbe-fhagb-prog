
public class d {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		long start = System.currentTimeMillis();
		int to_test = 1500000;
		int[] primzahlen = new int[to_test];
		int zaehler = 0;
		for (int i = 2; i <= to_test; i++){
			boolean isPrime = c.isPrime(i);			
			if (isPrime){
				primzahlen[zaehler] = i;
				zaehler++;
			}
			}
		System.out.println("Gefundene Primzahlen: " + zaehler + " in Gruppen zu je 15 dargestellt: ");
		System.out.println();
		for (int j = 0; j < zaehler; j++){		
			System.out.print(primzahlen[j] + " ");
			if ((j == 14) || (j > 28 && j%15 == 0)) System.out.println();		
	}
		long dauer = System.currentTimeMillis() - start;
		System.out.println();
		System.out.println();
		System.out.println("Ausfuehrungdauer: " + dauer);
	}

		
		
		
}
