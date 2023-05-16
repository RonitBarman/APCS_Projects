/*
 * @author Ronit Barman
 * @date Sep 22nd, 2022
 * 
 * Client code for running the Quadratic Describer
 * 
 */
import java.util.*;

public class QuadraticClient {
	
	public static void main(String[] args) {
		String reply = ""; // initialize reply as an empty String
		
		while (!reply.equals("quit")) { // as long as the user does not reply "quit" to the question, keep running the describer
			// prompt the user
			System.out.println("Welcome to the Quadratic Describer\nProvide values for coefficients a, b, and c\n");
			
			// create the scanner
			Scanner input = new Scanner(System.in);
			System.out.print("a: ");
			double a = input.nextDouble(); // retrieve the user input for a
			
			System.out.print("b: ");
			double b = input.nextDouble(); // retrieve the user input for b
			
			System.out.print("c: ");
			double c = input.nextDouble(); // retrieve the user input for c
			
			System.out.println();
			System.out.println(Quadratic.quadrDescriber(a, b, c)); // print the String returned by quadrDescriber
			
			System.out.println("\nDo you want to keep going? (Type \"quit\" to end)");
			reply = input.next(); // retrieve user reply to the question
			
		}
		
	}

}
