
public class b {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	int ggT = get_ggT(150,9);
	System.out.println("ggT = " + ggT);
	
	}
	public static int get_ggT(int m, int n){
		int rest = m % n;
		if (rest == 0)
			return n;
		else {	
			m = n;
			n = rest;
			return get_ggT(m,n);
			
		}
		//return n;
		
	
	}

}
