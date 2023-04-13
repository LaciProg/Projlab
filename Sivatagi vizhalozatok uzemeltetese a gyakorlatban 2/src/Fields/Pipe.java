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
        System.out.println(Szkeleton.objectNames.get(this)+ ".breakField()");
        return true;
    }

    /**
     * Method for repairing the pipe.
     * @return True if the pipe is repaired
     */
    @Override
    public boolean repair() {
        Szkeleton.printTabs();
        System.out.println(Szkeleton.objectNames.get(this)+ ".repair()");
        return true;
    }

    /**
     * Method for placing a pump on the pipe.
     * @param newPump The pump to be placed
     * @return True if the pump was placed
     */
    @Override
    public Pipe placePump(Pump newPump) {
        Szkeleton.printTabs();
        System.out.println(Szkeleton.objectNames.get(this)+ ".placePump()");
        Pump oldPump = (Pump) fields.remove(0);

        Szkeleton.tabs++;
        disconnect(oldPump);
        Szkeleton.tabs--;

        Szkeleton.tabs++;
        connect(newPump);
        Szkeleton.tabs--;

        Szkeleton.tabs++;
        boolean result = oldPump.removePipe(this); //Ha szükség van rá csak kkor tárolgassuk már el a visszatérési értéket
        Szkeleton.tabs--;

        Pipe newPipe = new Pipe(21);
        Szkeleton.tabs++;
        result = newPipe.connect(newPump);
        Szkeleton.tabs--;

        Szkeleton.tabs++;
        result = newPipe.connect(oldPump);
        Szkeleton.tabs--;

        Szkeleton.tabs++;
        result = newPump.addPipe(this);
        result = newPump.addPipe(newPipe);
        Szkeleton.tabs--;

        Szkeleton.tabs++;
        result = oldPump.addPipe(newPipe);
        Szkeleton.tabs--;

        return newPipe;
    }

    /**
     * Method for getting the water from the pipe.
     * @return The amount of water in the pipe
     */
    @Override
    public int getWater() {
        Szkeleton.printTabs();
        System.out.println(Szkeleton.objectNames.get(this)+ ".getWater()");
        return super.getWater();
    }

    /**
     * Method for filling the pipe with water.
     * @param i The amount of water to be filled in
     * @return The amount of water that was not filled in
     */
    @Override
    public int fillInWater(int i) {
        Szkeleton.printTabs();
        System.out.println(Szkeleton.objectNames.get(this)+ ".fillInWater()");
        if (i - capacity > 0) return i - capacity;
        else if (i - capacity < 0) return capacity - i;
        else return 0;
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
        Szkeleton.printTabs();
        System.out.println(Szkeleton.objectNames.get(this)+ ".connect()");
        fields.add(a);
        return super.connect(a);
    }

    /**
     * Method for disconnecting the pipe to an ActiveField.
     * @param a The ActiveField to be disconnected to the pipe
     * @return True if the pipe was disconnected to the ActiveField
     */
    @Override
    public boolean disconnect(ActiveFields a) {
        Szkeleton.printTabs();
        System.out.println(Szkeleton.objectNames.get(this)+ ".disconnect()");
        //TODO törlés megvalósítása
        return super.disconnect(a);
    }

}
