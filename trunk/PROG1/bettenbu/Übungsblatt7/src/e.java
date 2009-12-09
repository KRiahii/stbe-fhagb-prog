
public class e {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	long start = System.currentTimeMillis();
	int poss_prime = 1500000;
	int breakline = 0;
	int[] Liste = primeList(poss_prime);	
	for (int i = 2; i < Liste.length; i++){
		if (Liste[i] != -1){
			Liste[i] = i;
			System.out.print(Liste[i] + " ");	
		breakline++;
			if (breakline % 15 == 0)
				System.out.println();	
		}
	}
	long dauer = System.currentTimeMillis() - start;
	System.out.println();
	System.out.println();
	System.out.println("Ausfuehrungdauer: " + dauer);
	}
	public static int[] primeList(int totest){
		int[] primeList = new int[totest+1];
//		for (int j = 1; j < primeList.length; j++)
//			primeList[j] = j;
		int marker = 2;
		while ((marker*marker) < totest){
			if (primeList[marker] != -1){	
			for (int i = marker*marker; i <= totest; i+=marker){
					primeList[i] = -1;
				}
			}
			marker++;	
			}
	return primeList;
	}	
}
