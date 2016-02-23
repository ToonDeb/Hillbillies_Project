package hillbillies.model;

import be.kuleuven.cs.som.annotate.Basic;
import be.kuleuven.cs.som.annotate.Immutable;

/**
 * A class for signaling illegal positions
 * 
 * @author LaptopToon
 * @version 0.1
 */
public class IllegalPositionException extends Exception {
	
	/**
	 * Initialize this new position exception with given time
	 * 
	 * @param position
	 * 		  The illegal position of the Unit
	 * @post  The value of this new illegal position exception is equal
	 *        to the given value.
	 *      | new.getPosition() == position
	 */
	public IllegalPositionException(double[] position){
		this.position = position;
	}
	
	/**
	 * Return the position registered for this illegal position
	 */
	@Basic @Immutable
	public double [] getPosition(){
		return this.position;
	}
	
	private final double[] position;
	
	private static final long serialVersionUID = 2016001L;
}
