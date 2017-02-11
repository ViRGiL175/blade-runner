package rape.brutal.bladerunner.beings;

import rape.brutal.bladerunner.crowd.Crowd;

/**
 * Created by ViRGiL7 on 10.02.2017.
 * Project: library-test
 * <p>
 * Average {@link Crowd} being
 */
public class Human extends Being {

    public static final String TAG = "Human";

    public Human(double humanity) {
        super(humanity);
    }

    @Override
    public void die() {
        say("I'm... A native...");
        Helper.longWait();
        super.die();
    }

    @Override
    public String getTag() {
        return TAG;
    }

}
