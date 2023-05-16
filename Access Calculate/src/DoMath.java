/*
 * @author Ronit Barman
 * @date Aug 25th, 2022
 * 
 * Client code for testing Calculate Library
 * 
 */
public class DoMath {
	public static void main(String[] args) {
		System.out.println(Calculate.square(-3));
		System.out.println(Calculate.foil(1, 1, 1, 1, "x"));
		System.out.println(Calculate.toImproperFrac(-4, 1, 5));
		System.out.println(Calculate.toMixedNum(-3, 2));
		System.out.println(Calculate.toRadians(90));
		System.out.println(Calculate.round2(10.129));
		System.out.println(Calculate.exponent(0,2));
		System.out.println(Calculate.factorial(5));
		System.out.println(Calculate.sqrt(0));
		System.out.println(Calculate.gcf(-10, -25));
		System.out.println(Calculate.isPrime(11));
		System.out.println(Calculate.max(0, -3, 2));
		System.out.println(Calculate.quadForm(-1, 0, 8));
	}
}
