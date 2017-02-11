package rape.brutal.bladerunner.crowd;

/**
 * Created by ViRGiL7 on 11.02.2017.
 * Project: library-test
 */
public interface IContainable {

    /**
     * Callback to remove this from crowd
     */
    void removeFromCrowd();

    /**
     * Register crowd for this being
     *
     * @param iContainer container crowd
     */
    void registerIContainer(IContainer iContainer);

}

