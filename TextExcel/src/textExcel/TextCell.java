package textExcel;
/*
 * @name Ronit Barman
 * @date Feb 21, 2023
 */
public class TextCell implements Cell {
	
	private String cellValue;
	
	// set the cell value
	public TextCell(String cellValue) {
		this.cellValue = cellValue.substring(
			cellValue.indexOf("\"") + 1,
			cellValue.lastIndexOf("\"")
		);
				
	}
	@Override
	public String abbreviatedCellText() {
		
		// check if the value needs to be padded with spaces
		if (cellValue.length() >= 10) return cellValue.substring(0, 10);
		else {
			String display = cellValue;
					
			// pad with spaces for the necessary length
			for (int i = display.length(); i < 10; i++) display += " ";
			return display;
		}
	}

	@Override
	public String fullCellText() {
		// surround with quotes for inspection
		return "\"" + cellValue + "\"";
	}

}
