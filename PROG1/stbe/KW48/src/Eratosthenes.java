import javax.swing.JOptionPane;


public class Eratosthenes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String temp = JOptionPane.showInputDialog(null);
		int grenze = Integer.parseInt(temp);
		long starttime = System.currentTimeMillis();
		// TODO Auto-generated method stub
		
		boolean[] allPrimes = getAllPrime(grenze);
		
		long endtime = System.currentTimeMillis();
		
		for(int i= 2; i< allPrimes.length;i++){
			if(!allPrimes[i])
				System.out.println(i);
		}
		
		System.out.println("Benötigte Zeit: " + (endtime - starttime) + " ms");
	}

	public static boolean isPrime(int n){
		if(n % 2 == 0)
			return true;
		double wurzel = Math.sqrt(n);
		for(int i = 3; i <= wurzel; i += 2){
			if(n % i == 0)
				return false;
		}
		return true;
	}
	
	public static boolean[] getAllPrime(int n){
		boolean[] isPrime = new boolean[n];
		for(int i = 2; i < n; i++)
			isPrime[i] = false;
		
		for(int i = 2; i < Math.sqrt(n); i++){
			if(!isPrime[i]){
				for(int j = i*i; j < n; j += i)
					isPrime[j] = true;
			}
		}

		return isPrime;
	}
	
	public static int[] copyArray(int[] oldArray)
	{
		int[] newArray = new int[oldArray.length + 255];
		for(int i = 0; i < oldArray.length;i++)
		{
			newArray[i] = oldArray[i];
		}
		return newArray;
	}
}
