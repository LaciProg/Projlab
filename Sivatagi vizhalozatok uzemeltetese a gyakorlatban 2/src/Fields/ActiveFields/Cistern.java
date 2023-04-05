package Fields.ActiveFields;

import Fields.Pipe;

/** */
public class Cistern extends ActiveFields{
    /**
     *
     */
    private int waterStored;

    /**
     *
     */
    @Override
    public void step() {
        super.step();
    }

    /**
     * @param b
     */
    @Override
    public Pump createNewPump(boolean b) {
        return super.createNewPump(b);
    }

    /**
     *
     */
    @Override
    public int getWater() {
        return super.getWater();
    }

    /**
     *
     */
    @Override
    public Pipe pickUpPipe() {
        return super.pickUpPipe();
    }
}
