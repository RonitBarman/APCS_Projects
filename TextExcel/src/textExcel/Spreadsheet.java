package textExcel;
/*
 * @name Ronit Barman
 * @date Feb 21, 2023
 * 
 * Implement the spreadsheet class with all required features.
 */

import java.util.Arrays;

public class Spreadsheet implements Grid
{
	private Cell[][] sheet;
	public Spreadsheet() {
		// initialize with all EmptyCell()
		sheet = new Cell[getRows()][getCols()];
		for (int i = 0; i < getRows(); i++) {
			for (int j = 0; j < getCols(); j++) {
				sheet[i][j] = new EmptyCell();
			}
		}
		
	}

	@Override
	public String processCommand(String command)
	{
		// determine which type of command the user has typed
		if (command.length() <= 3) {
			return inspect(command);
		} else if (command.indexOf("=") != -1) {
			assign(command);
		} else if (command.toLowerCase().indexOf("clear") != -1) {
			if (command.length() == 5) clear();
			else {
				clear(command.split(" ")[1]);
			}
		}
		return getGridText();
	}
	
	// assign a given value to a given cell
	private void assign(String command) {
		SpreadsheetLocation loc = new SpreadsheetLocation(
			command.substring(0, command.indexOf(" "))
		);
		
		// if the command contains " then create a textcell
		if (command.indexOf("\"") != -1) {
			String value = command.substring(
					command.indexOf("\""),
					command.lastIndexOf("\"") + 1
			);
			sheet[loc.getRow()][loc.getCol()] = new TextCell(value);
		} else {
			// split the command on = to get the cell location and the value
			String[] parts = command.split(" = ");
			
			// determine the what type of RealCell is there
			if (parts[1].indexOf("(") != -1) {
				// create a formula cell if the command contains (
				sheet[loc.getRow()][loc.getCol()] = new FormulaCell(parts[1], this);
			} else if (parts[1].indexOf("%") != -1) {
				// create a formula cell if the command contains %
				sheet[loc.getRow()][loc.getCol()] = new PercentCell(parts[1]);
			} else {
				// create a value cell otherwise
				sheet[loc.getRow()][loc.getCol()] = new ValueCell(parts[1]);
			}
		}
		
		
	}
	
	// check whether a string can be parsed as a Double
	public static boolean isDouble(String s) {
		try {
			Double.parseDouble(s);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
	
	// return the full cell text for the inspect command
	private String inspect(String location) {
		SpreadsheetLocation loc = new SpreadsheetLocation(location);
		return getCell(loc).fullCellText();
	}
	
	// reset the given location to an EmptyCell to clear it
	private void clear(String location) {
		SpreadsheetLocation loc = new SpreadsheetLocation(location);
		sheet[loc.getRow()][loc.getCol()] = new EmptyCell();
	}
	
	// clear the whole Spreadsheet by filling it with EmptyCell
	private void clear() {
		for (int i = 0; i < getRows(); i++) {
			for (int j = 0; j < getCols(); j++) {
				sheet[i][j] = new EmptyCell();
			}
		}
	}
	
	@Override
	// return the number of rows in the spreadsheet
	public int getRows()
	{
		return 20;
	}

	@Override
	// return the number of columns in the spreadsheet
	public int getCols()
	{
		return 12;
	}

	@Override
	 // return a single cell based on location
	public Cell getCell(Location loc)
	{
		return sheet[loc.getRow()][loc.getCol()];
	}

	@Override
	// return a String with the full spreadsheet and values
	public String getGridText()
	{
		String fullsheet = "";
		fullsheet += "   |";
		
		// create the header
		for (char c = 'A'; c <= 'L'; c++) {
			fullsheet += c + "         |";
		}
		fullsheet += "\n";
		
		// generate the rows and add the separators between the text
		for (int i = 0; i < getRows(); i++) {
			if (i >= 9) fullsheet += (i + 1) + " |";
			else fullsheet += (i + 1) + "  |";
			
			for (int j = 0; j < getCols(); j++) {
				fullsheet += sheet[i][j].abbreviatedCellText() + "|";
			}
			fullsheet += "\n";
		}
		return fullsheet;
	}

}
