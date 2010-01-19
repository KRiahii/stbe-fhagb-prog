
public class c {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int to_test = 0;
		boolean isPrime = isPrime(to_test);
		System.out.println(to_test + " = Primzahl: " + isPrime);

	}
	
	public static boolean isPrime(int checkprime){
		boolean prime_found = true;
		for (int i = 2; i < checkprime; i++){
			if (checkprime%i != 0); 
			else{
				prime_found = false;
				break;
			}
		}
	return prime_found;
	}

}
