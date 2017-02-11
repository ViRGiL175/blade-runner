package rape.brutal;

import rape.brutal.bladerunner.beings.Being;
import rape.brutal.bladerunner.beings.BladeRunner;
import rape.brutal.bladerunner.beings.Helper;
import rape.brutal.bladerunner.beings.IDieReceiver;
import rape.brutal.bladerunner.crowd.Crowd;

public class Main {

    public static void main(String[] args) {
        // write your code here
        new Game().play();
    }

}

class Game implements IDieReceiver {

    public void play() {
        Crowd crowd = new Crowd(10);
        BladeRunner bladeRunner = new BladeRunner("Isaac", 0.2, 0.7, this);

        for (int i = 0; i < 5; i++) {
            Being strangeBeing = bladeRunner.findStrangeBeing(crowd);
            if (strangeBeing == null) {
                bladeRunner.say("There are no one left...");
                break;
            }
            bladeRunner.makeTuringTest(strangeBeing);
            crowd.crowdReport();
        }

        bladeRunner.say("Hard night's morning.");
        bladeRunner.say("I'm alive...");
        bladeRunner.say("Yet...");
        bladeRunner.say("But is it a live..?");

        Helper.printState(bladeRunner, "disapears in morning shadows");
    }

    @Override
    public void onBladeRunnerDies() {
        System.exit(0);
    }
}