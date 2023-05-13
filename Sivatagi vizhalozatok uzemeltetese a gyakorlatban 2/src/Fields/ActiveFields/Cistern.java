package Fields.ActiveFields;

import Controll.Szkeleton;
import Controll.Controller;
import Fields.Pipe;
import Players.Player;

import java.util.ArrayList;

/**
 * Class for Cistern
 * */
public class Cistern extends ActiveFields{

    /**
     *
     */
    private Pipe createdPipe;
    /**
     * Constructor for the cistern.
     */
    public Cistern() {
        createdPipe = null;
        super.setWater(0);
    }

    /**
     * Method for the game controlled events.
     * Gets the water from the pipes and stores it.
     * Creates a new pipe
     */
    @Override
    public void step() {
        if (getPipes() != null) {
            for (Pipe pipe : getPipes()) {
                super.setWater(super.getWater() + pipe.getWater());
            }
        }
        if(createdPipe == null){
            createdPipe = new Pipe(65);     //TODO: randomize the capacity
            Controller.waterCounter.addPipe(createdPipe);
            Controller.pipes++;
            Controller.objectNames.put("newPipe"+Controller.pipes, createdPipe);
            Controller.objectReverseNames.put(createdPipe, "newPipe"+Controller.pipes);
        }
    }

    /**
     * Method for creating a new pump.
     * @param b True if the player get a new pump.
     * @return The new pump.
     * */
    @Override
    public Pump createNewPump(boolean b) {
        if(b) return new Pump(100);
        else return null;
    }

    /**
     * Method for getting the water from the field.
     * Prints the amount of water taken.
     * @return The amount of water in the field.
     */
    @Override
    public int getWater() {
        return super.getWaterNoChange();
    }

    /**
     * Method for picking up a (new) pipe from the field.
     * @return The new pipe.
     */
    @Override
    public Pipe pickUpPipe() {
        this.addPipe(createdPipe);
        createdPipe.connect(this);
        Pipe tmp = createdPipe;
        createdPipe = null;
        return tmp;
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



        ArrayList<Pipe> pipes = this.getPipes();
        String pipesNames ="null";
        if(pipes != null) {
            for (int i = 0; i < pipes.size(); i++) {
                if (i == 0) pipesNames = "";
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
                  + "\npipes: " + pipesNames + "\n";
    }
}
