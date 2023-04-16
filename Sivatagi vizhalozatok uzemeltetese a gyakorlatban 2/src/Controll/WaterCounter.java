package Controll;

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
     *Count method.
     * Responsible for counting the water for both team.
     */
    public void count(){
        Szkeleton.printTabs();
        System.out.println(Szkeleton.objectNames.get(this)+".count()");
        Szkeleton.tabs++;

        Szkeleton.tabs--;
    }

}
