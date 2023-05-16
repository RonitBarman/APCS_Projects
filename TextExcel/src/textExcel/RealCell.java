package textExcel;
/*
 * @name Ronit Barman
 * @date Feb 21, 2023
 * 
 * Superclass for numerical cells
 * 
 */

public class RealCell implements Cell {
	
	private String value;
	public RealCell(String val) {
		value = val; 
	}
	public String abbreviatedCellText() {
		
		// check if the value needs to be padded with spaces
		if (value.length() >= 10) return value.substring(0, 10);
		else {
			String display = value;
			
			// pad with spaces for the necessary length
			for (int i = display.length(); i < 10; i++) display += " ";
			return display;
		}
	}

	@Override
	// return the full numeria value
	public String fullCellText() {
		return value;
	}
	
	// return the number as a double
	public double getDoubleValue() {
		return Double.parseDouble(value);
	}
	
	// return the String value of the numerical value
	public String getValue() {
		return value;
	}

}
