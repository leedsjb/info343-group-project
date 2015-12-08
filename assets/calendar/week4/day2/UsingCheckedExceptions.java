import java.util.Scanner;

public class UsingCheckedExceptions {

	public static void main(String[] args) {
		String[] names = { "Noel", "Azamat", "Aidana", "Ashley" };

		Scanner scan = new Scanner(System.in);
		String input;
		do {
			System.out.print("Enter an index (between 0 and "
					+ (names.length - 1) + ") or q to quit: ");
			input = scan.nextLine();
			if (!input.equals("q")) {
				try {
					int index = getIndex(input, names.length);
					System.out.println(names[index]);

				} catch (BadInputException e) {
					System.out.println("BadInputException was thrown: ");
					System.out.println(e.getMessage());
					for (StackTraceElement elt : e.getStackTrace()) {
						System.out.println(elt);
					}
				}
			}
		} while (!input.equals("q"));
		scan.close();
	}

	public static int getIndex(String input, int length)
			throws BadInputException {
		int index;
		try {
			index = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new BadInputException(
					"Input can't be parsed to an integer = " + input);
		}
		if (index >= 0 && index < length) {
			return index;
		} else {
			throw new BadInputException("Invalid index value = " + index);
		}
	}
}
