import javax.swing.JOptionPane;


public class Euklid_2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		String temp = JOptionPane.showInputDialog(null);
//		int grenze = Integer.parseInt(temp);
//		// TODO Auto-generated method stub
//		int[] allPrimes = getAllPrime(grenze);
//		
//		System.out.println("Obergrenze: " + allPrimes[0]);
//		System.out.println("Anzahl der Primz.: " + allPrimes[1]);
////		for(int i= 2; i< allPrimes.length;i++){
////			System.out.println(allPrimes[i]);
		System.out.println(isPrime(1));
//		}
	}

	public static boolean isPrime(int n){
		for(int i = 2; i < n; i++){
			if(n % i == 0 || n == 1)
				return false;
		}
		return true;
	}
	
	public static int[] getAllPrime(int n){
		long starttime = System.nanoTime();
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
		long endtime = System.nanoTime();
		System.out.println("Benötigte Zeit: " + (endtime - starttime) + " ns");
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
