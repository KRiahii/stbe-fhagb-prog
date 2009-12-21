import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class CommandProcessor {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		process();

	}
	public static void process() throws IOException{
		while (true){
			 BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			 String read = reader.readLine();
			 StringBuffer buffer = new StringBuffer(read);
			 String command = buffer.substring(0,  buffer.indexOf(" "));
			 if (command.equals("q"))				
				 System.exit(0);
			 
			

			
		}
		
	}

}
