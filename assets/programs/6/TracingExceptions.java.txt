import javax.swing.*;

/**
 *  Tracing the search for a catch block
 */
public class TracingExceptions {
    public static void main(String[] args){
      int[] a = {1,2,3};

      // User's input
      String input =
      JOptionPane.showInputDialog(null,"Enter the index of the element to print");

      // Print the array element with that index
      try{
        printElementWithString(a,input);
      }
      catch(ArrayIndexOutOfBoundsException e){
        System.out.println("Catch in main: problem printing a["+input+"]");
        // Trace where the exception was thrown
        e.printStackTrace();
      }

      // We are done
      System.out.println("End of main");
      System.exit(0);
  }

  public static void printElementWithString(int[] a, String input){
    try{
      // can throw IllegalNumberException
      int index = Integer.parseInt(input);
      printElementWithInt(a,index);
    }
    catch(NumberFormatException e){
      System.out.println("Bad input="+input);
    }

    System.out.println("End of printElement");
  }

  public static void printElementWithInt(int[] a, int index){
        System.out.println("a["+index+"]="+a[index]);
  }

}