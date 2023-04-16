package Fields.ActiveFields;

import Controll.Szkeleton;

/**
 * Class for Spring
 * */
public class Spring extends ActiveFields{

    /**
     * The amount of water that the spring can give out. Max value is maxOutWater.
     */
    int waterOut;
    /**
     * The maximum amount of water that the spring can give out.
     */
    final int maxOutWater;

    /**
     * Constructor for Spring.
     * @param maxOutWater The maximum amount of water that the spring can give out.
     */
    public Spring(int maxOutWater) {
        Szkeleton.printTabs();
        System.out.println("new Spring()");
        this.waterOut = maxOutWater;
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
        waterOut = maxOutWater;

        for(int i = 0; i != getPipes().size(); i++){
            waterOut = getPipes().get(i).fillInWater(waterOut);
            if(waterOut == 0){
                break;
            }
        }

        Szkeleton.tabs--;
    }
}