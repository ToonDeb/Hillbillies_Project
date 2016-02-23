/**
 * 
 */
package hillbillies.model;

import be.kuleuven.cs.som.annotate.*;

/**
 * A class for signaling illegal worktime
 * 
 * @author LaptopToon
 * @version 0.1
 *
 */
public class WorkTimeException extends Exception {
	
	/**
	 * Initialize this new worktime exception with given operands
	 * 
	 * @param worktime
	 * 		  The value for this new illegal worktime
	 * @post  The value of this new illegal worktime exception is equal
	 *        to the given value.
	 *      | new.getValue() == value
	 */
	public WorkTimeException(double worktime){
		this.worktime = worktime;
	}
	
	/**
	 * Return the value registered for this illegal worktime exception.
	 */
	@Basic @Immutable
	public double getValue() {
		return this.worktime;
	}
	
	private final double worktime;
	
	private static final long serialVersionUID = 2016001L;
}
