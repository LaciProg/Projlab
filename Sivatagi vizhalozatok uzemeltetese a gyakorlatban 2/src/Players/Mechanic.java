package Players;

import Controll.Szkeleton;
import Fields.ActiveFields.ActiveFields;
import Fields.ActiveFields.Pump;
import Fields.Pipe;


/**
 * Class for the mechanic player.
 * */
public class Mechanic extends Player {

    /**
     *The pump that the mechanic is holding. Default is null.
     */
    private Pump holdingPump;
    /**
     *The pipe that the mechanic is holding. Default is null.
     */
    private Pipe holdingPipe;

    /**
     * Constructor for the mechanic.
     *  holdingPipe = null;
     *  holdingPump = null;
     */
    public Mechanic() {
        Szkeleton.printTabs();
        System.out.println("new Mechanic()");
        this.holdingPipe = null;
        this.holdingPump = null;
    }

    public void setHoldingPump(Pump holdingPump) {
        Szkeleton.printTabs();
        System.out.println(Szkeleton.objectNames.get(this)+ ".setHoldingPump()");
        this.holdingPump = holdingPump;
    }

    /**
     * Setter for the holdingPipe.
     * @param holdingPipe The pipe that the mechanic is holding.
     */
    public void setHoldingPipe(Pipe holdingPipe) { //Basic setter for the holdingPipe.
        Szkeleton.printTabs();
        System.out.println(Szkeleton.objectNames.get(this)+ ".setHoldingPipe()");
        this.holdingPipe = holdingPipe;
    }

    /**
     *Method for repairing the field where the player is standing.
     * @return boolean - returns true if the field is repaired.
     */
    @Override
    public boolean repair() {
        Szkeleton.printTabs();
        System.out.println(Szkeleton.objectNames.get(this)+ ".repair()");
        Szkeleton.tabs++;
        boolean result = getStandingField().repair();
        Szkeleton.tabs--;
        return result;
    }

    /**
     *Method for placing a pump on the field where the player is standing.
     * @return Pipe - The other (new) half of the pipe.
     */
    @Override
    public Pipe placePump() {
        Szkeleton.printTabs();
        System.out.println(Szkeleton.objectNames.get(this)+ ".placePump()");
        Szkeleton.tabs++;
        Pipe newPipe = getStandingField().placePump(holdingPump);
        Szkeleton.tabs--;
        return newPipe;
    }

    /**
     * Method for disconnecting a pipe from a pump.
     * @param p Pipe
     *          The pipe that will be disconnected.
     * @return boolean - returns true if the pipe is disconnected.
     */
    @Override
    public boolean disconnect(Pipe p) {
        Szkeleton.printTabs();
        Szkeleton.tabs++;
        System.out.println(Szkeleton.objectNames.get(this)+ ".disconnect()");
        boolean result = super.getStandingField().removePipe(p);
        boolean result2 = false;
		if(result) {
			result2 = p.disconnect((ActiveFields) super.getStandingField());
			if(result2) holdingPipe = p;
		}
		Szkeleton.tabs--;
		return result && result2;
    }
    
    /**
     * Method for connecting the holdingPipe to a pump.
     * @return boolean - returns true if the pipe is connected.
     */
    @Override
    public boolean connect() {
        Szkeleton.printTabs();
        Szkeleton.tabs++;
        System.out.println(Szkeleton.objectNames.get(this)+ ".connect()");
        if(holdingPipe == null) return false;
        boolean result = super.getStandingField().addPipe(holdingPipe);
		if(!result) return false;
		result = holdingPipe.connect((ActiveFields) super.getStandingField());
		Szkeleton.tabs--;
        return result;
    }

    /**
     * Method for getting a pump from the field where the player is standing.
     * @return Pump - The new pump.
     */
    @Override
    public Pump getPump() {
        Szkeleton.printTabs();
        System.out.println(Szkeleton.objectNames.get(this)+ ".getPump()");
        Szkeleton.tabs++;
        Pump newPump = getStandingField().createNewPump(true); // mechanic can get a new pump
        Szkeleton.tabs--;
        return newPump;
    }

    /**
     * Method for picking up a new pipe from the field where the player is standing.
     * @return boolean - returns true if the pipe is picked up.
     */
    @Override
    public boolean pickUpPipe() {
        Szkeleton.printTabs();
        Szkeleton.tabs++;
        System.out.println(Szkeleton.objectNames.get(this)+ ".pickUpPipe()");
        holdingPipe = super.getStandingField().pickUpPipe();
        Szkeleton.tabs--;
        return holdingPipe != null;
        //return super.pickUpPipe(); //TODO
    }
}
