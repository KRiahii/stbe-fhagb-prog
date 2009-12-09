import java.io.IOException;


public class HideInfoAufrufklasse {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		char[] test = CharArrayOps.readArray();
		
		char[] test1 = HideInfo.replaceChars(test);
		char[] test2 = HideInfo.replaceEach2ndChar(test);
		char[] test3 = HideInfo.insertGEHEIMNIS(test);
		char[] test4 = HideInfo.deleteVowels(test);
		
		CharArrayOps.printArray(test1);
		CharArrayOps.printArray(test2);
		CharArrayOps.printArray(test3);
		CharArrayOps.printArray(test4);
	}

}
