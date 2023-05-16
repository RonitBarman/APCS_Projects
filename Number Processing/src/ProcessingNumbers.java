/*
 * @author Ronit Barman
 * @date Oct 11, 2022
 * Code for finding max, min, sum of even numbers, max even number of a given series of numbers
 */

import java.util.*;
public class ProcessingNumbers {
	public static void main(String[] args) {
		int min, max;
		int evenMax = -1;
		int evenSum = 0;
		
		Scanner input = new Scanner(System.in);
		System.out.println("How many numbers do you want to input? ");
		int repeats = input.nextInt();
		System.out.print("\nInput a number: ");
		int firstnum = input.nextInt();
		min = firstnum;
		max = firstnum;
		if (firstnum % 2 == 0) {
			evenMax = firstnum;
			evenSum += firstnum;
		}
		
		for (int i = 1; i < repeats; i++) {
			System.out.print("\nInput a number: ");
			int num = input.nextInt();
			if (num > max) max = num;
			if (num < min) min = num;
			if (num % 2 == 0) {
				evenSum += num;
				if (evenMax == -1 || evenMax < num) evenMax = num;
			}
		}
		System.out.println("Max: "+ max);
		System.out.println("Min: "+ min);
		System.out.println("Sum of even numbers: "+ evenSum);
		System.out.println("Max even numbers: "+ evenMax);
	}

}
