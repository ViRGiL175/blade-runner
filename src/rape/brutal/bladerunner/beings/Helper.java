package rape.brutal.bladerunner.beings;

import rape.brutal.bladerunner.crowd.Crowd;

import java.util.Random;

/**
 * Created by ViRGiL7 on 10.02.2017.
 * Project: library-test
 */
public class Helper {

    /**
     * Checks 0..1 range
     *
     * @throws IllegalArgumentException if range is wrong
     */
    public static double rangeCheck(double value) {
        if ((value < 0.0) || (value > 1.0)) {
            throw new IllegalArgumentException("Humanity should been between 0.0 and 1.0!");
        } else {
            return value;
        }
    }

    /**
     * Print state of {@link Being being}
     */
    public static void printState(Being being, String state) {
        System.out.println("* " + being.getTag() + " " + state + " *\n");
        shortWait();
    }

    /**
     * Print state of {@link BladeRunner bladeRunner}
     */
    public static void printState(BladeRunner bladeRunner, String state) {
        System.out.println("* " + bladeRunner.getName() + " " + state + " *\n");
        shortWait();
    }

    /**
     * Print {@link Crowd crowd} inform
     */
    public static void inform(String info) {
        System.out.println("* " + info + " *\n");
        longWait();
    }

    private static void sleep(int millis) throws InterruptedException {
        Thread.sleep(millis + new Random().nextInt(500));
    }

    public static void shortWait() {
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void longWait() {
        try {
            sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void tinyWait() {
        try {
            sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
