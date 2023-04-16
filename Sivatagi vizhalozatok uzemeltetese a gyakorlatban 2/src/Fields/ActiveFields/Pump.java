package Fields.ActiveFields;

import Controll.Szkeleton;
import Fields.Pipe;
import Players.Player;

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
        Szkeleton.printTabs();
        System.out.println("new Pump()");
        this.tank = tank;
        this.waterFrom = 0;
        this.waterTo = 0;
    }

    /**
     * Setter for the waterFrom.
     * @param waterFrom The index of the pipe from which the pump gets water. Only for initialization.
     */
    public void setWaterFrom(int waterFrom) {
        Szkeleton.printTabs();
        System.out.println(Szkeleton.objectNames.get(this)+ ".setWaterFrom()");
        this.waterFrom = waterFrom;
    }

    /**
     * Setter for the waterTo.
     * @param waterTo The index of the pipe to which the pump gives water. Only for initialization.
     */
    public void setWaterTo(int waterTo) {
        Szkeleton.printTabs();
        System.out.println(Szkeleton.objectNames.get(this)+ ".setWaterTo()");
        this.waterTo = waterTo;
    }

    /**
     * Method for the game controlled events.
     * Gets the water pumps the water from the tank to the pipe and gets the water from the input and store it.
     */
    @Override
    public void step() {
        super.step();
        if(!(super.isBroken())) {
            Szkeleton.tabs++;
            int plusWater;
            plusWater = this.getPipes().get(waterTo).fillInWater(tank);
            Szkeleton.tabs--;

            Szkeleton.tabs++;
            int waterInPipe = this.getPipes().get(waterFrom).getWater();
            Szkeleton.tabs--;

            Szkeleton.tabs++;
            this.getPipes().get(waterFrom).fillInWater(waterInPipe + plusWater - tank);
            Szkeleton.tabs--;
        }
    }

    /**
     * Method for breaking the pump.
     * @return True if the pump is broken
     */
    @Override
    public boolean breakField() {
        Szkeleton.printTabs();
        System.out.println(Szkeleton.objectNames.get(this)+ ".breakField()");
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
        Szkeleton.printTabs();
        System.out.println(Szkeleton.objectNames.get(this)+ ".set()");
        waterFrom = super.getPipes().indexOf(input);
        waterTo = super.getPipes().indexOf(output);
        return super.set(input, output);
    }

    @Override
    public boolean repair() {
        Szkeleton.printTabs();
        System.out.println(Szkeleton.objectNames.get(this)+ ".repair()");
        return true;
    }   
}
