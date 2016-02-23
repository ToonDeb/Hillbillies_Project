/**
 * 
 */
package hillbillies.model;

import be.kuleuven.cs.som.annotate.Basic;
import be.kuleuven.cs.som.annotate.Immutable;

/**
 * A class for signaling illegal attack countdowns
 * 
 * @author LaptopToon
 * @version 0.1
 */
public class IllegalAttackCountDownException extends Exception {
	/**
	 * Initialize this new attack countdown exception with given countdown
	 * 
	 * @param time
	 * 		  The value for this new illegal attack countdown
	 * @post  The time of this new illegal attack countdown exception is equal
	 *        to the given time.
	 *      | new.getTime() == time
	 */
	public IllegalAttackCountDownException(double time){
		this.time = time;
	}
	
	/**
	 * Return the value registered for this illegal attack countdown exception.
	 */
	@Basic @Immutable
	public double getTime() {
		return this.time;
	}
	
	private final double time;
	
	private static final long serialVersionUID = 2016001L;

}
