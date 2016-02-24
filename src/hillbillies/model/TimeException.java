/**
 * 
 */
package hillbillies.model;

import be.kuleuven.cs.som.annotate.Basic;
import be.kuleuven.cs.som.annotate.Immutable;

/**
 * A class for signaling illegal time
 * 
 * @author LaptopToon
 * @version 0.1
 *
 */
public class TimeException extends Exception {
	
	/**
	 * Initialize this new time exception with given time
	 * 
	 * @param time
	 * 		  The value for this new illegal time
	 * @post  The value of this new illegal time exception is equal
	 *        to the given value.
	 *      | new.getValue() == value
	 */
	public TimeException(double time){
		this.time = time;
	}
	
	/**
	 * Return the value registered for this illegal time exception.
	 */
	@Basic @Immutable
	public double getValue() {
		return this.time;
	}
	
	private final double time;
	
	private static final long serialVersionUID = 2016001L;
}
