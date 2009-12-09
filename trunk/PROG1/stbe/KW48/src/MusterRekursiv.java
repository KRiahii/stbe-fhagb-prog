
public class MusterRekursiv {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		print(3);
	}

	public static void print(int par){
		if(par > 0)
		{
			print(par - 1);
			System.out.println();
		}
		for(int i = 0; i <= par; i++)
		{
			System.out.print(par);
		}
		if(par > 0){
			System.out.println();
			print(par - 1);
		}
			
	}
}
