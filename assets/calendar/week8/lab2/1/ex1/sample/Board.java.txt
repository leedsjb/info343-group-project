/**
 * A simple representation of a square chess board
 * 
 * @author CSC 143
 * 
 */
public class Board {

	// size of the board (made of size x size squares)
	private int size;

	// the queens currently on the board
	private Location[] queen;

	// Current number of queens
	private int nQueens = 0;

	/**
	 * Creates a board of a given size
	 * 
	 * @param size
	 *            the size of the board
	 */
	public Board(int size) {
		if (size <= 0) {
			throw new IllegalArgumentException("Invalid board size = " + size);
		}
		this.size = size;
		queen = new Location[size];
	}

	/**
	 * Gets the size of the board
	 */
	public int size() {
		return size;
	}

	/**
	 * Prints the board to System.out
	 */
	public void print() {
		char[][] display = new char[size][size];
		for (int r = 0; r < display.length; r++) {
			for (int c = 0; c < display[r].length; c++) {
				display[r][c] = '_';
			}
		}
		for (Location q : queen) {
			if (q != null) {
				display[q.row - 1][q.col - 1] = 'Q';
			}
		}
		for (int r = 0; r < display.length; r++) {
			for (int c = 0; c < display[r].length; c++) {
				System.out.print(display[r][c] + " ");
			}
			System.out.println();
		}
	}

	/**
	 * Adds a queen on the board at the given location
	 * 
	 * @param row
	 *            the row of the location
	 * @param location
	 *            the column of the location
	 */
	public void add(int row, int col) {
		if (row < 1 || row > size || col < 1 || col > size) {
			throw new IllegalArgumentException("Invalid row or column = ("
					+ row + ", " + col + ")");
		}
		Location loc = new Location(row, col);
		// can't add if there is already a queen there
		for (int i = 0; i < nQueens; i++) {
			if (loc.equals(queen[i])) {
				throw new IllegalArgumentException("Square = (" + row + ", "
						+ col + ")" + " is already occupied.");
			}
		}
		queen[nQueens++] = new Location(row, col);
	}

	/**
	 * Removes a queen on the board from the given location
	 * 
	 * @param row
	 *            the row of the location
	 * @param location
	 *            the column of the location
	 */
	public void remove(int row, int col) {
		if (row < 1 || row > size || col < 1 || col > size) {
			throw new IllegalArgumentException("Invalid row or column = ("
					+ row + ", " + col + ")");
		}
		Location loc = new Location(row, col);
		// can't remove if there no queen there
		for (int i = 0; i < nQueens; i++) {
			if (loc.equals(queen[i])) {
				queen[i] = null;
				nQueens--;
				return;
			}
		}
		throw new IllegalArgumentException("Square = (" + row + ", " + col
				+ ")" + " is empty.");
	}

	/**
	 * Returns true if a queen that would be placed at the given location cannot
	 * be taken by the queens already placed on the chess board. Returns false
	 * otherwise
	 * 
	 * @param row
	 *            the row of the location
	 * @param location
	 *            the column of the location
	 */
	public boolean cannotBeTaken(int row, int col) {
		for (int k = 0; k < nQueens; k++) {
			if (row == queen[k].row // same row
					|| col == queen[k].col // same column
					|| (row - queen[k].row == col - queen[k].col)
					// on the same first diagonal
					|| (row - queen[k].row == -col + queen[k].col))
			// on the same second diagonal
			{
				return false;
			}
		}
		return true;
	}

	/**
	 * A location on the chess board
	 */
	private class Location {

		// row of this location
		public int row;

		// column of this location
		public int col;

		/**
		 * Creates a location given its row and column
		 * 
		 * @param theRow
		 *            the row of the location
		 * @param theCol
		 *            the column of the location
		 */
		public Location(int theRow, int theCol) {
			row = theRow;
			col = theCol;
		}

		/**
		 * Returns a string representation of this location
		 * 
		 * @return a string representation of this location
		 */
		public String toString() {
			return "(" + row + ", " + col + ")";
		}

		/**
		 * Returns true if this location is equal to the given object
		 */
		public boolean equals(Object o) {
			if (o != null && o.getClass() == this.getClass()) {
				Location loc = (Location) o;
				return (loc.row == row && loc.col == col);
			} else {
				return false;
			}
		}
	}

}
