package Fields;

import Fields.ActiveFields.ActiveFields;
import Fields.ActiveFields.Pump;

/** */
public class Pipe extends Field {
    /**
     *
     */
    private int capacity;
    /**
     *
     */
    private ActiveFields fields;

     /**
      *
     */
    @Override
    public boolean breakField() {
        return super.breakField();
    }

    /**
     *
     */
    @Override
    public boolean repair() {
        return super.repair();
    }

    /**
     * @param p
     */
    @Override
    public boolean placePump(Pump p) {
        return super.placePump(p);
    }

    /**
     *
     */
    @Override
    public int getWater() {
        return super.getWater();
    }

    /**
     * @param i
     */
    @Override
    public int fillInWater(int i) {
        return super.fillInWater(i);
    }

    /**
     * @param p
     */
    @Override
    public boolean setEnd(Pump p) {
        return super.setEnd(p);
    }

    /**
     * @param a
     */
    @Override
    public boolean connect(ActiveFields a) {
        return super.connect(a);
    }

    /**
     * @param a
     */
    @Override
    public boolean disconnect(ActiveFields a) {
        return super.disconnect(a);
    }

}
