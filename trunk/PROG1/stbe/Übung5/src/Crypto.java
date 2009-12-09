import java.io.IOException;


public class Crypto {
	
	public static void main(String[] args) throws IOException{
		char[] test = CharArrayOps.readArray();
		int key = 1;
		char[] charKey = {'q','w','e','r','t','z','u','i','o','p','a','s','d','f','g','h','j','k','l','y','x','c','v','b','n','m'}; 
		//char[] charKeyde = {'k','x','v','m','c','n','o','p','h','q','r','s','z','y','i','j','a','d','l','e','g','w','b','u','t','f'};
		
		test = encrypt1_alternativ(test, key);
					
		CharArrayOps.printArray(test);
		
		test = decrypt1_alternativ(test, key);
		
		CharArrayOps.printArray(test);
	}

	static char[] encrypt1(char[] clearText, int key){
		if(key > 25){
			System.out.println("Diese Schlüssellänge ist nicht erlaubt! Text wird nicht verschlüsselt!");
			return clearText;
		}
		for(int i=0;i<clearText.length;i++){
			if(clearText[i] == ' ')
				continue;
			else if(clearText[i] <= 'z' - key)
				clearText[i] += key;
			else
				clearText[i] += - ('z' - 'a' + 1) + key;
		}
		return clearText;
	}
	
	static char[] encrypt1_alternativ(char[] clearText, int key)
	{
		if(key > 25){
			System.out.println("Diese Schlüssellänge ist nicht erlaubt! Text wird nicht verschlüsselt!");
			return clearText;
		}
		for(int i = 0;i< 26; i++)
		{
			if('a' + i + key <= 'z')
				CharArrayOps.replaceChar(clearText,(char) ('a' + i),(char) ('a' + i + key));
			else
				CharArrayOps.replaceChar(clearText,(char) ('a' + i),(char) (('a' + i + key) - ('z' - 'a' + 1)));
		}
		
		return clearText;
	}
	
	static char[] decrypt1(char[] secretText, int key){
		if(key > 25){
			System.out.println("Diese Schlüssellänge ist nicht erlaubt! Text wird nicht entschlüsselt!");
			return secretText;
		}
		for(int i=0;i<secretText.length;i++){
			if(secretText[i] == ' ')
				continue;
			else if(secretText[i] - key >= 'a')
				secretText[i] -= key;
			else
				secretText[i] += ('z' - 'a' + 1) - key;
								
		}
		return secretText;
	}
	
	static char[] decrypt1_alternativ(char[] clearText, int key)
	{
		if(key > 25){
			System.out.println("Diese Schlüssellänge ist nicht erlaubt! Text wird nicht verschlüsselt!");
			return clearText;
		}
		for(int i = 0;i< 26; i++)
		{
			if('a' + i - key >= 'a')
				CharArrayOps.replaceChar(clearText,(char) ('a' + i),(char) ('a' + i - key));
			else
				CharArrayOps.replaceChar(clearText,(char) ('a' + i),(char) (('a' + i - key) + ('z' - 'a' + 1)));
		}
		
		return clearText;
	}
	
	static char[] encrypt2(char[] clearText, char[] key){
		if(key.length != 26){
			System.out.println("Ungültiger Schlüssel! Text wird nicht verschlüsselt!");
			return clearText;
		}
		
		for(int i = 0; i < clearText.length;i++){
			if(clearText[i] != ' ')
				clearText[i] = key[clearText[i] - 'a'];
		}
		
		return clearText;
	}
	
	static char[] encrypt2_alternativ(char[] clearText, char[] key){
		if(key.length != 26){
			System.out.println("Ungültiger Schlüssel! Text wird nicht verschlüsselt!");
			return clearText;
		}
		
		for(int i = 0; i < 26;i++){
			CharArrayOps.replaceChar(clearText, (char) ('a' + i), key[i]); 
		}
		
		return clearText;
	}
	
	static char[] decrypt2(char[] secretText, char[] key){
		if(key.length != 26){
			System.out.println("Ungültiger Schlüssel! Text wird nicht verschlüsselt!");
			return secretText;
		}
		
		for(int i = 0; i < secretText.length; i++){
		if(secretText[i] != ' ')
			for(int j= 0; j < key.length;j++){
				if(secretText[i] == key[j]){
					secretText[i] = (char) (j + 'a');
					break;
				}
			}
		}
			
		return secretText;
	}
}
	
