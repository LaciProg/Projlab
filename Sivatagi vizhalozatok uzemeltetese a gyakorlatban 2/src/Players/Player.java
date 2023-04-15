package Players;

import Controll.Szkeleton;
import Fields.ActiveFields.Pump;
import Fields.Field;
import Fields.Pipe;

/**
 * Abstract class for the players.
 * */
public abstract class Player {

	/**
	 * The field where the player is standing.
	 * */
	private Field standingField;

	/**
	 * Setter for the standingField. Only for initialization.
	 * @param standingField
	 */
	public void setStandingField(Field standingField) {
		Szkeleton.printTabs();
		System.out.println(Szkeleton.objectNames.get(this)+ ".setStandingField()");
		this.standingField = standingField;
	}

	/**
	 * Getter for the standingField. Only for child classes.
	 * @return standingField
	 */
	public Field getStandingField() {
		Szkeleton.printTabs();
		System.out.println(Szkeleton.objectNames.get(this)+ ".getStandingField()");
		return standingField;
	}

	/**
	 * Constructor for the player.
	 */
	public Player() {
		standingField = null;
	}


	/**
	 * Method for moving the player to a new field.
	 * @param f Field - The field where the player wants to move.
	 * @return boolean - always false.
	 * */
	public boolean move(Field f) {
		Szkeleton.printTabs();
		System.out.println(Szkeleton.objectNames.get(this)+ ".move()");
		return false; //TODO
	}
	
	/**
	 * Method for breaking the field where the player is standing.
	 * @return boolean - always false.
	 * */
	public boolean breakField() {
		Szkeleton.printTabs();
		System.out.println(Szkeleton.objectNames.get(this)+ ".breakField()");
		return false;
	}
	
	/**
	 * Method for repairing the field where the player is standing.
	 * @return boolean - always false.
	 * */
	public boolean repair() {
		Szkeleton.printTabs();
		System.out.println(Szkeleton.objectNames.get(this)+ ".repair()");
		return false;
	}
	
	/**
	 * Method for placing a pump on the field where the player is standing.
	 * @return Pipe - The other (new) half of the pipe. - always null.
	 * */
	public Pipe placePump() {
		Szkeleton.printTabs();
		System.out.println(Szkeleton.objectNames.get(this)+ ".placePump()");
		return null;
	}
	
	/**
	 * Method for setting the water flow in the pump.
	 * @param input Pipe - The input pipe of the pump.
	 * @param output Pipe - The output pipe of the pump.
	 * @return boolean - always false.
	 * */
	public boolean set(Pipe input, Pipe output) {
		Szkeleton.printTabs();
		System.out.println(Szkeleton.objectNames.get(this)+ ".set()");
		return false;
	}
	
	/**
	 * Method for disconnecting a pipe from a pump.
	 * @param p Pipe - The pipe to be disconnected.
	 * @return boolean - always false.
	 * */
	public boolean disconnect(Pipe p) {
		Szkeleton.printTabs();
		System.out.println(Szkeleton.objectNames.get(this)+ ".disconnect()");
		return false;
	}
	
	/**
	 * Method for connecting the holdingPipe to a pump.
	 * @return boolean - always false.
	 * */
	public boolean connect() {
		Szkeleton.printTabs();
		System.out.println(Szkeleton.objectNames.get(this)+ ".connect()");
		return false;
	}
	
	/**
	 * Method for getting a pump from the field where the player is standing.
	 * @return Pump - The new pump. - always null.
	 * */
	public Pump getPump() {
		Szkeleton.printTabs();
		System.out.println(Szkeleton.objectNames.get(this)+ ".getPump()");
		return null;
	}
	
	/**
	 * Method for picking up a new pipe from the field where the player is standing.
	 * @return boolean - always false.
	 * */
	public boolean pickUpPipe() {
		Szkeleton.printTabs();
		System.out.println(Szkeleton.objectNames.get(this)+ ".pickUpPipe()");
		return false;
	}
}
