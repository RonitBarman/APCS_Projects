package textExcel;
/*
 * @name Ronit Barman
 * @date Feb 21, 2023
 * 
 * Stores percentages in cells
 * 
 */
public class PercentCell extends RealCell {

	public PercentCell(String val) {
		super(val); // call parent constructor
	}
	
	@Override
	public String abbreviatedCellText() {
		String num = Integer.toString((int) getDoubleValue()) + "%";
		
		// check if the value needs to be padded with spaces
		if (num.length() >= 10) return num.substring(0, 10);
		else {
			// pad with spaces for the necessary length
			String display = num;
			for (int i = display.length(); i < 10; i++) display += " ";
			return display;
		}
	}
	
	@Override
	public double getDoubleValue() {
		// parse the String without looking at the %
		String num = getValue().substring(0, getValue().length()-1);
		return Double.parseDouble(num);
	}
	
	@Override
	public String fullCellText() {
		// return the decimal form of the percent
		return Double.toString(getDoubleValue() / 100.);
	}

}
