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
        Szkeleton.printTabs();
        System.out.println("new Pipe()");
        this.capacity = capacity;
    }

    /**
     * Setter for capacity. Only for initialization.
     */
    public void setFields(ArrayList<ActiveFields> fields) {
        Szkeleton.printTabs();
        System.out.println(Szkeleton.objectNames.get(this)+ ".setFields()");
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
        this.setBroken(true);
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
        oldPump.removePipe(this);
        Szkeleton.tabs--;

        Szkeleton.tabs++;
        Pipe newPipe = new Pipe(21);
        Szkeleton.objectNames.put(newPipe, "newPipe");
        Szkeleton.tabs--;

        Szkeleton.tabs++;
        newPipe.connect(newPump);
        Szkeleton.tabs--;

        Szkeleton.tabs++;
        newPipe.connect(oldPump);
        Szkeleton.tabs--;

        Szkeleton.tabs++;
        newPump.addPipe(this);
        newPump.addPipe(newPipe);
        Szkeleton.tabs--;

        Szkeleton.tabs++;
        oldPump.addPipe(newPipe);
        Szkeleton.tabs--;

        return newPipe;
    }


    /**
     * Method for getting the water from the pipe.
     * Prints the amount of water taken.
     * @return The amount of water in the pipe
     */
    @Override
    public int getWater() {
        Szkeleton.printTabs();
        System.out.println(Szkeleton.objectNames.get(this)+ ".getWater()");
        int w = super.getWaterNoChange();
        w = ((super.isBroken()) || (this.fields.size() < 2)) ? -w : w;
        Szkeleton.printTabs();
        System.out.println(w);
        return w;
    }

    /**
     * Method for filling the pipe with water.
     * Prints the amount of water returned.
     * @param i The amount of water to be filled in
     * @return The amount of water that was not filled in
     */
    @Override
    public int fillInWater(int i) {
        Szkeleton.printTabs();
        System.out.println(Szkeleton.objectNames.get(this)+ ".fillInWater()");
        int waterRightNow = super.getWaterNoChange();
        if (i - (capacity- waterRightNow) > 0) {
            Szkeleton.printTabs();
            System.out.println(i - (capacity - waterRightNow));
            return i - (capacity-waterRightNow);
        }
        else {
            Szkeleton.printTabs();
            System.out.println("0");
            return 0;
        }
    }


    /**
     * Method for setting the end of the pipe at a pump.
     * @param p The pump to be set as the end of the pipe
     * @return True if the pump was set as the end of the pipe
     */
    @Override
    public boolean setEnd(Pump p) {
        Szkeleton.printTabs();
        System.out.println(Szkeleton.objectNames.get(this)+ ".setEnd()");
        return super.setEnd(p);
    }//TODO jelenleg nem használjuk semmire a szekvenciadiagramban

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
        return true;
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
        Szkeleton.printTabs();
        System.out.println(Szkeleton.objectNames.get(this)+ ".accept()");
        if(this.isOccupied())
            return false;
        else {
            setOccupied(true);
            return true;
        }
    }
}
