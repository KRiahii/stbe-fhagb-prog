import java.io.*;

public class CommandProcessor {
	private Text text = new Text();
	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		CommandProcessor editor = new CommandProcessor();
		String cmd, arg;
		
		while(true){			
			BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
			String input = consoleReader.readLine();
			
			int index = input.indexOf(' '); //erstes Leerzeichen ermitteln (voher Befehl - danach Argumente)
			if(index == -1){ 				//Nur Befehl kein Leerzeichen
				cmd = input;
				arg = "";
			}
			else{							//Mindestes Befehl + Leerzeichen, evt mit Argumenten
				cmd = input.substring(0, index);
				arg = input.substring(index + 1);
			}
			
			if(index > 5){					//Befehle dürgen maximal 4 Zeichen lang sein
				System.out.println("Ungültiger Befehl!");
			}
			else{
				int result = editor.process(cmd, arg);
				
				if(result == 1){			//Befehl ist ungültig/unbekannt
					System.out.println("Unbekannter oder ungültiger Befehl!");
				}
				else if(result == 2){		//Befehl q (beenden) wurde gelesen
					break;
				}
			}
		}
	}

	/**
	 * Process Methode die die eingegebenen Befehle verarbeitet.
	 * @param cmd Command der zu verarbeiten ist
	 * @param arg Argument des Commands
	 * @return Gibt eine Erfolgsanzeiger des Process an. 0 = Prozess erfolgreich 1 = Befehl unbekannt/ungültig 2 = Programm beenden
	 * @throws IOException 
	 */
	public int process(String cmd, String arg) throws IOException{
		if(cmd.equals("q")){		// Befehl q => Pogramm soll beendet werden => return 2
			return 2;
		}
		else if(cmd.equals("al")){	// eine Zeile hinzufügen
			text.addLine(arg);
		}
		else if(cmd.equals("st")){	// den gesamten Text anzeigen
			System.out.println(text.getWholeText());
			return 0;
		}
		else if(cmd.equals("mcu")){	// bewegt den Cursor nach oben
			text.moveCursorUp();
		}
		else if(cmd.equals("mcd")){	// bewegt den Cursor nach unten
			text.moveCursorDown();
		}
		else if(cmd.equals("mcl")){	// bewegt den Cursor nach links
			text.moveCursorLeft();
		}
		else if(cmd.equals("mcr")){	// bewegt den Cursor nach rechts
			text.moveCursorRight();
		}
		else if(cmd.equals("dc")){	// löscht das Zeichen am Cursor
			text.deleteCharAtCursor();
		}
		else if(cmd.equals("dl")){	// löscht die Zeile am Cursor
			text.deleteLineAtCursor();
		}
		else if(cmd.equals("cc")){	// ersetzt das Zeichen am Cursor
			text.replaceCharAtCursor(arg.charAt(0));
		}
		else{						//Befehl nicht bekannt => return 1
			return 1;
		}	
		this.process("st", "");		//Nach jedem Befehl aktuellen Text anzeigen
		
		return 0;					//Befehl erkannt und bearbeitet => return 0
	}
}
