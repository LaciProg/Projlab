package Fields.ActiveFields;

import Fields.Field;
import Fields.Pipe;
import Interfaces.Steppable;

/** */

public abstract class ActiveFields extends Field implements Steppable {
    /**
     *
     */
    private Pipe pipes;

    /**
     * @param p
     */
    @Override
    public boolean addPipe(Pipe p) {
        return super.addPipe(p);
    }

    /**
     * @param p
     */
    @Override
    public boolean removePipe(Pipe p) {
        return super.removePipe(p);
    }

    /**
     *
     */
    @Override
    public void step() {

    }
}
