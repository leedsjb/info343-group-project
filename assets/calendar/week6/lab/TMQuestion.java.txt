import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * One question in the list of questions used by the teaching machine
 * 
 * @author CSC 143
 *
 */
public class TMQuestion {
	// A question is defined by its number, text of the question and list of
	// possible answers
	private int number;
	private List<String> text = new ArrayList<String>();
	private Map<String, Integer> answers = new HashMap<String, Integer>();

	public static final String DELIMITER = "-----";
	public static final String ANSWER_SEPARATOR1 = ":";
	public static final String ANSWER_SEPARATOR2 = "\\s+";

	// private constructor so that it can't be used outside of the class
	private TMQuestion() {
	}

	// to create a question, a user of the class will use the factory method
	// below
	public static TMQuestion readQuestion(Scanner scan, boolean hasTitle) {
		TMQuestion q = new TMQuestion();
		// read the contents of the question from the file
		q.number = scan.nextInt();
		// skip the new line after the integer in the file
		scan.nextLine();
		String line;
		while (!(line = scan.nextLine()).equals(DELIMITER)) {
			q.text.add(line);
		}
		while (scan.hasNextLine()
				&& (line = scan.nextLine()).trim().length() > 0) {
			String[] parts;
			if (hasTitle) {
				parts = line.split(ANSWER_SEPARATOR1);
			} else {
				parts = line.split(ANSWER_SEPARATOR2);
			}
			// if line is "yes: 0",
			// parts = {"yes", " 0"}
			// if parts[1] is "12/LAMP", change it to 12
			if (parts[1].contains("/")) {
				parts[1] = parts[1].substring(0, parts[1].indexOf("/"));
			}
			q.answers.put(parts[0].trim(), Integer.parseInt(parts[1].trim()));
		}
		return q;
	}

	/**
	 * Returns a string description of the question
	 */
	@Override
	public String toString() {
		String fullText = number + "\n";
		for (String line : text) {
			fullText += line + "\n";
		}
		fullText += DELIMITER + "\n";
		for (String key : answers.keySet()) {
			fullText += key + ANSWER_SEPARATOR1 + " " + answers.get(key) + "\n";
		}
		return fullText;
	}

	/**
	 * Returns the number of the question
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * Returns the text of the question
	 */
	public String getText() {
		String s = "";
		for (String line : text) {
			s += line + "\n";
		}
		return s;
	}

	// given an answer, returns the number of the next question
	public Integer getNextQuestion(String answer) {
		if (answers.containsKey(answer.trim())) {
			return answers.get(answer.trim());
		}
		return null; // if the answer is not one of the expected answers
	}
}
