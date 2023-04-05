package Fields.ActiveFields;

import Fields.ActiveFields.ActiveFields;
import Fields.Pipe;

/** */
public class Pump extends ActiveFields {

    /**
     *
     */
    private int tank;

    /**
     *
     */
    private int waterFrom;

    /**
     *
     */
    private int waterTo;

    /** */
    @Override
    public void step() {
        super.step();
    }

    /**
     * @param input
     * @param output
     */
    @Override
    public boolean set(Pipe input, Pipe output) {
        return super.set(input, output);
    }
}
