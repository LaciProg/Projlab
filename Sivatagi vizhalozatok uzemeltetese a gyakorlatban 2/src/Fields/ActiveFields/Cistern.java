package Fields.ActiveFields;

import Fields.Pipe;

/**
 * Class for Cistern
 * */
public class Cistern extends ActiveFields{

    /**
     * Water stored in the cistern. Default value is 0.
     */
    private int waterStored = 0;

    /**
     * Method for the game controlled events.
     * Gets the water from the pipes and stores it.
     * Creates a new pipe
     */
    @Override
    public void step() {
        super.step();
    }

    /**
     * Method for creating a new pump.
     * @param b True if the player get a new pump.
     * @return The new pump.
     * */
    @Override
    public Pump createNewPump(boolean b) {
        return super.createNewPump(b);
    }

    /**
     * Method for getting the water from the field.
     * @return The amount of water in the field.
     */
    @Override
    public int getWater() {
        return super.getWater();
    }

    /**
     * Method for picking up a (new) pipe from the field.
     * @return The new pipe.
     */
    @Override
    public Pipe pickUpPipe() {
        return super.pickUpPipe();
    }
}
