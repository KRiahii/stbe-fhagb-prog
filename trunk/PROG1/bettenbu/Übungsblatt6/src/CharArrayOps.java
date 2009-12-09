import java.io.IOException;

public class CharArrayOps {
	public static void main(String[] args) throws IOException {
		
		char[] test = readArray();
		printArray(test);
//		//replaceChar(test, 'o', 'a');
//		//printArray(test);
//		//replaceChar(test, 'i', 'u');
//		//printArray(test);
//		char[] part = {'g','e','h','t'};
//		int enthalten = containsArray(test, part);
//		System.out.println(enthalten);
//		test = deleteChar(test, 5);
//		test = deleteAllofChar(test, 'e');
//		test = insertChar(test, '3', 6);
		char[] insert = {'a','b','c'};
		test = insertString(test, insert , 5);
		printArray(test);		
	}

	//Aufgabe 1) Einlesen des Array-Inhalts als eine Zeile von Stdin (auf Basis von System.in.read()). 
	public static char[] readArray() throws IOException{
		System.out.println("Geben Sie einen Text ein!");
		
		char[] charArr = new char[0];
		int i = 0;
		char c = (char) System.in.read();
		
		do{
			if(c == '\n' || c == '\r'){
				System.in.read();	//Damit das zweite Zeichen von \n\r auch gelesen wird.
				return null;
			}
			else{
				char[] tempCharArr = new char[++i];
				
				copyArray(charArr, tempCharArr);
			
				charArr = tempCharArr;
				
				charArr[i-1] = c;
			}
			
			c = (char) System.in.read(); 
		}
		while(c != '\n' && c != '\r');

		System.in.read();	//Damit das zweite Zeichen von \n\r auch gelesen wird.
		
		return charArr;
	}
	
	//Aufgabe 2) Ausgeben des Array-Inhalts als eine Zeile auf Stdout.
	public static void printArray(char[] printArray) {
		for (int i = 0; i < printArray.length;i++){
			System.out.print(printArray[i]);
		}
		System.out.print('\n');
	}
	
	//Aufgabe 3) Ersetzen eines spezifizierten Buchstabens durch einen anderen spezifizierten Buchstaben im gesamten Array.
	public static char[] replaceChar(char[] replaceArray, char oldChar, char newChar){
		
		boolean containsChar = false;
		
		for(int i=0;i< replaceArray.length;i++)
		{
			if(replaceArray[i] == oldChar){
				replaceArray[i] = newChar;
				containsChar = true;
			}
		}
		
		if(!containsChar)
			System.out.println("Buchstabe gar nicht enthalten!");
		
		return replaceArray;
	}
	
	//Aufgabe 4) Prüfen, ob ein Array als Muster (Teilarray) in einem anderen Array enthalten ist. Wenn ja Rückgabe wo (Anfangsposition), ansonsten Rückgabe von -1.
	public static int containsArray(char[] completeArray, char[] partArray){
		int startIndex = -1;
		boolean partFound = false;
		if(completeArray.length > partArray.length && partArray.length >= 2)
			for (int i = 0; i < completeArray.length; i++){
				if (partArray[0] == completeArray[i]){
					for (int j = 1; j < partArray.length; j++){
						if (partArray[j] == completeArray[j+i]){
							startIndex = i;
							partFound = true;
						}
						else{
							startIndex = -1;
							partFound = false;
							break;
						}
					}	 		
				}
				if(partFound)
					break;
			}
		else
			System.out.println("Teilarray zu kurz oder zu lang!");
		return startIndex;
	}	
	
	//Aufgabe 5) Löschen eines einzelnen Zeichens, dessen Position im Array geeignet angegeben wird.
	public static char[] deleteChar(char[] charArray, int deleteIndex){
		
		char[] newArray = new char[charArray.length-1];
		for(int i = 0; i < newArray.length; i++){
			if(i < deleteIndex)
			{
				newArray[i] = charArray[i];
			}
			else
			{
				newArray[i] = charArray[i+1];
			}
		}
		
		return newArray;
	}
	
	//Aufgabe 6) Löschen aller Vorkommen eines per Parameter vorgegebenen Zeichens im Array. 
	public static char[] deleteAllofChar(char [] charArray, char deleteChar){
	 boolean charcontained = false;
		for (int i = 0; i < charArray.length; i++){
		 if (charArray[i] == deleteChar){ 
			 charArray = deleteChar(charArray, i);
			 i--;
			 charcontained = true;
		 	}
		 }
		if (!charcontained) 
			System.out.println("Das Zeichen ist gar nicht enthalten"); 
	return charArray;
	}
	
	//Aufgabe 7) Einfügen eines Zeichens (evtl. sogar Zeichenfolge) an einer vorgebbaren Stelle.
	public static char[] insertChar(char[] charArray, char newChar, int index){
		
		char[] newArray = new char[charArray.length+1];
		
		for(int i = 0; i < newArray.length; i++)
		{
			if(i < index)
				newArray[i] = charArray[i];
			else if(i == index)
				newArray[i] = newChar;
			else
				newArray[i] = charArray[i-1];
		}
		
		return newArray;
	}
	
	//Aufgabe 7) Einfügen eines Zeichens (evtl. sogar Zeichenfolge) an einer vorgebbaren Stelle.
	public static char[] insertString(char[] charArray, char[] insertCharArray, int index){
		
		char[] newArray = new char[charArray.length+insertCharArray.length];
		
		for(int i = 0; i < newArray.length; i++)
		{
			if(i < index)
				newArray[i] = charArray[i];
			else if(i == index){
				for(int j = 0; j < insertCharArray.length; j++){
					newArray[i+j] = insertCharArray[j];
				}
				i = i + insertCharArray.length - 1;
			}
			else
				newArray[i] = charArray[i-insertCharArray.length];
		}
		
		return newArray;
	}
	
	//Hilfsfunktionen
	public static void copyArray(char[] oldArray, char[] newArray) {
		
		for(int i = 0; i < oldArray.length;i++)
		{
			newArray[i] = oldArray[i];
		}
	}
}
