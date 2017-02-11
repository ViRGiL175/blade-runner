package rape.brutal.bladerunner.crowd;

import com.sun.istack.internal.Nullable;
import rape.brutal.bladerunner.beings.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Created by ViRGiL7 on 11.02.2017.
 * Project: library-test
 *
 * @version 0.01
 */
public class Crowd implements IContainer {

    public static final double REPLICANT_PROBABILITY = 0.9;
    private final Random random;
    private ArrayList<Being> beingArrayList;

    /**
     * Create new crowd of maxBeings count of {@link Being beings}.
     * <p>
     * Uses {@link Crowd#REPLICANT_PROBABILITY replicant probability} to generate {@link Replicant replicants} from
     * {@link Human humans}.
     * <p>
     * Make demographic report and register all beings with {@link IContainer container} interface.
     */
    public Crowd(int maxBeings) {

        beingArrayList = new ArrayList<>();
        random = new Random();
        double replicantsFactor = random.nextDouble() * REPLICANT_PROBABILITY;
        int replicantsAmount = (int) (replicantsFactor * maxBeings);

        for (int i = 0; i < maxBeings; i++) {
            beingArrayList.add(new Human(random.nextDouble()));
        }

        for (int i = 0; i < replicantsAmount; i++) {
            beingArrayList.set(i, Replicator.replicate((Human) beingArrayList.get(i)));
        }
        Collections.shuffle(beingArrayList);

        Helper.inform("Welcome to the New Detroit!");
        crowdReport();
        registerAllBeings();
    }

    /**
     * Register all beings with {@link IContainer container} interface.
     */
    private void registerAllBeings() {
        for (Being being : beingArrayList) {
            being.registerIContainer(this);
        }
        Helper.inform("Sitizens was registered");
    }

    /**
     * Return random {@link Being being} from the crowd
     */
    @Nullable
    public Being getRandomBeing() {
        return beingArrayList.get(random.nextInt(beingArrayList.size() - 1));
    }

    /**
     * Remove {@link Being being} from the crowd
     */
    @Override
    public void remove(Being being) {
        beingArrayList.remove(being);
        beingArrayList.trimToSize();
    }

    /**
     * Make demographic report
     */
    public void crowdReport() {
        Helper.inform("Demographic inform");
        if (beingArrayList.size() <= 15) {
            Helper.inform("Low populated region: " + beingArrayList.size() + getMeasurement());
            for (Being being : beingArrayList) {
                System.out.println(being.getTag());
                Helper.tinyWait();
            }
        } else {
            Helper.inform("High populated region " + beingArrayList.size() + getMeasurement());
            Helper.inform(String.valueOf(beingArrayList.size()));
        }
        System.out.println();
    }

    private String getMeasurement() {
        return " (being" + (beingArrayList.size() != 1 ? "s" : "") + ")";
    }
}
