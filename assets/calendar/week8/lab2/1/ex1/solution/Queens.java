import java.util.Scanner;

/**
 * Finds a solution to the classical eight queen problem. Eight queens are
 * placed on a chess board so that no queen can take another queen in one move.
 * Where are they placed?
 */
public class Queens {

	// the board of the chess game
	private Board b;

	// to follow the recursive backtracking algorithm
	private StringBuffer s = new StringBuffer();

	/**
	 * Prints a solution of the eight queen problem
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean badInput = true;
		do {
			System.out.print("Size of the chess board: ");
			if (scan.hasNextInt()) {
				int size = scan.nextInt();
				if (size > 0) {
					badInput = false;
					new Queens(size);
				}
			} else {
				scan.nextLine();
			}
			if (badInput) {
				System.out.println("Invalid size value!");
			}
		} while (badInput);
	}

	/**
	 * 
	 * @param size
	 */

	public Queens(int size) {
		b = new Board(size);
		if (placeQueen(1, 1)) {
			b.print();
		} else {
			System.out.println("No solution!");
		}
	}

	/**
	 * Finds a location for the given queen so that it can't be taken by the
	 * queens already placed on the chess board. Returns true if that queen and
	 * all next queens could be placed on the chess board, or false otherwise.
	 * 
	 * @param q
	 *            the number of the queen to place
	 * @param col
	 *            the column where the queen is placed
	 * @return true if all of the queens could be placed on the chess board, or
	 *         false otherwise.
	 */
	private boolean placeQueen(int q, int col) {
		// Base case:
		// all queens have been placed
		if (q > b.size()) {
			return true;
		}

		// Find a location for that queen
		boolean success = false;
		for (int r = 1; r <= b.size() && !success; r++) {
			if (b.cannotBeTaken(r, col)) {
				b.add(r, col);
				String toAdd = q + " ";
				s.append(toAdd);
				System.out.println(s);
				success = placeQueen(q + 1, col + 1);
				if (!success) { // backtrack
					b.remove(r, col);
					s.replace(s.length() - toAdd.length(), s.length(), "");
				}
			}
		}

		return success;
	}
}
