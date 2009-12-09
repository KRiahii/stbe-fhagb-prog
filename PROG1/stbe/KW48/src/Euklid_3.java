import javax.swing.JOptionPane;


public class Euklid_3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String temp = JOptionPane.showInputDialog(null);
		int grenze = Integer.parseInt(temp);
		// TODO Auto-generated method stub
		long starttime = System.nanoTime();
		int[] allPrimes = getAllPrime(grenze);
		long endtime = System.nanoTime();
		
		for(int i= 2; i< allPrimes.length;i++){
			System.out.println(allPrimes[i]);
		}
		System.out.println("Benötigte Zeit: " + (endtime - starttime) + " ns");
		System.out.println("Obergrenze: " + allPrimes[0]);
		System.out.println("Anzahl der Primz.: " + allPrimes[1]);
	}

	public static boolean isPrime(int n){
		if(n % 2 == 0 || n == 1)
			return true;
		double wurzel = Math.sqrt(n);
		for(int i = 3; i <= wurzel; i += 2){
			if(n % i == 0)
				return false;
		}
		return true;
	}
	
	public static int[] getAllPrime(int n){
		int[] allPrimes = new int[255];
		allPrimes[0] = n; //Position 1 im Array = Endwert bei der Bestimmung
		int index = 2;
		for(int i = 2; i <= n; i++){
			if(index > allPrimes.length - 2){
				allPrimes = copyArray(allPrimes);
			}
			if(isPrime(i))
				allPrimes[index++] = i;
		}
		allPrimes[1] = index; //Position 2 im Array = Anzahl der errechneten Arrays
		return allPrimes;
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
