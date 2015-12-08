import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * A description of a full course (title + questions)
 * 
 * @author CSC 143
 *
 */
public class TMCourse {
	private String title = "";
	private SortedMap<Integer, TMQuestion> questions = new TreeMap<Integer, TMQuestion>();

	// private constructor so that the user has to use a factory method
	// to create a course
	private TMCourse() {
	}

	// Reads a course from a file
	public static TMCourse readCourse(Scanner scan, boolean hasTitle) {
		TMCourse course = new TMCourse();
		if (hasTitle) {
			course.title = scan.nextLine();
		}
		while (scan.hasNextLine()) {
			TMQuestion q = TMQuestion.readQuestion(scan, hasTitle);
			course.questions.put(q.getNumber(), q);
		}
		return course;
	}

	// gets answers from the user and moves to the next question
	public void run() {
		Scanner scan = new Scanner(System.in);
		TMQuestion current = questions.get(questions.firstKey());
		do {
			// text of the question
			System.out.println(current.getText());
			System.out.print("> ");
			// get the answer from the user
			String answer = scan.nextLine();
			Integer next = current.getNextQuestion(answer);
			if (next == null) {
				System.out.println("I don't understand");
			} else if (next > 0) {
				current = questions.get(next);
			} else {
				break;
			}
		} while (true);
		scan.close();
	}

	@Override
	public String toString() {
		String s = title + "\n";
		for (Integer key : questions.keySet()) {
			s += questions.get(key); // toString in TMQuestion is automatically
										// called
			s += "\n";
		}
		return s;
	}
}
