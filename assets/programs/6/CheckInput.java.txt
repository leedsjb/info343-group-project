/**
 *  Check the index before looking up an array element
 */

import javax.swing.*;

public class CheckInput{
	public static void main(String[] args){
    int [] a = {1,2,3};
    String input =
    JOptionPane.showInputDialog(null,
    "Enter an integer");
    int index = Integer.parseInt(input);
    if (index>=0 && index<=2)
      System.out.println(a[index]);
    else
      System.out.println("Invalid index");
    System.exit(0);
  }
}
