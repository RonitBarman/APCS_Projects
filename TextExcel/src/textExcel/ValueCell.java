package textExcel;
/*
 * @name Ronit Barman
 * @date Feb 21, 2023
 * 
 * Stores numerical values
 * 
 */

public class ValueCell extends RealCell {
	
	// call super constructor to store the numerical value
	public ValueCell(String val) {
		super(val);
	}
	
	@Override
	public String abbreviatedCellText() {
		// use super method to getDoubleValue()
		String value = Double.toString(getDoubleValue());
		
		// check if the value needs to be padded with spaces
		if (value.length() >= 10) return value.substring(0, 10);
		else {
			// pad with spaces for the necessary length
			String display = value;
			for (int i = display.length(); i < 10; i++) display += " ";
			return display;
		}
	}



}
