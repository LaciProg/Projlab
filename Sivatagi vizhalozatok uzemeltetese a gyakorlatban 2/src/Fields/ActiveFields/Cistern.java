package Fields.ActiveFields;

import Controll.Szkeleton;
import Fields.Pipe;
import Players.Player;

/**
 * Class for Cistern
 * */
public class Cistern extends ActiveFields{

    /**
     * Water stored in the cistern. Default value is 0.
     */
    private int waterStored;

    /**
     * Constructor for the cistern.
     */
    public Cistern() {
        Szkeleton.printTabs();
        System.out.println("new Cistern()");
        this.waterStored = 0;
    }

    /**
     * Method for the game controlled events.
     * Gets the water from the pipes and stores it.
     * Creates a new pipe
     */
    @Override
    public void step() {
        Szkeleton.printTabs();
        System.out.println(Szkeleton.objectNames.get(this)+ ".step()");
        Szkeleton.tabs++;
        getPipes().get(0).getWater();
        Szkeleton.tabs--;
        super.step();
    }

    /**
     * Method for creating a new pump.
     * @param b True if the player get a new pump.
     * @return The new pump.
     * */
    @Override
    public Pump createNewPump(boolean b) {
        Szkeleton.printTabs();
        System.out.println(Szkeleton.objectNames.get(this)+ ".createNewPump()");
        Pump newPump = new Pump();
        Szkeleton.objectNames.put(newPump, "newPump");
        return newPump;
    }

    /**
     * Method for getting the water from the field.
     * @return The amount of water in the field.
     */
    @Override
    public int getWater() {
        Szkeleton.printTabs();
        System.out.println(Szkeleton.objectNames.get(this)+ ".getWater()");
        return super.getWater(); //TODO
    }

    /**
     * Method for picking up a (new) pipe from the field.
     * @return The new pipe.
     */
    @Override
    public Pipe pickUpPipe() {
        Szkeleton.printTabs();
        System.out.println(Szkeleton.objectNames.get(this)+ ".pickUpPipe()");
        return super.pickUpPipe(); //TODO
    }
}
