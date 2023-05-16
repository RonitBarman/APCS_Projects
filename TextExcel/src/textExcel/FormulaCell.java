package textExcel;
/*
 * @name Ronit Barman
 * @date Feb 21, 2023
 * 
 * Stores formulas in cells
 * 
 */

public class FormulaCell extends RealCell {
	private Spreadsheet sheet;
	
	// store the formula and spreadsheet to access other cells
	public FormulaCell(String val, Spreadsheet sheet) {
		super(val);
		this.sheet = sheet;
	}
	
	@Override
	public String abbreviatedCellText() {
		// convert to String to be displayed
		String value = Double.toString(getDoubleValue());
		
		// check if spaces need to be added
		if (value.length() >= 10) return value.substring(0, 10);
		else {
			// add the number of spaces necessary
			String display = value;
			for (int i = display.length(); i < 10; i++) display += " ";
			return display;
		}
	}
	
	@Override
	public double getDoubleValue() {
		// split the formula by spaces to get all components
		String[] formula = getValue().split(" ");
		
		// store whether the formula contains the SUM or AVG commands
		boolean issum = formula[1].equalsIgnoreCase("sum");
		boolean isavg = formula[1].equalsIgnoreCase("avg");
		if (issum || isavg) {
			// parse the locations and store them in an array
			String[] locs = formula[2].toUpperCase().split("-");
			
			// store the locations as SpreadsheetLocations
			SpreadsheetLocation startLoc = new SpreadsheetLocation(locs[0]);
			SpreadsheetLocation endLoc = new SpreadsheetLocation(locs[1]);
			
			// initialize the variables to store the sum and count of numbers
			double sum = 0.0;
			double count = 0.0;
			for (char c = locs[0].charAt(0); c <= locs[1].charAt(0); c++) {
				for (int j = startLoc.getRow(); j <= endLoc.getRow(); j++) {
					String temp = c + Integer.toString(j + 1);
					SpreadsheetLocation loc = new SpreadsheetLocation(temp);
					
					// cast the Cell to RealCell so you can use getDoubleValue()
					sum += ((RealCell) sheet
								.getCell(loc))
								.getDoubleValue();
					// increment count
					count++;
				}
			}
			
			// determine what to return based on function
			if (issum) return sum;
			else return sum / count;
			
		} else {
			// for normal formulas, parse the operations
			double answer = 1.;
			double numB = 1.;
			int count = 0;
			char operator = ' ';
			for (int i = 1; i < formula.length - 1; i++) {
				if (Spreadsheet.isDouble(formula[i])) {
					if (count == 0) {
						// if no other numbers have been seen
						// just store this one and move on
						answer = Double.parseDouble(formula[i]);
						count++;
						continue;
					}
					
					// if other numbers have been seen,
					// store the other number and complete the operation
					numB = Double.parseDouble(formula[i]);

				} else if (formula[i].length() >= 2) {
					// same logic as above, except we just get values from
					// RealCells to store the values for the operation
					if (count == 0) {
						answer = ((RealCell) sheet
								.getCell(new SpreadsheetLocation(formula[i])))
								.getDoubleValue();
						count++;
						continue;
					} 
					
					numB = ((RealCell) sheet
								.getCell(new SpreadsheetLocation(formula[i])))
								.getDoubleValue();
				} else {
					operator = formula[i].charAt(0);
					continue;
				}
				// if 2 numbers are stored, perform the desired operation
				if (count > 0) {
					if (operator == '*') answer *= numB;
					if (operator == '/') answer /= numB;
					if (operator == '-') answer -= numB;
					if (operator == '+') answer += numB;
				}
			
			}
			// answer stores the whole answer
			return answer;
		}
	}

}
