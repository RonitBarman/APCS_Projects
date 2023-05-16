/*
 * @author Ronit Barman
 * Guessing game
 */

import java.util.*;

public class Guessing 
{

	public static int getRandomNumber(int low, int high)
	{
		int rand = (int) (Math.random() * (high - low + 1)) + low;
		return rand;
	}
	
	public static String compareToSecret(int guessedNum, int secretNum)
	{
		String guessIs = "";
		if (guessedNum < secretNum)
			guessIs = "low";
		else
			guessIs = "high";
		return guessIs;
	}
	
	public static boolean inRange(int low, int high, int num)
	{
		if (low <= num && num <= high)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static void main(String[] args) 
	{
		Scanner userInput = new Scanner(System.in);
		
		System.out.print("Enter your name: ");
		String name = userInput.nextLine();
		System.out.println("Hello " + name + "!");
		
		System.out.print("Input the lower limit: ");
		int lowest = userInput.nextInt();
		System.out.print("Input the higher limit: ");
		int highest = userInput.nextInt();
		while (lowest > highest) {
			System.out.println("The lower bound cannot be greater than the higher bound, try again!");
			System.out.print("Input the lower limit: ");
			lowest = userInput.nextInt();
			System.out.print("Input the higher limit: ");
			highest = userInput.nextInt();
		}
		int secret = getRandomNumber(lowest, highest);
		
		int guess = lowest - 1;
		while (guess != secret) {
			System.out.print("Guess a number: ");
			guess = userInput.nextInt();
			
			// this loop repeats until a valid input is given
			while (guess < lowest || guess > highest) {
				System.out.print("Input was out of range. Try another number: ");
				guess = userInput.nextInt();
			}
			
			if (secret == guess) {
				System.out.println("You guessed right!");
				System.out.println("My number was " + secret + "!");
			}
			else {
				String lowHigh = compareToSecret(guess, secret);
				System.out.println("Nope. " + guess + " is too " + lowHigh);
				System.out.println("Guess again!");
			}
		}
		userInput.close();
				
	}

}
