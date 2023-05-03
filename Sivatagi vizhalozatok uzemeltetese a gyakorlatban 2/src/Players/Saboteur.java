package Players;

import Controll.Szkeleton;


/**
 * Class for the saboteur player.
 * */
public class Saboteur extends Player {

	/**
	 * Constructor for the saboteur.
	 */
	public Saboteur() {
	}

	/**
	 *Method for breaking the field where the player is standing.
	 * @return boolean - returns true if the field is broken.
	 */
	@Override
	public boolean breakField() {
		return getStandingField().breakField();
	}
}