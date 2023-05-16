import java.util.ArrayList;

/*
 * @author Ronit Barman
 * @data December 8, 2022
 */
public class Country {

	private String countryName;
	private String series;
	private ArrayList<Integer> years;
	private ArrayList<Double> data;
	
	public Country(String countryName, String series, ArrayList<Integer> years, ArrayList<Double> data) {
		this.countryName = countryName;
		this.series = series;
		this.years = years;
		this.data = data;
	}
	
	// converts the country object into a displayable string
	public String toString() {
		String combined = "";
		for (int i = 0; i < years.size(); i++) {
			combined += years.get(i) + "\t";
		}
		
		String values = "";
		double min = Math.round(min() * 100.) / 100.;
		double max = Math.round(max() * 100.) / 100.;
		for (int i = 0; i < data.size(); i++) {
			values += Math.round(data.get(i) * 100.)/100. + "\t";
		}
		combined += "\n" + values + "\n";
		combined += "This is the \"" + series + "\" for " + countryName + "\n";
		combined += "Minimum: " + min + "\n" + "Maximum: " + max;
		combined += "\nTrending: " + getTrend();
		return combined;
	}
	
	// This method returns the lowest value in the 
	// data stored for the country.
	public double min() {
		double min = Double.MAX_VALUE;
		for (double value : data) {
			if (value < min) min = value;
		}
		return min;
	}
	
	//  This method returns the highest value in the data 
	// stored for the country.
	public double max() {
		double max = Double.MIN_VALUE;
		for (double value : data) {
			if (value > max) max = value;
		}
		return max;
	}
	
	// This method returns the units for the stored data.  
	// The string that is returned should not include parentheses.
	public String getUnits() {
		if (series.indexOf("(") == -1) return "";
		String unit = series.substring(series.indexOf("(") + 1, series.indexOf(")"));
		return unit;
	}
	
	// This method returns an acronym made of the first letter in 
	// each of the words in the series name, 
	// but excludes: of, in, the, at, to, by, per, on, a, an.
	public String getAcronym() {
		String acronym = "";
		String[] exclude = {"of", "in", "the", "at", "to", "by", "per", "on", "a", "an"};
		String[] words = this.getSeries().split(" ");
		for (int i = 0; i < words.length; i++) {
			boolean contains = false;
			for (int j = 0; j < exclude.length; j++) {
				if (words[i].equals(exclude[j])) {
					contains = true;
					break;
				}
			}
			if (!contains) {
				acronym += words[i].charAt(0);
			}
		}
		return acronym.toUpperCase();
	}
	
	
	// This method returns up, down, or no trend depending on 
	// which direction the data is trending. 
	public String getTrend() {
		if (trendsUp()) return "up";
		if (trendsDown()) return "down";
		else return "no trend";
	}
	
	// This method returns a boolean representing whether each 
	// successive data point is higher than the previous one
	private boolean trendsUp() {
		for (int i = 1; i < data.size(); i++) {
			if (data.get(i) <= data.get(i-1)) return false;
		}
		return true;
	}
	
	// Same idea as trendsUp, each data point must be lower 
	// than the one that came before, otherwise it will return false.
	private boolean trendsDown() {
		for (int i = 1; i < data.size(); i++) {
			if (data.get(i) >= data.get(i-1)) return false;
		}
		return true;
	}
	
	public void setData(ArrayList<Double> d) {
		data = d;
	}
	
	public ArrayList<Double> getData() {
		return data;
	}
	
	public void setSeries(String s) {
		series = s;
	}
	
	public String getSeries() {
		if (series.indexOf("(") == -1) return series;
		return series.split("[(]")[0];
	}
	public String getCountry() {
		return countryName;
	}
	
	public ArrayList<Integer> getYears() {
		return years;
	}
	
	// adds a new data point to the country, 
	// requires a year and data
	public void addDataPoint(int year, double newDatum) {
		years.add(year);
		data.add(newDatum);
	}
	
	// edit a data point for the country, 
	// requires year and new data
	public void editDataPoint(int year, double newDatum) {
		int index = years.indexOf(year);
		data.set(index, newDatum);
	}

}
