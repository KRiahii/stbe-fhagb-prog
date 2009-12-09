public class c {
   public static void main(String[] args) throws Exception {
    
	System.out.println("Gib ein Unicode Zeichen in der Escape-Syntax \\uxxxx ein:");
	int ergebnis = 0;
	
	for (int i = 1; i <= 6; i++){
		char zwischenspeicher = (char)System.in.read();
		if (zwischenspeicher != '\r' & zwischenspeicher != '\n'){
		if (i == 1 & zwischenspeicher != '\\'){
			System.out.println("Eingabe nicht mit \\ eingeleitet");
			break;
		}
	    if (i == 2 & zwischenspeicher != 'u'){
	    	System.out.println("2. Stelle muss ein u sein");
	    	break;
	    }
		if (i >= 3 & zwischenspeicher >= '0' & zwischenspeicher <= '9')
			ergebnis += (((int)zwischenspeicher - 48)*Math.pow(16, 6-i)); 
		else if (i >= 3 & ((zwischenspeicher >= 'a' & zwischenspeicher <= 'f')))
				ergebnis += ((int)zwischenspeicher-87)*Math.pow(16, 6-i);	
		else if (i >= 3) System.out.println("Eingabe nicht ok");
		
		}
	    else{
	    	System.out.println("Eingabe zu kurz");
	    	break;
	    	}
		
		}
	System.out.println("Das Zeichen sieht so aus " + (char)ergebnis);
	
	
		
	
	//Zeichen 1 und 2 prüfen
	/**if (c1 != '\\' || c2 != 'u') 
	{
	System.out.println("Eingabe nicht mit \\u eingeleitet!!");
	return;
	}
	
	
	//Zeichen 1-7 prüfen, Länge der Eingabe
	if (c1 == '\r' || c2 == '\r' || c3 == '\r' || c4 == '\r' || c5 == '\r' || c6 == '\r' || c7 != '\r') 
	{
		System.out.println("Eingabe ist zu kurz oder zu lang");
		return;
	}
	
	//Zeichen 3-6 auf Hextauglichkeit prüfen
	
	//wieso kann ich hier nicht die ganze Klammer negieren???
	
	if (((c3 >= '0' && c3 <= '9') || (c3 >= 'a' && c3 <= 'f'))
	&& ((c4 >= '0' && c4 <= '9') || (c4 >= 'a' && c4 <= 'f'))
	&& ((c5 >= '0' && c5 <= '9') || (c5 >= 'a' && c5 <= 'f'))
	&& ((c6 >= '0' && c6 <= '9') || (c6 >= 'a' && c6 <= 'f')))
	{
		System.out.println("Eingabe korrekt");
		int ergebnis = 0;
		// 4. stelle berechnen
		if (c6 >= '0' && c6 <= '9') 
			ergebnis += ((int)c6-48)*1;
		else if (c6 >= 'a' && c6 <= 'f') 
			ergebnis += ((int)c6-87)*1;
		// 3. stelle berechnen
		if (c5 >= '0' && c5 <= '9') 
			ergebnis += ((int)c5-48)*16;
		else if (c5 >= 'a' && c5 <= 'f') 
			ergebnis += ((int)c5-87)*16;
		// 2. stelle berechnen
		if (c4 >= '0' && c4 <= '9') 
			ergebnis += ((int)c4-48)*256;
		else if (c4 >= 'a' && c4 <= 'f') 
			ergebnis += ((int)c4-87)*256;
		// 1. stelle berechnen
		if (c3 >= '0' && c3 <= '9') 
			ergebnis += ((int)c3-48)*4096;
		else if (c3 >= 'a' && c3 <= 'f') 
			ergebnis += ((int)c3-87)*4096;
		System.out.println("Ergebnis dezimal: " + ergebnis);
		System.out.println("Zeichen " + (char)ergebnis);
		
	}
	else System.out.println("Keine Eingabe im HEX Format");
	*/
	

	
	
	}
}	
	
    