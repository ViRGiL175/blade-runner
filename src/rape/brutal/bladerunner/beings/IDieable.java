package rape.brutal.bladerunner.beings;

/**
 * Created by ViRGiL7 on 11.02.2017.
 * Project: library-test
 * <p>
 * In case of character death
 * <p>
 * Object can send message about dying
 */
public interface IDieable {

    void setDieReceiver(IDieReceiver dieReceiver);

}
