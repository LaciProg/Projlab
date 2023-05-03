package Fields;

import Controll.Szkeleton;
import Fields.ActiveFields.ActiveFields;
import Fields.ActiveFields.Pump;
import Players.Player;

import java.util.ArrayList;

/**
 * Class for Pipes
 * */
public class Pipe extends Field {

    /**
     * Capacity of the pipe
     */
    private final int capacity;

    /**
     * The ends of the pipe. Default is empty.
     */
    private ArrayList<ActiveFields> fields = new ArrayList<>();

    /**
     * Constructor for Pipe
     * @param capacity Capacity of the pipe
     */
    public Pipe(int capacity) {
        this.capacity = capacity;
    }

    /**
     * Setter for capacity. Only for initialization.
     */
    public void setFields(ArrayList<ActiveFields> fields) {
        this.fields = fields;
    }

    /**
      * Method for breaking the pipe.
     * @return True if the pipe is broken
     */
    @Override
    public boolean breakField() {
        this.setBroken(true);
        return true;
    }

    /**
     * Method for repairing the pipe.
     * @return True if the pipe is repaired
     */
    @Override
    public boolean repair() {
        return true;
    }

    /**
     * Method for placing a pump on the pipe.
     * @param newPump The pump to be placed
     * @return True if the pump was placed
     */
    @Override
    public Pipe placePump(Pump newPump) {
        Pump oldPump = (Pump) fields.remove(0);

        disconnect(oldPump);

        connect(newPump);

        oldPump.removePipe(this);

        Pipe newPipe = new Pipe(21);

        newPipe.connect(newPump);

        newPipe.connect(oldPump);

        newPump.addPipe(this);
        newPump.addPipe(newPipe);

        oldPump.addPipe(newPipe);

        return newPipe;
    }


    /**
     * Method for getting the water from the pipe.
     * Prints the amount of water taken.
     * @return The amount of water in the pipe
     */
    @Override
    public int getWater() {
        int w = super.getWaterNoChange();
        return ((super.isBroken()) || (this.fields.size() < 2)) ? -w : w;
    }

    /**
     * Method for filling the pipe with water.
     * Prints the amount of water returned.
     * @param i The amount of water to be filled in
     * @return The amount of water that was not filled in
     */
    @Override
    public int fillInWater(int i) {
        int waterRightNow = super.getWaterNoChange();
        if (i - (capacity- waterRightNow) > 0) {
            return i - (capacity-waterRightNow);
        }
        else {
            return 0;
        }
    }


    /**
     * Method for connecting the pipe to an ActiveField.
     * @param a The ActiveField to be connected to the pipe
     * @return True if the pipe was connected to the ActiveField
     */
    @Override
    public boolean connect(ActiveFields a) {
        fields.add(a);
        return true;
    }

    /**
     * Method for disconnecting the pipe to an ActiveField.
     * @param a The ActiveField to be disconnected to the pipe
     * @return True if the pipe was disconnected to the ActiveField
     */
    @Override
    public boolean disconnect(ActiveFields a) {
        fields.remove(a);
        return true;
    }

    /**
     * Methods for accepting players.
     * @param p The player to be accepted.
     * @return True if the player was accepted.
     * */
    @Override
    public boolean accept(Player p) {
        if(this.isOccupied())
            return false;
        else {
            setOccupied(true);
            return true;
        }
    }
}
