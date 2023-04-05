package Players;

import Fields.ActiveFields.Pump;
import Fields.Field;
import Fields.Pipe;

/** */
public abstract class Player {
	/** */
	private Field standingField;
	
	/** */
	public boolean move(Field f) {
		return false;
	}
	
	/** */
	public boolean breakField() {
		return false;
	}
	
	/** */
	public boolean repair() {
		return false;
	}
	
	/** */
	public Pipe placePump() {
		return null;
	}
	
	/** */
	public boolean set(Pipe input, Pipe output) {
		return false;
	}
	
	/** */
	public boolean disconnect(Pipe p) {
		return false;
	}
	
	/** */
	public boolean connect() {
		return false;
	}
	
	/** */
	public Pump getPump() {
		return null;
	}
	
	/** */
	public boolean pickUpPipe() {
		return false;
	}
}
