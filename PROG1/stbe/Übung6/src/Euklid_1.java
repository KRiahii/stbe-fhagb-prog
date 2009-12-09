
public class Euklid_1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getggTrekursiv(18, 12));
		System.out.println(getggTiterativ(13, 5));
	}
	
	public static int getggTrekursiv(int m, int n){
		int r = m % n;
		if(r == 0)
			return n;
		else
			return getggTrekursiv(n, r);
	}
	
	public static int getggTiterativ(int m, int n){
		int r;
		do{
			r = m % n;
			if(r == 0){
				return n;
			}
			else{
				m = n;
				n = r;
			}
		}
		while(r > 0);
		return n;
	}
}
