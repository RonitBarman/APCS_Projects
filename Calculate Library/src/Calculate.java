/*
 * @author Ronit Barman
 * @date Aug 25th, 2022
 * 
 * Library of Math Methods
 * 
 */
public class Calculate {
	
	// return the square of the input
	public static int square(int num) {
		return num*num; // multiply the number by itself
	}
	
	// return the cube of the input
	public static int cube(int num) {
		return num*num*num; // multiply the number by itself 3 times
	}
	
	// returns the average of 2 numbers
	public static double average(double numA, double numB) {
		double avg = (numA + numB) / 2; // add the numbers and divide by 2 to get the average
		return avg;
	}
	
	// returns the average of 3 numbers
	public static double average(double numA, double numB, double numC) {
		double avg = (numA + numB + numC) / 3; // add the numbers and divide by 3 to get the average
		return avg;
	}
	
	// converts a given angle in degrees to radians
	public static double toRadians(double degrees) {
		double radians = degrees * (3.14159 / 180); // use the conversion factor of pi radians / 180 degrees
		return radians;
	}
	
	// converts a given angle in radians to degrees
	public static double toDegrees(double radians) {
		double degrees = radians * (180 / 3.14159); // use the conversion factor of 180 degrees / pi radians
		return degrees;
	}
	
	// return the discriminant of a quadratic equation given 3 coefficients
	public static double discriminant(double a, double b, double c) {
		double discriminant = b*b - 4*a*c; 
		return discriminant;
	}
	
	// convert a mixed number to an improper fraction given the whole number, numerator, and denominator
	public static String toImproperFrac(int whole, int numerator, int denominator) {
		if (whole < 0) numerator *= -1;
		int newNumerator = denominator*whole + numerator; // find the value of the new numerator
		
		return newNumerator + "/" + denominator; 
	}
	
	// convert a improper fraction to a mixed number given the whole number, numerator, and denominator
	public static String toMixedNum(int numerator, int denominator) {
		int newNumerator = numerator % denominator; // the new numerator is the remainder of the original numerator / denominator
		int whole = numerator / denominator; // find the whole number of the mixed number
		return whole + "_" + newNumerator + "/" + denominator;
	}
	
	// return the expanded version of an expression in the form
	// (ax + b)(cx + d) given a variable name
	public static String foil(int a, int b, int c, int d, String var) {
		// if we expand out (ax + b)(cx + d), we get:
		// acx^2 + (ad + bc)x + bd
		int term1 = a*c;
		int term2 = a*d + b*c;
		int term3 = b*d;
		
		return term1 + var + "^2 + " + term2 + var + " + " + term3;
	}
	
	// return whether a number is divisible by another number in boolean form
	public static boolean isDivisibleBy(int dividend, int divisor) {
		if (divisor == 0) throw new IllegalArgumentException("cannot divide by 0");
		return (dividend % divisor == 0); // returns a boolean that tells whether or not the dividend is evenly divisible by divisor
	}
	
	// return the absolute value of any double
	public static double absValue(double num) {
		if (num < 0) return -num; // if the number is less than zero, multiply by -1
		return num;
	}
	
	// returns the maximum value out of 2 doubles
	public static double max(double numA, double numB) {
		if (numA > numB) return numA;
		return numB;
	}
	
	// returns the maximum value out of 3 doubles
	public static double max(double numA, double numB, double numC) {
		double max = max(numA, numB);
		if (max > numC) return max;
		return numC;
	}
	
	// returns the minimum value out of 2 integers
	public static int min(int numA, int numB) {
		if (numA > numB) return numB;
		return numA;
	}
	
	// returns a double rounded to 2 places
	public static double round2(double decimal) {

		double absDecimal = absValue(decimal); // get rid of sign of number
		
		// round the number up to 2 decimal places by multiplying by 100 and adding 5,
		// then cast to an int to get rid of excess decimal places
		int roundedDigits = ((int) (absDecimal * 1000) + 5) / 10; 
		double ans = roundedDigits / 100.; // make sure the correct amount of digits are behind the decimal point
		if (decimal < 0) ans = -ans; // if the original number was negative make our answer negative as well
		
		return ans; 
		
	}
	
	// raises a value to a positive integer power
	public static double exponent(double base, int exp) {
		if (exp < 0) throw new IllegalArgumentException("exponent cannot be less than 0: " + exp);
		if (exp == 0. && base == 0.) throw new IllegalArgumentException("base and exponent cannot both be 0");
		
		int ans = 1; // default answer is 1 since the minimum value of the exponent can only be 0
		for (int i = 0; i < exp; i++) { 
			ans *= base; // multiply by the base until i reaches exp
		}
		return ans;
	}
	
	// finds the factorial of a given integer
	public static int factorial(int number) {
		if (number < 0) throw new IllegalArgumentException("input cannot be less than 0: " + number);
		
		int factorial = 1; // default answer is 1 since 0! equals 1
		for (int i = number; i > 0; i--) {
			factorial *= i; // multiply by i, which decreases until it reaches 1
		}
		
		return factorial;
	}
	
	// checks if a integer is prime
	public static boolean isPrime(int number) {
		if (number == 1) return false; // one is divisible by only one and itself, but it is not a prime number
		
		for (int i = 2; i < number; i++) {
			if (isDivisibleBy(number, i)) return false; // if a factor is found, the number cannot be prime, so return false
		}
		// if no factors are found, the number is prime, return true
		return true;
	}
	
	// finds and return the greatest common factors of 2 integers
	public static int gcf(int numA, int numB) {
		int GCF = 1; // the smallest GCF is 1, so it is our default value
		if (numA == 0 || numB == 0) return (int) max(numA, numB); // if one or both of the numbers is zero, then the answer is the larger number (or 0)
		
		// the GCF of 2 numbers can mathematically never be negative, so turn both inputs into positive numbers
		numA = (int) absValue(numA);
		numB = (int) absValue(numB);
		
		// the maximum GCF can only be the smallest of the 2 numbers
		for (int i = 1; i <= min(numA, numB); i++) {
			// check if both integers are divisible by the current number
			// and update ans accordingly
			if (isDivisibleBy(numA, i) && isDivisibleBy(numB, i)) GCF = i; 
		}
		
		return GCF;
	}
	
	// returns the square root of a given double using Newton's square root approximation
	public static double sqrt(double num) {
		if (num < 0) throw new IllegalArgumentException("input cannot be less than 0: " + num);
		double guess = num; // start our initial guess at one
		while (absValue(guess * guess - num) >= 0.005) { // check if the error is still greater than 0.005
			guess = 0.5*(num / guess + guess); // use Newton's approximation
		}
		
		return round2(guess); // return the rounded answer
	}
	
	public static String quadForm(int a, int b, int c) {
		
		if (a == 0) throw new IllegalArgumentException("a cannot be 0");
		
		double discriminant = discriminant(a, b, c);
		
		if (discriminant < 0) { // if the discriminant is less than zero, there are no real roots
			return "no real roots";
			
		} else if (discriminant == 0) { // if the discriminant is equal to zero, there is a single repeated root	
			double root = (((double) -b) + sqrt(discriminant)) / ((double) 2*a); // use quadratic formula to find the root
			return "" + round2(root); // convert to string by adding an empty String
			
		} else { // if the discriminant is positive, there are 2 real roots
			double posRoot = (((double) -b) + sqrt(discriminant)) / ((double) 2*a); // root where square root of discriminant is added
			double negRoot = (((double) -b) - sqrt(discriminant)) / ((double) 2*a); // root where square root of discriminant is subtracted
			
			// decide which root is larger and sort accordingly
			return min(round2(negRoot), round2(posRoot)) + " and " + max(round2(negRoot), round2(posRoot));
		}
	}
	
	// finds the minimum of 2 doubles (this is needed for quadForm)
	public static double min(double numA, double numB) {
		if (numA < numB) return numA;
		return numB;
	}
}
