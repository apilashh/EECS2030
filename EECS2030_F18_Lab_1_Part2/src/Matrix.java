
/**
 * <p> A Matrix has two dimensions: rows and columns. Each cell in the matrix
 * stores an integer value, and it can be uniquely identified via 
 * a row number and a column number. 
 * Row numbers start with 0 and column numbers start with 0. 
 * <p> For simplicity, you can assume that all row and column numbers passed by
 * users are valid. 
 */
public class Matrix {
	
	/*
	 * You must use this attribute 'imp' to implement
	 * the various methods of the Matrix class.
	 * Do not change any parts of this attribute declaration.
	 */
	int[][] imp;
	
	/**
	 * <p> Initialize a 1-by-1 matrix with default values.
	 * <p> See TestMatrix class for how this method can be used. 
	 */
	public Matrix() {
		imp = new int[1][1];
	}
	
	/**
	 * <p> Initialize a 'nor'-by-'noc' matrix, where each cell 
	 * <p> See TestMatrix class for how this method can be used. 
	 * stores the default integer value 0.
	 * @param nor Number of rows
	 * @param noc Number of columns
	 */
	public Matrix(int nor, int noc) {
		imp = new int[nor][noc];
	}
	
	/**
	 * <p> Initialize a 'nor'-by-'noc' matrix, where each cell 
	 * <p> See TestMatrix class for how this method can be used. 
	 * stores the default integer value 'v'.
	 * @param nor Number of rows
	 * @param noc Number of columns
	 * @param v Default value for each cell
	 */
	public Matrix(int nor, int noc, int v) {
		imp = new int[nor][noc];
		for(int i = 0; i < nor; i++) 
		{
			for(int j = 0; j < noc; j++)
			{
				imp[i][j] = v;
			}
		}		
	}
	
	/**
	 * <p> Get the number of rows in this matrix. 
	 * <p> See TestMatrix class for how this method can be used. 
	 * @return Number of rows
	 */
	public int getNumberOfRows() {
		return imp.length; 
	}
	
	/**
	 * <p> Get the number of columns in this matrix.
	 * <p> See TestMatrix class for how this method can be used. 
	 * @return Number of columns
	 */
	public int getNumberOfColumns() {
		return imp[0].length;
	}
	
	/**
	 * <p> Get the value stored at cell ('r', 'c').
	 * <p> You can assume that 'r' and 'c' are valid - no error checking is needed.
	 * <p> See TestMatrix class for how this method can be used.
	 * @param r Row number
	 * @param c Column number
	 * @return Value stored at cell ('r', 'c') 
	 */
	public int get(int r, int c) {
		return imp[r][c];
	}
	
	/**
	 * <p> Store value 'v' in cell ('r', 'c').
	 * <p> You can assume that 'r' and 'c' are valid - no error checking is needed.
	 * <p> See TestMatrix class for how this method can be used.
	 * @param r Row number
	 * @param c Column number
	 * @param v Value to be stored 
	 */
	public void set(int r, int c, int v) {
		imp[r][c] = v;
	}
	
	/**
	 * <p> Replace values of row 'r' by a the new row 'nr'.
	 * <p> You can assume the length of 'nr' equals the number of columns of this matrix -
	 * no error checking is needed for this. 
	 * <p> See TestMatrix class for how this method can be used.
	 * @param r Row number
	 * @param nr A new row (as an array of integers)
	 */
	public void setRow(int r, int[] nr) {
		for (int i = 0; i < nr.length; i++)
		{
			imp[r][i] = nr[i];
		}
	}
	
	/**
	 * <p> Replace values of column 'c' by a the new column 'nc'.
	 * <p> You can assume the length of 'nc' equals the number of rows of this matrix -
	 * no error checking is needed for this. 
	 * <p> See TestMatrix class for how this method can be used.
	 * @param c Column number
	 * @param nc A new column (as an array of integers)
	 */
	public void setColumn(int c, int[] nc) {
		for (int i = 0; i < nc.length; i++)
		{
			imp[i][c] = nc[i];
		}
	}
	
	/**
	 * <p> Return a copy of contents stored in row 'r'.
	 * <p> You can assume that 'r' is valid - no error checking is needed.
	 * <p> See TestMatrix class for how this method can be used.
	 * @param r Row number
	 * @return A new array whose contents correspond to those of row 'r'.
	 */
	public int[] getRow(int r) {
		int[]row = new int [imp[r].length];
		
		for (int i = 0; i < imp[r].length; i++)
		{
			row[i] = imp[r][i];
		}
		return row;
	}
	
	/**
	 * <p> Return a copy of contents stored in column 'c'.
	 * <p> You can assume that 'c' is valid - no error checking is needed.
	 * <p> See TestMatrix class for how this method can be used.
	 * @param c Column number
	 * @return A new array whose contents correspond to those of column 'c'.
	 */
	public int[] getColumn(int c) {
		int []col = new int[imp.length];
		for (int i = 0; i < imp.length; i++)
		{
			col[i] = imp[i][c];
		}
		
		return col;
	}
	
	/**
	 * <p> Rotate the matrix by 90 degrees.
	 * <p> The old 1st row becomes the new last column, 
	 *     the old 2nd row becomes the new 2nd last column, and so on.
	 * <p> Hint: attribute 'imp' should be reassigned to a new matrix. 
	 * <p> See TestMatrix class for how this method can be used.
	 */
	public void rotateClockwise() {
		int[][]x = new int[imp[0].length][imp.length];
		
		for (int i = 0; i < imp.length; i++)
		{
			for (int j = 0; j < imp[0].length; j++)
			{
				x[j][imp.length - 1 - i] = imp[i][j];
			}
		}
		imp = x; 
	}
	
	/**
	 * <p> Shift this matrix to the left by one column. 
	 * <p> The old 2nd column becomes the new 1st column, 
	 *     the old 3rd column becomes the new 2nd column, ...,
	 *     the old 1st column becomes the new last column. 
	 * <p> See TestMatrix class for how this method can be used.
	 */
	public void shiftLeft() {
		int [][]x = new int [imp.length][imp[0].length];
		
		for (int i = 0; i < imp.length; i++)
		{
			for (int j = 0; j < imp[0].length; j++)
			{
				if (j == 0) 
					x[i][imp[0].length - 1]= imp[i][j];
				else 
					x[i][j - 1] = imp[i][j];
			}
		}
		
		imp = x;
	}
	
	/**
	 * <p> Shift this matrix up by one row. 
	 * <p> The old 2nd row becomes the new 1st row, 
	 *     the old 3rd row becomes the new 2nd row, ...,
	 *     the old 1st row becomes the new last row.
	 * <p> See TestMatrix class for how this method can be used.
	 */
	public void shiftUp() {
		int [][]x = new int [imp.length][imp[0].length];
		
		for (int i = 0; i < imp.length; i++)
		{
			for (int j = 0; j < imp[0].length; j++)
			{
				if (i==0) 
					x[imp.length - 1][j]= imp[i][j];
				else 
					x[i - 1][j] = imp[i][j];
			}
		}
		imp = x;
	}
}
