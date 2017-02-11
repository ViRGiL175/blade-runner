package rape.brutal.bladerunner.beings;

import rape.brutal.bladerunner.crowd.Crowd;
import rape.brutal.bladerunner.crowd.IContainable;
import rape.brutal.bladerunner.crowd.IContainer;

/**
 * Created by ViRGiL7 on 10.02.2017.
 * Project: library-test
 * <p>
 * Base class for all creations in {@link Crowd crowd}
 */
public abstract class Being implements IContainable {

    protected double humanity;
    private IContainer iContainer;

    public Being(double humanity) {
        setHumanity(humanity);
    }

    public double getHumanity() {
        return humanity;
    }

    /**
     * Allows only 0..1 humanity
     */
    public void setHumanity(double humanity) {
        this.humanity = Helper.rangeCheck(humanity);
    }

    protected void die() {
        Helper.printState(this, "dies");
        removeFromCrowd();
    }

    /**
     * Say phrase
     */
    public void say(String phrase) {
        System.out.println(getTag() + ": " + phrase + "\n");
        Helper.shortWait();
    }

    @Override
    public void registerIContainer(IContainer iContainer) {
        this.iContainer = iContainer;
    }

    @Override
    public void removeFromCrowd() {
        iContainer.remove(this);
    }

    public abstract String getTag();

}
