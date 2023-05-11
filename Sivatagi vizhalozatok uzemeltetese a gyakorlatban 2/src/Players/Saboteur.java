package Players;

import Controll.Controller;
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

	public boolean makeSlippery(){
		boolean result = this.getStandingField().makeSlippery();
		return result;
	}

	@Override
	public String toString() {
		return "name: "+ Controller.objectReverseNames.get(this)
				+ "\nstandingField: " + Controller.objectReverseNames.get(this.getStandingField()) + "\n";
	}
}