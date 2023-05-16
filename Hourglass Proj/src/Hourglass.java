import java.util.*;

public class Hourglass {
	public static void main(String[] args) {
		printAll(100);
	}
	
	public static void printAll(int length) {
		base(length);
		topBody(length - 2);
		for (int i = 0; i < length / 2; i++) System.out.print(" ");
		
		if (length % 2 == 0) System.out.println("||");
		else System.out.println("| |");
		
		bottomBody(length - 2);
		base(length);
	}
	public static void base(int length) {
		System.out.print("|");
		for (int i = 0; i < length; i++) {
			System.out.print("\"");
		}
		System.out.println("|");
	}
	
	public static void topBody(int length) {
		int layers = (int) Math.ceil((double) length / 2.);
		for (int i = 0; i < layers; i++) {
			for (int j = 0; j < i + 1; j++) System.out.print(" ");
			
			System.out.print("\\");
			for (int j = 0; j < length; j++) {
				System.out.print(":");
			}
			System.out.println("/");
			length -= 2;
		}
	}
	
	public static void bottomBody(int length) {
		int layers = (int) Math.ceil((double) length / 2.);
		int startlength = 2;
		if (length % 2 != 0) startlength = 1;
		for (int i = layers; i > 0; i--) {
			for (int j = 0; j < i; j++) System.out.print(" ");
			System.out.print("/");
			for (int j = 0; j < startlength; j++) {
				System.out.print(":");
			}
			System.out.println("\\");
			startlength += 2;
		}
	}
}
