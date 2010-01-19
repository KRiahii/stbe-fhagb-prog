public class Primfaktoren {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// int[] primzahlen = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29 };
		int[][] ergebnis = new int[30][2];
		// zu zerlegende Zahl
		int zahl = 51717271;
		//Zaehler für Häufigkeit der Teilbarkeit = Exponent => z.b. 8 = 2^3
		int zaehler = 0;
		//zaehler für feldindex vom Ergebnis Array
		int feldindex = 0;
		boolean teilbar = false;
		for (int i = 2; i <= zahl; i++) {
			// test ob i überhaupt eine Primzahl ist
			if (c.isPrime(i)) {
				while (zahl % i == 0) {
					zaehler++;
					teilbar = true;
					zahl = zahl / i;
				}
				//wenn durch aktuelle primzahl teilbar dann schreibe ins ergebnis array
				if (teilbar) {
					//Schreibe in die erste Spalte den aktuellen Primfaktor
					ergebnis[feldindex][0] = i;
					//Schreibe in die zweite Spalte die Häufigkeit des Auftretens = Exponent
					ergebnis[feldindex][1] = zaehler;
					zaehler = 0;
					teilbar = false;
					feldindex++;
				}
			}
		}
//Ausgabe des Int Arrays
		for (int k = 0; k < ergebnis.length; k++) {
			if (ergebnis[k][0] == 0)
				break;
			System.out.print(ergebnis[k][0]);
			System.out.print("(" + ergebnis[k][1] + ")*");
		}
	}

}
