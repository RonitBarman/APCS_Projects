package textExcel;
/*
 * @name Ronit Barman
 * @date Feb 21, 2023
 * 
 * Stores cell with no value
 * 
 */
public class EmptyCell implements Cell {

	public EmptyCell() {}
	
	@Override
	public String abbreviatedCellText() {
		return "          "; // return 10 spaces to fit inside the Spreadsheet
	}

	@Override
	public String fullCellText() {
		return ""; // EmptyCells have no cell text so return and empty string
	}
	
	

}
