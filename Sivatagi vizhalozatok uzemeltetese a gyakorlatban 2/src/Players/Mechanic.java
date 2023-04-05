package Players;

import Fields.ActiveFields.Pump;
import Fields.Pipe;


/** */
public class Mechanic extends Player {
    /**
     *
     */
    private Pump holdingPump;
    /**
     *
     */
    private Pipe holdingPipe;

    /**
     *
     */
    @Override
    public boolean repair() {
        return super.repair();
    }

    /**
     *
     */
    @Override
    public Pipe placePump() {
        return super.placePump();
    }

    /**
     * @param p
     */
    @Override
    public boolean disconnect(Pipe p) {
        return super.disconnect(p);
    }

    /**
     *
     */
    @Override
    public boolean connect() {
        return super.connect();
    }

    /**
     *
     */
    @Override
    public Pump getPump() {
        return super.getPump();
    }

    /**
     *
     */
    @Override
    public boolean pickUpPipe() {
        return super.pickUpPipe();
    }
}
