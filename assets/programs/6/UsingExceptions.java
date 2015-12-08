import javax.swing.*;

/**
 * Using the ArrayIndexOutOfBoundsException
 */

 public class UsingExceptions{
  public static void main(String[] args){
    int [] a = {1,2,3};
    String input=JOptionPane.showInputDialog(null,"Enter an integer");
    int index = Integer.parseInt(input);

    try{
      System.out.println(a[index]);
    }
    catch(ArrayIndexOutOfBoundsException e) {
      System.out.println("Invalid index");
    }

    System.exit(0);}
}
