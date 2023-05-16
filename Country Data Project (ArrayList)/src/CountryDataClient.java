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
		// get the years in string form using split
		String[] syears = input.nextLine().split(","); 
		ArrayList<Integer> years = new ArrayList<>();
		for (int i = 1; i < syears.length; i++) {
			years.add(Integer.parseInt(syears[i]));
		}
		
		ArrayList<Country> countries = new ArrayList<>();
		
		while (input.hasNextLine()) {
			String line = input.nextLine();
			ArrayList<Double> values = new ArrayList<>();
			
			// use getName to account for the country name being in quotes
			String name = getName(line); 
			String[] lineVals = line.split(",");
			int offset = 1;
			if (line.indexOf("\"") != -1) offset = 2;
			for (int i = 0; i < years.size(); i++) {
				values.add(Double.parseDouble(lineVals[i+offset])); // round to 2 decimal places
			}
			Country country = new Country(name, series, years, values);
			countries.add(country); // create a country in the array
		}
		
		for (Country c : countries) {
			System.out.println(
				c.getAcronym() +" for " + years.get(0) + "-" + years.get(years.size()-1)
			);
			System.out.println(c);
			System.out.println();
		}
		
	}
	
	// gets name of country and accounts for quotes
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
			// otherwise just return the first element in the list
			return line.split(",")[0]; 
	}
	
	// remove a given country from an ArrayList by its name
	public static void removeByName(ArrayList<Country> countries, String name) {
		for (int i = 0; i < countries.size(); i++) {
			if (countries.get(i).getCountry().equals(name)) {
				countries.remove(i);
				break;
			}
		}
	}
	
	// remove countries that have no trend from a given ArrayList
	public static void removeNoTrend(ArrayList<Country> countries) {
		for (int i = 0; i < countries.size(); i++) {
			if (countries.get(i).getTrend().equals("no trend")) {
				countries.remove(i);
				i--;
			}
		}
	}
	
	// returns an ArrayList of countries with only a certain given trend
	public static ArrayList<String> getListBasedOnTrend(ArrayList<Country> countries, String trendType) 
			throws IllegalArgumentException {
		if (!trendType.equals("up") && !trendType.equals("down") && !trendType.equals("no trend")) 
			throw new IllegalArgumentException("trendType must be \"up\", \"down\", or \"no trend\"");
		
		ArrayList<String> names = new ArrayList<>();
		for (int i = 0; i < countries.size(); i++) {
			if (countries.get(i).getTrend().equals(trendType))
				names.add(countries.get(i).getCountry());
		}
		return names;
		
	}

}
