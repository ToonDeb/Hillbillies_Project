package hillbillies.model;

import be.kuleuven.cs.som.annotate.Basic;
import be.kuleuven.cs.som.annotate.Immutable;

/**
 * A class for signaling illegal attacks
 * 
 * @author LaptopToon
 * @version 0.1
 */
public class IllegalAttackException extends Exception {
	
	/**
	 * Initialize this new illegal attack exception with given position
	 * 
	 * @param attPosition
	 * 		  The illegal position of the attacked Unit
	 * @post  The position of this new illegal attack exception is equal
	 *        to the given position, for the attacking and defending Units.
	 *      | new.getAttackPosition() == attPosition
	 *      | new.getDefendPosition() == defPosition
	 */
	public IllegalAttackException(double[] attPosition, double[] defPosition){
		this.attPosition = attPosition;
		this.defPosition = defPosition;
	}
	
	/**
	 * Return the attacking position registered for this illegal attack exception.
	 */
	@Basic @Immutable
	public double[] getAttackPosition() {
		return this.attPosition;
	}
	
	/**
	 * Return the defending position registered for this illegal attack exception
	 */
	@Basic @Immutable
	public double[] getDefendPosition() {
		return this.defPosition;
	}
	
	private final double[] attPosition;
	private final double[] defPosition;
	
	private static final long serialVersionUID = 2016001L;
}	

