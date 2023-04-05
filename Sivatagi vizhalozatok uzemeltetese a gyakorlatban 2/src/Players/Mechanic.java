package Players;

import Fields.ActiveFields.Pump;
import Fields.Field;
import Fields.Pipe;


/**
 * Class for the mechanic player.
 * */
public class Mechanic extends Player {

    /**
     *The pump that the mechanic is holding. Default is null.
     */
    private Pump holdingPump = null;
    /**
     *The pipe that the mechanic is holding. Default is null.
     */
    private Pipe holdingPipe = null;

    /**
     *  holdingPipe = null;
     *  holdingPump = null;
     * @param standingField Field
     */
    public Mechanic(Field standingField) {
        super(standingField);
        this.holdingPipe = null;
        this.holdingPump = null;
    }

    /**
     *Method for repairing the field where the player is standing.
     * @return boolean - returns true if the field is repaired.
     */
    @Override
    public boolean repair() {
        return super.repair();
    }

    /**
     *Method for placing a pump on the field where the player is standing.
     * @return Pipe - The other (new) half of the pipe.
     */
    @Override
    public Pipe placePump() {
        return super.placePump();
    }

    /**
     * Method for disconnecting a pipe from a pump.
     * @param p Pipe
     *          The pipe that will be disconnected.
     * @return boolean - returns true if the pipe is disconnected.
     */
    @Override
    public boolean disconnect(Pipe p) {
        return super.disconnect(p);
    }

    /**
     * Method for connecting the holdingPipe to a pump.
     * @return boolean - returns true if the pipe is connected.
     */
    @Override
    public boolean connect() {
        return super.connect();
    }

    /**
     * Method for getting a pump from the field where the player is standing.
     * @return Pump - The new pump.
     */
    @Override
    public Pump getPump() {
        return super.getPump();
    }

    /**
     * Method for picking up a new pipe from the field where the player is standing.
     * @return boolean - returns true if the pipe is picked up.
     */
    @Override
    public boolean pickUpPipe() {
        return super.pickUpPipe();
    }
}
