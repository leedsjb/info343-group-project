import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TMMain {

	public static void main(String[] args) {
		try {
			String fileName = "CrowtherRooms.txt"; // JavaReview.txt";
			Scanner scan = new Scanner(new File(fileName));
			boolean hasTitle = fileName.contains("Java");
			TMCourse course = TMCourse.readCourse(scan, hasTitle);
			scan.close();
			//System.out.println(course);
			course.run();
		} catch (FileNotFoundException e) {
			System.out.println("Couldn't read the input file!");
		}
	}
}
