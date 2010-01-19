import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class CommandProcessor {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub		
		process();
		

	}

	public static void process() throws IOException, InterruptedException {
		Text consoleText = new Text();
		while (true) {
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					System.in));
			String read = reader.readLine();
			// StringBuffer buffer = new StringBuffer(read);
			String command, param;
			int spaceIndex = read.indexOf(" ");
			if (spaceIndex != -1) {
				command = read.substring(0, spaceIndex);
				param = read.substring(spaceIndex + 1);
			} else {
				command = read;
				param = "";
			}
							 
			 
			 if (command.equals("q")){				 
				 System.out.print("Quitting NOW.");
			 	 Thread.sleep(600);
			 	 System.out.print(".");
			 	 Thread.sleep(600);
			 	 System.out.print(".");
			 	 Thread.sleep(600);
			 	 System.out.print(".");			 	 
				 System.exit(0);
			 }
			 // LA : Line Add
			 else if (command.equals("LA")){
				 consoleText.AddLineAtLastLine(param);				 
			 }
			 // UP : Cursor UP
			 else if (command.equals("UP")){
				 consoleText.moveCursorUp();			 
			 }
			// DO : Cursor DO
			 else if (command.equals("DO")){
				 consoleText.moveCursorDown();			 
			 }
			// RI : Cursor Right
			 else if (command.equals("RI")){
				 consoleText.moveCursorRight();			 
			 }
			// LE : Cursor Left
			 else if (command.equals("LE")){
				 consoleText.moveCursorLeft();			 
			 }
			// PG : Get Position (of Cursor)
			 else if (command.equals("PG")){
				System.out.println("Der Cursor befindet sich in Zeile: " + consoleText.returnCursorYpos());
				System.out.println("Der Cursor befindet sich in Spalte: " + consoleText.returnCursorXpos());		 
			 }
			 // TS : Show Text
			 else if (command.equals("TS")){
				 System.out.println(consoleText.getWholeText()); 
			 }
			// CD : Character Delete
			 else if (command.equals("CD")){
				 consoleText.deleteCharAtCursor();
			 }
			// CR : Character Replace
			 else if (command.equals("CR")){
				 char[] temp = param.toCharArray();
				 consoleText.replaceCharAtCursor(temp[0]);
			 }
			


			
		}
		
	}

}
