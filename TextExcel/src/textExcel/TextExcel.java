package textExcel;
/*
 * @name Ronit Barman
 * @date Feb 21, 2023
 * 
 * Simple version of a Spreadsheet application
 * 
 */
import java.util.Scanner;

// Update this file with your own code.

public class TextExcel
{

	public static void main(String[] args)
	{
		/*
		 * Create a scanner to get commands from the user
		 * Run a while loop that gets and processes commands
		 * until the user chooses to exit the program
		 * 
		 */
		System.out.println("WELCOME TO TEXTEXCEL!");
		Scanner sc = new Scanner(System.in);
		Spreadsheet sheet = new Spreadsheet();
		System.out.println(sheet.getGridText());
		while (true) {
			String command = sc.nextLine();
			// exit the loop when the user types "quit"
			if (command.equals("quit")) break;  
			
			// print the output from process command
			System.out.println(sheet.processCommand(command)+"\n");
		}
	}
}
