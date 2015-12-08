import javax.swing.*;

/**
 *  Generating an ArrayOutOfBoundsException
 */
public class GeneratingAnException{
	public static void main(String[] args){
    int [] a = {1,2,3};
    String input =
    JOptionPane.showInputDialog(null,
    "Enter an integer");
    int index = Integer.parseInt(input);
    System.out.println(a[index]);
    System.exit(0);
  }
}
// What happens if index is not 0,1 or 2?

