package Fields.ActiveFields;

import Controll.Controller;
import Controll.Szkeleton;

/**
 * Class for Spring
 * */
public class Spring extends ActiveFields{

    /**
     * The amount of water that the spring gives out. Default value is maxOutWater.
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
        this.waterOut = maxOutWater;
        this.maxOutWater = maxOutWater;
    }

    public int getWaterOut() { return waterOut; }

    public int getMaxOutWater() { return maxOutWater; }

    /**
     * Method for the game controlled events.
     * Give the water to the pipes.
     */
    @Override
    public void step() {
        for(int i = 0; i!= getPipes().size(); i++){
            waterOut = getPipes().get(i).fillInWater(waterOut);
            if(waterOut == 0){
                break;
            }
        }
    }

    @Override
    public String toString() {
        return "name: "+ Controller.objectReverseNames.get(this)
                + "\noccupied: " + this.isOccupied()
                + "\nwater: " + getWaterNoChange()
                + "\nbroken: " + this.isBroken()
                + "\nplayers: " + super.getPlayers()
                + "\npipes: " + super.getPipes()
                + "\nwaterOut: " + this.getWaterOut()
                + "\nmaxWaterOut: " + this.getMaxOutWater();
    }
}