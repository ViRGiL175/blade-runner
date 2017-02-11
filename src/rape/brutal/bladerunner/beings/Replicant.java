package rape.brutal.bladerunner.beings;

import java.util.Random;

/**
 * Created by ViRGiL7 on 10.02.2017.
 * Project: library-test
 * <p>
 * Can be created only by {@link Replicator}
 */
public class Replicant extends Being {

    public static final String TAG = "Replicant";
    public static final double REPLICATION_QUALITY = 0.01;

    /**
     * Can be created only by {@link Replicator replicator}
     */
    Replicant(Human human) {
        super(human.getHumanity() - new Random().nextDouble() * human.getHumanity() * REPLICATION_QUALITY);
    }

    @Override
    public void die() {
        say("I've seen things you people wouldn't believe.");
        say("Attack ships on fire off the shoulder of Orion.");
        say("I've watched c-beams glitter in the dark near the Tannhäuser Gate.");
        say("All those... moments will be lost in time, like tears... in rain.");
        say("Time to die.");
        super.die();
    }

    @Override
    public String getTag() {
        return TAG;
    }
}
