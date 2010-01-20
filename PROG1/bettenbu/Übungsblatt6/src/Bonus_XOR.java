import java.io.IOException;


public class Bonus_XOR {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	char[] cleartext = CharArrayOps.readArray();
	long key = Long.MAX_VALUE-78127317;
	encrypt(cleartext, key);
	
	
	}
	
	public static void encrypt(char[] cleartext, long key){
		boolean debug = true;
		char[] decrtext = new char[cleartext.length];
		long cleartextbin = 0;
		long encrtextbin = 0;
		long decrtextbin = 0;
	
		for (int i = 0; i < 8; i++){
			
			
			cleartextbin <<= 8;
			cleartextbin += cleartext[i];
			if (debug)
				System.out.println(i + ".te Stelle: " + cleartextbin);
			
							
		}
		encrtextbin = cleartextbin ^ key;
		if (debug)
			System.out.println(encrtextbin);
		
		
		//decrypt und test durch ausgabe
		decrtextbin = encrtextbin ^ key;
		
		if (debug)
			System.out.println(decrtextbin);
		
		for (int k = 7; k >= 0; k--){
			decrtext[k] = (char)(decrtextbin & 255);
			decrtextbin >>= 8;			
			
		}
		CharArrayOps.printArray(cleartext);
		CharArrayOps.printArray(decrtext);
		
	}
	

}
