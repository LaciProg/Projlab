package Fields.ActiveFields;

import Controll.Controller;
import Controll.Szkeleton;
import Fields.Pipe;
/**
 * Class for Pump
 * */
public class Pump extends ActiveFields {

    /**
     * The amount of water in the tank. Default value is 0.
     */
    private final int tank;

    /**
     * The index of the pipe from which the pump gets water.
     */
    private int waterFrom;

    /**
     * The index of the pipe to which the pump gives water.
     */
    private int waterTo;

    /**
     * Constructor for the pump.
     */
    public Pump(int tank) {
        this.tank = tank;
        this.waterFrom = 0;
        this.waterTo = 0;
    }

    /**
     * Setter for the waterFrom.
     * @param waterFrom The index of the pipe from which the pump gets water. Only for initialization.
     */
    public void setWaterFrom(int waterFrom) {
        this.waterFrom = waterFrom;
    }

    public int getWaterFrom() { return waterFrom; }
    /**
     * Setter for the waterTo.
     * @param waterTo The index of the pipe to which the pump gives water. Only for initialization.
     */
    public void setWaterTo(int waterTo) {
        this.waterTo = waterTo;
    }

    public int getWaterTo() { return waterTo; }
    /**
     * Method for the game controlled events.
     * Gets the water pumps the water from the tank to the pipe and gets the water from the input and store it.
     */
    @Override
    public void step() {
        super.step();
        if(!(super.isBroken())) {
            int plusWater;
            plusWater = this.getPipes().get(waterTo).fillInWater(tank);

            int waterInPipe = this.getPipes().get(waterFrom).getWater();

            this.getPipes().get(waterFrom).fillInWater(waterInPipe + plusWater - tank);
        }
    }

    /**
     * Method for breaking the pump.
     * @return True if the pump is broken
     */
    @Override
    public boolean breakField() {
        return true;
    }

    /**
     * Method for setting the water flow in the pump.
     * @param input Pipe - The input pipe of the pump.
     * @param output Pipe - The output pipe of the pump.
     * @return True if the water flow was set. - always false.
     * */
    @Override
    public boolean set(Pipe input, Pipe output) {
        waterFrom = super.getPipes().indexOf(input);
        waterTo = super.getPipes().indexOf(output);
        if(waterFrom == -1 || waterTo == -1) return false;
        this.setWaterFrom(waterFrom);
        this.setWaterTo(waterTo);
        return true;
    }

    @Override
    public boolean repair() {
        return true;
    }

    @Override
    public String toString() {
        return "name: "+ Controller.objectReverseNames.get(this)
                + "\noccupied: " + this.isOccupied()
                + "\nwater: " + getWaterNoChange()
                + "\nbroken: " + this.isBroken()
                + "\nplayers: " + super.getPlayers()
                //+ "\npipes: " + super.getPipes()
                + "\nwaterTo: " + this.getWaterTo()
                + "\nmaxFrom: " + this.getWaterFrom()+"\n";
    }
}
