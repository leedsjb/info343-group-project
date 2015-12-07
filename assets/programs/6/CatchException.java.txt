/**
 * When a thread sleeps, a checked exception
 * InterruptedException may be thrown
 */

public class CatchException extends Thread {

  private int sleepTime;

  public CatchException(String name, int n) {
    super(name);
    sleepTime = n;
  }

  public void run(){
    // Print the name 10 times
    int count = 0;
    while (count<10){
      // printName may throw and Exception
      // catch it here
      try{
        printName();
        count++;
      }
      catch(InterruptedException e){
        System.out.println(this.getName()+" has been interrupted");
      }
    }
  }

  private void printName() throws InterruptedException
  {
    // Thread.sleep may throw an InterruptedException
    // we must either catch the exception in the method
    // with a catch and try block
    // or say that the method may throw the exception
    // We chose the second option
    // The first option is illustrated in the run method
    System.out.println(this.getName()+" is working");
    Thread.sleep((int)(Math.random()*sleepTime));
  }

  public static void main(String[] args){
    CatchException t1 = new CatchException("One",100);
    t1.start();
    CatchException t2 = new CatchException("Two",100);
    t2.start();
  }
}
