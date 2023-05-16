/*
 * @author Ronit Barman
 * @date Sep 22nd, 2022
 * 
 * Class of math methods needed to describe a quadratic function
 * 
 */
public class Quadratic {
	public static String quadrDescriber(double a, double b, double c) {
		String direction = "";
		
		// direction of the parabola is determined by the sign of a
		if (a > 0) direction = "Up"; // if a > 0, the parabola opens up
		else direction = "Down"; // otherwise it opens down
		
		
		double vertexX = -(b / (2*a)); // complete the square to find the x intercept
		if (b == 0.0) vertexX = 0.0; // get rid of negative sign in front of 0 if the vertex is 0
		
		double vertexY = -((b*b) / (4*a)) + c; // complete the square to find the y intercept
		
		String xInts = quadForm(a, b, c); // quadForm will calculate
		
		// create the output String and substitute variables into their correct places
		return "Description of the Graph of:\n"
			 + "y = " + a + " x^2 + " + b + " x + " + c+"\n\n"
			 + "Opens: " + direction + "\n"
			 + "Axis of Symmetry: " + vertexX + "\n" // axis of symmetry is the x-coordinate of the vertex
			 + "Vertex: (" + vertexX + ", " + vertexY + ")\n"
			 + "x-intercept(s): " + xInts + "\n"
			 + "y-intercept: " + c;
	}
	
	
	public static String quadForm(double a, double b, double c) {
		
		if (a == 0) throw new IllegalArgumentException("a cannot be 0"); // if a is 0, the function is not quadratic
		
		double discriminant = discriminant(a, b, c);
		
		if (discriminant < 0) { // if the discriminant is less than zero, there are no real roots
			return "None";
			
		} else if (discriminant == 0) { // if the discriminant is equal to zero, there is a single repeated root	
			double root = (-b + sqrt(discriminant)) / (2*a); // use quadratic formula to find the root
			return "" + round2(root); // convert to string by adding an empty String
			
		} else { // if the discriminant is positive, there are 2 real roots
			double posRoot = (-b + sqrt(discriminant)) / (2*a); // root where square root of discriminant is added
			double negRoot = (-b - sqrt(discriminant)) / (2*a); // root where square root of discriminant is subtracted
			
			// decide which root is larger and sort accordingly
			return min(round2(negRoot), round2(posRoot)) + " and " + max(round2(negRoot), round2(posRoot));
		}
	}
	
	// return the discriminant of a quadratic equation given 3 coefficients
	public static double discriminant(double a, double b, double c) {
		double discriminant = b*b - 4*a*c; 
		return discriminant;
	}
	
	// finds the minimum of 2 doubles
	public static double min(double numA, double numB) {
		if (numA < numB) return numA;
		return numB;
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
	
	// return the absolute value of any double
	public static double absValue(double num) {
		if (num < 0) return -num; // if the number is less than zero, multiply by -1
		return num;
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
	
	// returns the maximum value out of 2 doubles
	public static double max(double numA, double numB) {
		if (numA > numB) return numA;
		return numB;
	}
}
