package Fields;

import Fields.ActiveFields.ActiveFields;
import Fields.ActiveFields.Pump;
import Players.Player;

/** */
public abstract class Field {
	/** */
	private boolean occupied;
	
	/** */
	private int water;
	
	/** */
	private boolean broken;
	
	/** */
	private Player players;
	
	/** */
	public boolean accept(Player p) {
		return false;
	}
	
	/** */
	public boolean checkNeighbour(Field f) {
		return false;
	}
	
	/** */
	public boolean removePlayer(Player p) {
		return false;
	}
	
	/** */
	public boolean breakField() {
		return false;
	}
	
	/** */
	public boolean set(Pipe input, Pipe output) {
		return false;
	}
	
	/** */
	public boolean repair() {
		return false;
	}
	
	/** */
	public boolean placePump(Pump p) {
		return false;
	}
	
	/** */
	public Pump createNewPump(boolean b) {
		return null;
	}
	
	/** */
	public int getWater() {
		return 0;
	}
	
	/** */
	public boolean addPipe(Pipe p) {
		return false;
	}
	
	/** */
	public boolean removePipe(Pipe p) {
		return false;
	}
	
	/** */
	public Pipe pickUpPipe() {
		return null;
	}
	
	/** */
	public int fillInWater(int i) {
		return 0;
	}
	
	/** */
	public boolean setEnd(Pump p) {
		return false;
	}
	
	/** */
	public boolean connect(ActiveFields a) {
		return false;
	}
	
	/** */
	public boolean disconnect(ActiveFields a) {
		return false;
	}
}
