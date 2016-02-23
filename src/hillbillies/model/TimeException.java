/**
 * 
 */
package hillbillies.model;

import be.kuleuven.cs.som.annotate.Basic;
import be.kuleuven.cs.som.annotate.Immutable;

/**
 * @author LaptopToon
 *
 */
public class TimeException extends Exception {
	
	/**
	 * Initialize this new time exception with given operands
	 * 
	 * @param worktime
	 * 		  The value for this new illegal time
	 * @post  The value of this new illegal time exception is equal
	 *        to the given value.
	 *      | new.getValue() == value
	 */
	public TimeException(double time){
		this.time = time;
	}
	
	/**
	 * Return the value registered for this illegal worktime exception.
	 */
	@Basic @Immutable
	public double getValue() {
		return this.time;
	}
	
	private final double time;
	
	private static final long serialVersionUID = 2016001L;
}
