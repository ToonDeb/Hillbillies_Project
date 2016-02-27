/**
 * 
 */
package hillbillies.model;

import be.kuleuven.cs.som.annotate.*;

/**
 * @author Nathan
 * @version 0.1
 */
public class InvalidPositionException extends Exception{
	
	private final double[] position;

	/**
	 * Initializes this new invalid position exception with given position.
	 * @param position
	 * @post	 The value of this exception equals the given position.
	 * 			| new.getPosition() == position
	 */
	
	public InvalidPositionException(double[] position) {
		this.position = position;
	}
	/**
	 * Returns the position registered for this exception.
	 */
	@Basic
	@Immutable
	public double[] getPosition() {
		return this.position;
	}
}
