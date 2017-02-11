package rape.brutal.bladerunner.beings;

/**
 * Created by ViRGiL7 on 10.02.2017.
 * Project: library-test
 * <p>
 * Strange tech for {@link Replicant} creation from {@link Human}
 */
public class Replicator {

    public static Replicant replicate(Human human) {
        return new Replicant(human);
    }

}
