package Fields;

import Controll.Szkeleton;
import Fields.ActiveFields.ActiveFields;
import Fields.ActiveFields.Pump;

import java.util.ArrayList;

/**
 * Class for Pipes
 * */
public class Pipe extends Field {

    /**
     * Capacity of the pipe
     */
    private int capacity;

    /**
     * The ends of the pipe. Default is empty.
     */
    private ArrayList<ActiveFields> fields = new ArrayList<ActiveFields>();

    /**
     * Constructor for Pipe
     * @param capacity Capacity of the pipe
     */
    public Pipe(int capacity) {
        this.capacity = capacity;
    }

    /**
     * Setter for capacity. Only for initialization.
     * @return Capacity of the pipe
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
        Szkeleton.printTabs();
        System.out.println("ObjectName.breakField()");
        return true;
    }

    /**
     * Method for repairing the pipe.
     * @return True if the pipe is repaired
     */
    @Override
    public boolean repair() {
        return super.repair();
    }

    /**
     * Method for placing a pump on the pipe.
     * @param p The pump to be placed
     * @return True if the pump was placed
     */
    @Override
    public boolean placePump(Pump p) {
        return super.placePump(p);
    }

    /**
     * Method for getting the water from the pipe.
     * @return The amount of water in the pipe
     */
    @Override
    public int getWater() {
        return super.getWater();
    }

    /**
     * Method for filling the pipe with water.
     * @param i The amount of water to be filled in
     * @return The amount of water that was not filled in
     */
    @Override
    public int fillInWater(int i) {
        return super.fillInWater(i);
    }


    /**
     * Method for setting the end of the pipe at a pump.
     * @param p The pump to be set as the end of the pipe
     * @return True if the pump was set as the end of the pipe
     */
    @Override
    public boolean setEnd(Pump p) {
        return super.setEnd(p);
    }

    /**
     * Method for connecting the pipe to an ActiveField.
     * @param a The ActiveField to be connected to the pipe
     * @return True if the pipe was connected to the ActiveField
     */
    @Override
    public boolean connect(ActiveFields a) {
        return super.connect(a);
    }

    /**
     * Method for disconnecting the pipe to an ActiveField.
     * @param a The ActiveField to be disconnected to the pipe
     * @return True if the pipe was disconnected to the ActiveField
     */
    @Override
    public boolean disconnect(ActiveFields a) {
        return super.disconnect(a);
    }

}
