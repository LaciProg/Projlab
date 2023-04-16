package Fields.ActiveFields;

import Controll.Szkeleton;
import Players.Player;

/**
 * Class for Spring
 * */
public class Spring extends ActiveFields{

    /**
     * The amount of water that the spring gives out. Default value is 0.
     */
    int waterOut;
    /**
     * The maximum amount of water that the spring can give out.
     */
    int maxOutWater;

    /**
     * Constructor for Spring.
     * @param maxOutWater The maximum amount of water that the spring can give out.
     */
    public Spring(int maxOutWater) {
        Szkeleton.printTabs();
        System.out.println("new Spring()");
        this.waterOut = 0;
        this.maxOutWater = maxOutWater;
    }

    /**
     * Method for the game controlled events.
     * Give the water to the pipes.
     */
    @Override
    public void step() {
        Szkeleton.printTabs();
        System.out.println(Szkeleton.objectNames.get(this)+ ".step()");
        Szkeleton.tabs++;
        getPipes().get(0).fillInWater(waterOut);
        Szkeleton.tabs--;
        super.step();
    }
}