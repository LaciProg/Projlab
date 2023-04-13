package Players;

import Controll.Szkeleton;
import Fields.Field;


/**
 * Class for the saboteur player.
 * */
public class Saboteur extends Player {

	/**
	 * @param standingField Field
	 */
	public Saboteur(Field standingField) {
		super(standingField);
		Szkeleton.printTabs();
		System.out.println("new Saboteur()");
	}

	/**
	 *Method for breaking the field where the player is standing.
	 * @return boolean - returns true if the field is broken.
	 */
	@Override
	public boolean breakField() {
		Szkeleton.printTabs();
		System.out.println(Szkeleton.objectNames.get(this)+ ".breakField()");
		Szkeleton.tabs++;
		boolean result = getStandingField().breakField();
		Szkeleton.tabs--;
		return result;
	}
}