package Controll;

import Fields.ActiveFields.Cistern;
import Fields.Pipe;

import java.util.ArrayList;

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
    private ArrayList<Cistern> cisterns = new ArrayList<>();
    /**
     * All pipes in the game.
     */
    private ArrayList<Pipe> pipes = new ArrayList<>();
    /**
     * Shows if the game ended. Default value false.
     */
    private boolean gameended = false;

    /**
     *WaterCounter constructor.
     * Responsible for initializing the water counter.
     */
    public WaterCounter() {
        Szkeleton.printTabs();
        System.out.println("new WaterCounter()");
        this.saboteur = 0;
        this.mechanic = 0;
    }

    /**
     *Adds new Cistern to cisterns.
     * @param c Cistern that is to be added to cisterns.
     */
    public void addCistern(Cistern c){
        Szkeleton.printTabs();
        System.out.println(Szkeleton.objectNames.get(this) + ".addCistern()");
        cisterns.add(c);
    }

    /**
     *Adds new Pipe to pipes.
     * @param p Pipe that is to be added to pipes.
     */
    public void addPipe(Pipe p){
        Szkeleton.printTabs();
        System.out.println(Szkeleton.objectNames.get(this) + ".addPipe()");
        pipes.add(p);
    }

    /**
     * Method that changes gameended to true.
     */
    public void setEnd(){
        Szkeleton.printTabs();
        System.out.println(Szkeleton.objectNames.get(this) + ".setEnd");
        gameended = true;
    }
    /**
     *Count method.
     * Responsible for counting the water for both team.
     */
    public void count(){
        Szkeleton.printTabs();
        System.out.println(Szkeleton.objectNames.get(this)+".count()");
        Szkeleton.tabs++;
        for(int i = 0; i < pipes.size(); i++){
            int w = pipes.get(i).getWater();
            if(w > 0){
                pipes.get(i).fillInWater(w);
            }
            else
                saboteur += -w;
        }
        if(gameended) {
            for (int i = 0; i < cisterns.size(); i++) {
                int w = cisterns.get(i).getWater();
                mechanic += w;
            }
        }
        Szkeleton.tabs--;
    }

}
