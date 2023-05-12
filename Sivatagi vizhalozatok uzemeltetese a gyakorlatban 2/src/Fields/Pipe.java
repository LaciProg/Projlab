package Fields;

import Controll.Controller;
import Enums.Fluid;
import Fields.ActiveFields.ActiveFields;
import Fields.ActiveFields.Pump;
import Players.Player;

import java.util.ArrayList;
import java.util.Random;

/**
 * Class for Pipes
 * */
public class Pipe extends Field {

    /**
     * Capacity of the pipe
     */
    private final int capacity;
    private int breakable = 0;
    private int remainingFluidTime = 0;
    private boolean leave = true;
    private Fluid fluid = Fluid.DRY;

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
    public void setFields(ActiveFields a){fields.add(a);}

    public void setBreakable(int breakable) {
        this.breakable = breakable;
    }

    public void setFluidTime(int remainingFluidTime) {
        this.remainingFluidTime = remainingFluidTime;
    }

    public void setLeave(boolean leave) {
        this.leave = leave;
    }

    public void setFluid(Fluid fluid) {
        this.fluid = fluid;
    }

    public ArrayList<ActiveFields> getFields() { return fields; }

    public int getCapacity() { return capacity; }

    public int getBreakable() { return breakable; }

    public int getRemainingFluidTime() { return remainingFluidTime; }

    public boolean getLeave() { return leave; }

    public Fluid getFluid() { return fluid; }

    /**
      * Method for breaking the pipe.
     * @return True if the pipe is broken
     */
    @Override
    public boolean breakField() {
        if(this.breakable > 0) return false;
        this.setBroken(true);
        return true;
    }

    /**
     * Method for repairing the pipe.
     * @return True if the pipe is repaired
     */
    @Override
    public boolean repair() {
        super.setBroken(false);
        if (Controller.isTest()) {
            breakable = 5;
        }
        else {
            breakable = new Random().nextInt(3,10);
        }
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

        Pipe newPipe = new Pipe(50);

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
        super.setWater(0);
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
        if(waterRightNow == capacity) return i;
        if (i - (capacity- waterRightNow) > 0) {
            super.setWater(capacity - waterRightNow);
            return i - (capacity-waterRightNow);
        }
        else {
            super.setWater(i);
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
     *
     * @param p The player to be accepted.
     * @return True if the player was accepted.
     */
    @Override
    public Field accept(Player p) {
        if(this.isOccupied())
            return null;
        else {
            this.setOccupied(true);
            this.setPlayers(p);
        }
        if(fluid == Fluid.SLIPPERY){    //EZ MÉGIS HONNAN JÖTT?
            Random r = new Random();
            int index = (r.nextInt() % 2);
            fields.get(index).accept(p);    //SENKI NEM MONDTA HOGY 1 AZ A MÁSIK VÉGE
            return fields.get(index);       //MEG NEM AZT BESZÉLTÜK? HOGY RANDOM HELYRE KERÜL?
        }
        return this;
    }

    public boolean removePlayer(){
        if(fluid == Fluid.STICKY){
            if(leave == true){
                leave = false;
                return true;
            }
            return false;
        }
        return true;
    }
    public boolean makeSlippery(){
        if(remainingFluidTime == 0){
            Random r = new Random();
            remainingFluidTime = r.nextInt(10-3)+3;
            fluid = Fluid.SLIPPERY;
            return true;
        }
        return false;
    }

    public  boolean makeSticky(){
        if(remainingFluidTime == 0){
            Random r = new Random();
            remainingFluidTime = r.nextInt(10-3)+3;
            fluid = Fluid.STICKY;
            return true;
        }
        return false;
    }

    public void step(){
        if(breakable > 0){
            breakable--;
        }
        if(remainingFluidTime > 0){
            remainingFluidTime--;
            if(remainingFluidTime == 0){
                fluid = Fluid.DRY;
                leave = true;
            }
        }
    }
    @Override
    public String toString() {
        ArrayList<Player> players = this.getPlayers();

        String playersNames = "null";

        for (int i = 0; i < players.size(); i++) {
            if(i == 0) playersNames = "";
            playersNames += Controller.objectReverseNames.get(players.get(i));
            if (i != players.size() - 1) {
                playersNames += ", ";
            }
        }

        ArrayList<ActiveFields> fields = this.getFields();
        String fieldsNames ="null";
        for (int i = 0; i < fields.size(); i++) {
            if(i == 0) fieldsNames = "";
            fieldsNames += Controller.objectReverseNames.get(fields.get(i));
            if (i != fields.size() - 1) {
                fieldsNames += ", ";
            }
        }

        return "name: " + Controller.objectReverseNames.get(this)
                + "\noccupied: " + this.isOccupied()
                + "\nwater: " + getWaterNoChange()
                + "\nbroken: " + this.isBroken()
                + "\nplayers: " + playersNames
                + "\nfields: " + fieldsNames
                + "\ncapacity: " + this.getCapacity()
                + "\nbreakable: " + this.getBreakable()
                + "\nrfluidtime: " + this.getRemainingFluidTime()
                + "\nleave: " + this.getLeave()
                + "\nfluid: " + this.getFluid().toString().toLowerCase() + "\n";
    }
}