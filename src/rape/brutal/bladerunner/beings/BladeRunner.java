package rape.brutal.bladerunner.beings;

import com.sun.istack.internal.Nullable;
import rape.brutal.bladerunner.crowd.Crowd;

/**
 * Created by ViRGiL7 on 10.02.2017.
 * Project: library-test
 * <p>
 * The use of {@link Replicant replicants} on Earth is banned and they are exclusively utilized for dangerous or menial work on
 * off-world colonies.
 * <p>
 * Replicants who defy the ban and return to Earth are hunted down and killed ("retired") by special police operatives
 * known as "Blade Runners".
 * <p>
 * To make job done Blade Runner should:
 * <p>
 * - {@link BladeRunner#findStrangeBeing(Crowd) find} suspect
 * <p>
 * - {@link BladeRunner#makeTuringTest(Being) make turing test} for suspect
 * <p>
 * - profit
 */
public class BladeRunner extends Being implements IDieable {

    private static final String TAG = "Blade runner";

    private final String name;
    private double intelligence;
    private IDieReceiver iDieReceiver;

    /**
     * Creates new Blade Runner with name, humanity and intelligence
     *
     * @param humanity     should be 0..1
     * @param intelligence should be 0..1
     */
    public BladeRunner(String name, double humanity, double intelligence, IDieReceiver iDieReceiver) {
        super(humanity);
        this.intelligence = Helper.rangeCheck(intelligence);
        this.name = name;
        setDieReceiver(iDieReceiver);
        Helper.printState(this, "is a Blade Runner");
        Helper.printState(this, "should find and \"retire\" replicants");
        Helper.printState(this, "has " + humanity + " humanity, " + intelligence + " intelligence");
        say("Another dark day, another rain, still the same...");
        Helper.printState(this, "diapers in crowd");
    }

    @Nullable
    public Being findStrangeBeing(Crowd crowd) {
        Being randomBeing = crowd.getRandomBeing();
        if (randomBeing != null) {
            Helper.printState(this, "finds strange looking person");
        }
        return randomBeing;
    }

    public void makeTuringTest(Being being) {
        Helper.printState(this, "unpack Turing testing device");
        say("Good night. Can I ask couple of questions?");
        say("It does not take much of your time...");
        being.say("Alright...");
        Helper.printState(this, "start testing");
        Helper.inform("Being has " + being.getHumanity() + " humanity");
        if (being.getHumanity() <= intelligence) {
            tryToExecute(being);
        } else {
            say("Nice to meet natural human in this dark future days...");
            Helper.printState(this, "walks away");
        }
    }

    private void tryToExecute(Being being) {
        say("Now you will die, replicant...");
        switch (being.getTag()) {
            case Human.TAG:
                fight((Human) being);
                break;
            case Replicant.TAG:
                fight((Replicant) being);
                break;
            case BladeRunner.TAG:
                fight((BladeRunner) being);
            default:
                Helper.printState(this, "dies in fight with unknown enemy");
                this.die();
        }
//        if (being.getClass() == Human.class) {
//            fight((Human) being);
//        } else if (being.getClass() == Replicant.class) {
//            fight((Replicant) being);
//        } else {
//            Helper.printState(this, "dies in fight with unknown enemy");
//            this.die();
//        }
    }

    private void fight(BladeRunner bladeRunner) {
        if (this.intelligence - this.humanity > bladeRunner.intelligence - bladeRunner.humanity) {
            bladeRunner.die();
        } else {
            this.die();
        }
    }

    private void fight(Replicant replicant) {
        if (intelligence - replicant.getHumanity() > humanity) {
            say("You can't double cross me, thing!");
            Helper.printState(this, "shot precisely in replicant's head");
            replicant.die();
        } else {
            Helper.printState(this, "fights brave");
            replicant.say("Only human...");
            Helper.printState(replicant, "tears " + this.getTag() + " apart");
            this.brutalDie();
        }
    }

    private void fight(Human human) {
        human.say("No! There is an mistake!");
        say("Good try. You're looks like native...");
        Helper.printState(this, "shot precisely in human's head");
        human.die();
    }

    @Override
    protected void die() {
        Helper.printState(this, "dies");
        onDie();
    }

    private void onDie() {
        iDieReceiver.onBladeRunnerDies();
    }

    private void brutalDie() {
        say("Adgh...");
        Helper.printState(this, "try to grab his legs");
        Helper.printState(this, "vomit with blood");
        die();
    }

    /**
     * Say phrase with Blade Runner personality
     */
    @Override
    public void say(String phrase) {
        System.out.println(name + ": " + phrase + "\n");
        Helper.shortWait();
    }

    @Override
    public String getTag() {
        return TAG;
    }

    public String getName() {
        return name;
    }

    @Override
    public void setDieReceiver(IDieReceiver iDieReceiver) {
        this.iDieReceiver = iDieReceiver;
    }
}

