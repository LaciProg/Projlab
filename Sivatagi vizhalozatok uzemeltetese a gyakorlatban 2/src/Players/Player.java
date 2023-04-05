package Players;

import Fields.ActiveFields.Pump;
import Fields.Field;
import Fields.Pipe;

/**
 * Abstract class for the players.
 * */
public abstract class Player {

	/**
	 * The field where the player is standing. Default is null.
	 * */
	private Field standingField = null;

	/**
	 * Getter for the standingField. Only for child classes.
	 * @return standingField
	 */
	public Field getStandingField() {
		return standingField;
	}

	/**
	 * @param standingField Field
	 */
	public Player(Field standingField) {
		this.standingField = standingField;
	}


	/**
	 * Method for moving the player to a new field.
	 * @param f Field - The field where the player wants to move.
	 * @return boolean - always false.
	 * */
	public boolean move(Field f) {
		return false;
	}
	
	/**
	 * Method for breaking the field where the player is standing.
	 * @return boolean - always false.
	 * */
	public boolean breakField() {
		return false;
	}
	
	/**
	 * Method for repairing the field where the player is standing.
	 * @return boolean - always false.
	 * */
	public boolean repair() {
		return false;
	}
	
	/**
	 * Method for placing a pump on the field where the player is standing.
	 * @return Pipe - The other (new) half of the pipe. - always null.
	 * */
	public Pipe placePump() {
		return null;
	}
	
	/**
	 * Method for setting the water flow in the pump.
	 * @param input Pipe - The input pipe of the pump.
	 * @param output Pipe - The output pipe of the pump.
	 * @return boolean - always false.
	 * */
	public boolean set(Pipe input, Pipe output) {
		return false;
	}
	
	/**
	 * Method for disconnecting a pipe from a pump.
	 * @param p Pipe - The pipe to be disconnected.
	 * @return boolean - always false.
	 * */
	public boolean disconnect(Pipe p) {
		return false;
	}
	
	/**
	 * Method for connecting the holdingPipe to a pump.
	 * @return boolean - always false.
	 * */
	public boolean connect() {
		return false;
	}
	
	/**
	 * Method for getting a pump from the field where the player is standing.
	 * @return Pump - The new pump. - always null.
	 * */
	public Pump getPump() {
		return null;
	}
	
	/**
	 * Method for picking up a new pipe from the field where the player is standing.
	 * @return boolean - always false.
	 * */
	public boolean pickUpPipe() {
		return false;
	}
}
