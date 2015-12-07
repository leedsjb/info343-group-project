/**
 * Test the classes Car and LawnMower
 */

public class Test
{
    /**
     * Create a Car and a LawnMower and drive them
     */
    public static void main(String[] args)
    {
        Car c = new Car();
        LawnMower lm = new LawnMower();
        drive(c);
        drive(lm);
    }

    /**
     * Drive a Driveable d
     */
    public static void drive(Driveable d)
    {
        d.start();
        System.out.println(d);
        d.cruise(50);
        System.out.println(d);
        d.turn(Direction.SOUTH);
        System.out.println(d);
        d.stop();
        System.out.println(d);
    }

}
