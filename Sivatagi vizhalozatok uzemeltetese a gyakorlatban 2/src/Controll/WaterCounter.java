package Controll;

import Fields.ActiveFields.Cistern;
import Fields.ActiveFields.Pump;
import Fields.Pipe;

import java.util.ArrayList;

import static java.lang.Math.abs;

/**
 *WaterCounter class.
 * Responsible for counting the water.
 */
public class WaterCounter {

    /**
     *Saboteur's water count. Default value is 0.
     */
    private int saboteur;
    /**
     *Mechanic's water count. Default value is 0.
     */
    private int mechanic;

    /**
     * All cisterns in the game.
     */
    private final ArrayList<Cistern> cisterns = new ArrayList<>();
    /**
     * All pipes in the game.
     */
    private final ArrayList<Pipe> pipes = new ArrayList<>();
    /**
     * Shows if the game ended. Default value false.
     */
    private boolean end = false;

    /**
     *WaterCounter constructor.
     * Responsible for initializing the water counter.
     */

    public WaterCounter() {
        this.saboteur = 0;
        this.mechanic = 0;
    }

    public void reset(){
        saboteur=mechanic=0;
    }

    public int getSaboteur() { return saboteur; }

    public int getMechanic() { return mechanic; }
    /**
     *Adds new Cistern to cisterns.
     * @param c Cistern that is to be added to cisterns.
     */
    public void addCistern(Cistern c){
        cisterns.add(c);
    }

    /**
     *Adds new Pipe to pipes.
     * @param p Pipe that is to be added to pipes.
     */
    public void addPipe(Pipe p){
        pipes.add(p);
    }

    /**
     * Method that changes end to true.
     */
    public void setEnd(){
        end = true;
    }
    /**
     *Count method.
     * Responsible for counting the water for both team.
     */
    public void count(){
        for (Pipe pipe : pipes) {
            int w = pipe.getWater();
            if (w > 0) {
                pipe.fillInWater(w);
            } else
                saboteur += abs(w);
        }
        if(end) {
            for (Cistern cistern : cisterns) {
                int w = cistern.getWater();
                mechanic += w;
            }
        }
    }

    @Override
    public String toString() {
        return "saboteur: "+ this.getSaboteur()
                + "\nmechanic: " + this.getMechanic()
                +"\n";
    }
}
