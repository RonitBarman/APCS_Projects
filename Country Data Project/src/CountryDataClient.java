/*
 * @author Ronit Barman
 * @date Oct 6, 2022
 * Client for analyzing
 */
import java.io.*;
import java.util.*;
public class CountryDataClient {
	public static void main(String[] args) throws FileNotFoundException {
		File inputFile = new File("CountryDataSet.csv");
		Scanner input = new Scanner(inputFile);
		
		String series = input.nextLine().split(",")[0];
		String[] syears = input.nextLine().split(","); // get the years in string form using split
		int[] years = new int[syears.length-1];
		for (int i = 1; i <= years.length; i++) {
			years[i-1] = Integer.parseInt(syears[i]);
		}
		int numCountries = 18;
		
		Country[] countries = new Country[numCountries];
		int ind = 0;
		
		while (input.hasNextLine()) {
			String line = input.nextLine();
			double[] values = new double[years.length];
			
			String name = getName(line); // use getName to account for the country name being in quotes
			String[] lineVals = line.split(",");
			int offset = 1;
			if (line.indexOf("\"") != -1) offset = 2;
			for (int i = 0; i < years.length; i++) {
				values[i] = Math.round(Double.parseDouble(lineVals[i+offset]) * 100.) / 100.; // round to 2 decimal places
			}
			countries[ind] = new Country(name, series, years, values); // create a country in the array
			ind++;
		}
		
		for (Country country : countries) {
			System.out.println(country.getAcronym() +" for " + years[0] + "-" + years[years.length-1]);
			System.out.println(country);
			System.out.println();
		}
		
		
		input.close();
	}
	
	public static String getName(String line) {
		if (line.indexOf("\"") > -1) { // check for the appearance of a quote
			String quotename = line.split("\"")[1];
			String[] namelist = quotename.split(", ");
			String name = "";
			for (int i = namelist.length - 1; i >= 0; i--) {
				name += namelist[i]+ " ";
			}
			return name; 
		} else 
			return line.split(",")[0]; // otherwise just return the first element in the list
	}

}
