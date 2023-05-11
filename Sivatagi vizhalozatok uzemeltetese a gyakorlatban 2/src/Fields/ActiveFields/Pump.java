package Fields.ActiveFields;

import Controll.Controller;
import Controll.Szkeleton;
import Fields.Pipe;
import Players.Player;

import java.util.ArrayList;

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
        this.waterFrom = -1;
        this.waterTo = -1;
    }

    public int getTank() { return tank; }

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
            super.setWater((this.getPipes().get(waterTo)).fillInWater(super.getWater()));
            int newWater = (this.getPipes().get(waterFrom)).getWater();
            if(newWater < 0) this.getPipes().get(waterFrom).fillInWater(newWater);
            else{
                if(super.getWaterNoChange() + newWater > tank){
                    super.setWater(tank);
                    this.getPipes().get(waterFrom).fillInWater(newWater-tank);
                }
                else super.setWater(super.getWaterNoChange() + newWater);
            }
        }
        if(false){//Todo random szám legyen :)
            super.setBroken(true);
        }
    }
    /**
     * Method for setting the water flow in the pump.
     * @param input Pipe - The input pipe of the pump.
     * @param output Pipe - The output pipe of the pump.
     * @return True if the water flow was set. - always false.
     * */
    @Override
    public boolean set(Pipe input, Pipe output) {
        int newWaterFrom = this.getPipes().indexOf(input);
        int newWaterTo = this.getPipes().indexOf(output);
        if(newWaterFrom == -1 || newWaterTo == -1) return false;
        this.setWaterFrom(waterFrom);
        this.setWaterTo(waterTo);
        return true;
    }

    @Override
    public boolean repair() {
        super.setBroken(false);
        return true;
    }

    @Override
    public String toString() {
        ArrayList<Player> players = this.getPlayers();
        System.out.println(players);
        String playersNames = "";
        if (players == null) playersNames = null;
        else {
            for (int i = 0; i < players.size(); i++) {
                playersNames += Controller.objectReverseNames.get(players.get(i));
                if (i != players.size() - 1) {
                    playersNames += ", ";
                }
            }
        }


        ArrayList<Pipe> pipes = this.getPipes();
        String pipesNames = "";
        if (pipes == null) pipesNames = null;
        else {
            for (int i = 0; i < pipes.size(); i++) {
                pipesNames += Controller.objectReverseNames.get(pipes.get(i));
                if (i != pipes.size() - 1) {
                    pipesNames += ", ";
                }
            }
        }

        return "name: "+ Controller.objectReverseNames.get(this)
                + "\noccupied: " + this.isOccupied()
                + "\nwater: " + getWaterNoChange()
                + "\nbroken: " + this.isBroken()
                + "\nplayers: " + playersNames
                + "\npipes: " + pipesNames
                + "\ntank: " + this.getTank()
                + "\nwaterFrom: " + this.getWaterFrom()
                + "\nwaterTo: " + this.getWaterTo() + "\n";
    }
}
