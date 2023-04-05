package Fields.ActiveFields;

/**
 * Class for Spring
 * */
public class Spring extends ActiveFields{

    /**
     * The amount of water that the spring gives out. Default value is 0.
     */
    int waterOut = 0;
    /**
     * The maximum amount of water that the spring can give out.
     */
    int maxOutWater;

    /**
     * Constructor for Spring.
     * @param maxOutWater The maximum amount of water that the spring can give out.
     */
    public Spring(int maxOutWater) {
        this.maxOutWater = maxOutWater;
    }

    /**
     * Method for the game controlled events.
     * Give the water to the pipes.
     */
    @Override
    public void step() {
        super.step();
    }
}
