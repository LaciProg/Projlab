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
     * Constructor for the cistern.
     */
    public Cistern() {
        super.setWater(0);
    }

    /**
     * Method for the game controlled events.
     * Gets the water from the pipes and stores it.
     * Creates a new pipe
     */
    @Override
    public void step() {
        for(Pipe pipe : getPipes()){
            super.setWater(super.getWater()+pipe.getWater());
        }
    }

    /**
     * Method for creating a new pump.
     * @param b True if the player get a new pump.
     * @return The new pump.
     * */
    @Override
    public Pump createNewPump(boolean b) {
        return new Pump(100);
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
        return new Pipe(65);
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
                  + "\npipes: " + pipesNames + "\n";
    }
}
