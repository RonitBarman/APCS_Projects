package textExcel;
/*
 * @name Ronit Barman
 * @date Feb 21, 2023
 * Store the Location of a Spreadsheet so it is easy to access
 * 
 */


public class SpreadsheetLocation implements Location
{
	private String cellName;
    @Override
    public int getRow()
    {
    	// get the row value by parsing the number
    	int row = 0;
    	if (cellName.length() > 2) row = Integer.parseInt(cellName.substring(1)) - 1;
    	else row = cellName.charAt(1) - '1';
        return row;
    }

    @Override
    public int getCol()
    {
    	// return the col by subtracting 'A'
    	int col = cellName.charAt(0) - 'A';
        return col;
    }
    
    public SpreadsheetLocation(String cellName)
    {
    	// format the cellName
    	this.cellName = cellName.toUpperCase();
    }

}
