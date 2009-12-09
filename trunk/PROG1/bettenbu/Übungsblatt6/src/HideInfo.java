
public class HideInfo {
	//Aufgabe 1) Jedes 'e' durch ein 'i' und jedes 'a' durch ein 'u' ersetzen.
	public static char[] replaceChars (char[] oldtext){
		oldtext = CharArrayOps.replaceChar(oldtext, 'e', 'i');
		oldtext = CharArrayOps.replaceChar(oldtext, 'a', 'u');
	return oldtext;
	}
	
	//Aufgabe 2) An jeder zweiten Stelle im Text ein 'e' einfügen.
	public static char[] replaceEach2ndChar(char[] oldtext){
		for(int i = 0; i < oldtext.length; i++){
			if(i%2 == 1)
				oldtext = CharArrayOps.insertChar(oldtext, 'e', i);
		}
		
		return oldtext;
	}
	
	// Aufgabe 3) An Stelle des 'e' aus der vorhergehenden Methode abwechselnd immer eines 
	//der Zeichen in einem Array (z. B. mit Inhalt "geheimnis") in den Text einmischen. 
	public static char[] insertGEHEIMNIS(char[] text){
		char[] geheimnis = {'g','e','h','e','i','m','n','i','s'};
		int zeichencounter = 0;
		for(int i = 0; i < text.length; i++){
			if(i%2 == 1){
				text = CharArrayOps.insertChar(text, geheimnis[zeichencounter], i);
				zeichencounter ++;
				if (zeichencounter >8) zeichencounter = 0;
			}
			
		}
	return text;
	}
	
	//Aufgabe 4) Alle Vokale (ohne Umlaute) löschen. 
	public static char[] deleteVowels(char[] text){
		
		text = CharArrayOps.deleteAllofChar(text, 'a');
		text = CharArrayOps.deleteAllofChar(text, 'o');
		text = CharArrayOps.deleteAllofChar(text, 'u');
		text = CharArrayOps.deleteAllofChar(text, 'i');
		text = CharArrayOps.deleteAllofChar(text, 'e');
		
		return text;
	}
	
}
