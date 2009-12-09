import java.io.IOException;


public class Crypto {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
	char[] test = CharArrayOps.readArray();
	//int key = 5;
	//char[] charKey = {'q','w','e','r','t','z','u','i','o','p','a','s','d','f','g','h','j','k','l','y','x','c','v','b','n','m'};
	//CharArrayOps.printArray(test);
	
	encrypt1_knacken(test);
	//test = encrypt1(test, key);
	//CharArrayOps.printArray(test);
	//test = decrypt(test, key);
	//CharArrayOps.printArray(test);
//	test = encrypt2(test, charKey);
//	CharArrayOps.printArray(test);
//	test = decrypt2(test, charKey);
//	CharArrayOps.printArray(test);
	
	
	
	}
	
	public static char[] encrypt1 (char[] cleartext, int key){
		if (key > 25) {
			System.out.println("Diese Schluessellaenge ist nicht erlaubt um den Text zu verschluesseln");
			return cleartext;
			}
		
		for (int i=0; i < cleartext.length; i++){
			if (cleartext[i] == ' ')
				continue;

			else if (cleartext[i] + key > 'z') cleartext[i] += -('z'-'a' + 1) + key;
			else cleartext[i] += key;
		}
	
	return cleartext;	
	}
	public static char[] decrypt (char[] secrettext, int key){		
		for (int i=0; i < secrettext.length; i++){
			if (secrettext[i] == ' ')
				continue;
			else if (secrettext[i] - key < 'a') secrettext[i] += ('z'-'a' + 1) - key;
			else secrettext[i] -= key;
		}
	
	
	return secrettext;	
	}
	
	public static char[] encrypt2 (char[] cleartext, char[] charkey){


	for (int i = 0; i < cleartext.length; i++){
		if (cleartext[i] == ' ')
			continue;
		int index = cleartext[i] - 'a';
		cleartext[i] = charkey[index];
	}
return cleartext;
}
	public static char[] decrypt2 (char[] secrettext, char[] charkey){
		for (int i = 0; i < secrettext.length; i++){
			if (secrettext[i] == ' ')
				continue;
			for (int j = 0; j < charkey.length; j++){
				if (secrettext[i] == charkey[j]){
					secrettext[i] = (char) (j + 'a');
					break;
				}
				
			}
		}
	return secrettext;
	}
	public static void encrypt1_knacken(char[] test){
	char[] augsburg = {'a','u','g','s','b','u','r','g'};
	if (CharArrayOps.containsArray(test, augsburg) == -1)
		System.out.println("das Wort augsburg muss im Text enthalten sein!!");
	else {	
	test = encrypt1(test, 5);
	char[] decrypted_text = new char[test.length];
	
	for (int i = 1; i < 26; i++){
		CharArrayOps.copyArray(test, decrypted_text);
		decrypted_text = decrypt(decrypted_text, i);
		if (CharArrayOps.containsArray(decrypted_text, augsburg) != -1){
			System.out.println("Schluessel gefunden:" + i);
			CharArrayOps.printArray(decrypted_text);	
		}
		}
		}
	}
	


}
