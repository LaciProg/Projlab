package Fields.ActiveFields;

import Fields.Field;
import Fields.Pipe;
import Interfaces.Steppable;

import java.util.ArrayList;

/**
 * Abstract class for active fields.
 * */
public abstract class ActiveFields extends Field implements Steppable {

    /**
     * Pipes connected to the active field. Default is empty.
     */
    private ArrayList<Pipe> pipes  = new ArrayList<>();

    /**
     * Getter for pipes. Only for child classes.
     * @return The pipes connected to the active field
     */
    public ArrayList<Pipe> getPipes() {
        return pipes;
    }

    /**
     * Setter for pipes. Only for initialization.
     */
    public void setPipes(ArrayList<Pipe> pipes) {
        this.pipes = pipes;
    }

    /**
     * Method for adding a pipe to the active field.
     * @param p The pipe to be added
     * @return True if the pipe was added
     */
    @Override
    public boolean addPipe(Pipe p) {
        return super.addPipe(p);
    }

    /**
     * Method for removing a pipe from the active field.
     * @param p The pipe to be removed
     * @return True if the pipe was removed
     */
    @Override
    public boolean removePipe(Pipe p) {
        return super.removePipe(p);
    }

    /**
     * Method for the game controlled events.
     */
    @Override
    public void step() {

    }
}
