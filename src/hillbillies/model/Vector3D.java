package hillbillies.model;

import be.kuleuven.cs.som.annotate.*;
/**
 * A class of Vector3Ds involving coördinates. 
 * @author Nathan
 * @version 1.0
 */

public class Vector3D {


	/** TO BE ADDED TO CLASS HEADING
	 * @invar  The coördinates of each Vector3D must be a valid coördinates for any
	 *         Vector3D.
	 *       | isValidCoördinates(getCoördinates())
	 */


	/**
	 * Initialize this new Vector3D with given coördinates.
	 *
	 * @param  coördinates
	 *         The coördinates for this new Vector3D.
	 * @effect The coördinates of this new Vector3D is set to
	 *         the given coördinates.
	 *       | this.setCoördinates(coördinates)
	 */
	public Vector3D(double[] coördinates)
			throws IllegalArgumentException {
		this.setCoördinates(coördinates);
	}


	/**
	 * Return the coördinates of this Vector3D.
	 */
	@Basic @Raw
	public double[] getCoördinates() {
		return this.coördinates;
	}

	/**
	 * Check whether the given coördinates is a valid coördinates for
	 * any vector3D.
	 *  
	 * @param  coördinates
	 *         The coördinates to check.
	 * @return 
	 *       | result == 
	*/
	public static boolean isValidCoördinates(double[] coördinates) {
		return false;
	}
	/**
	 * Set the coördinates of this 3Dvector to the given coördinates.
	 * 
	 * @param  coördinates
	 *         The new coördinates for this 3Dvector.
	 * @post   The coördinates of this new 3Dvector is equal to
	 *         the given coördinates.
	 *       | new.getCoördinates() == coördinates
	 * @throws IllegalArgumentException
	 *         The given coördinates is not a valid coördinates for any
	 *         3Dvector.
	 *       | ! isValidCoördinates(getCoördinates())
	 */
	@Raw
	public void setCoördinates(double[] coördinates) 
			throws IllegalArgumentException {
		if (! isValidCoördinates(coördinates))
			throw new IllegalArgumentException();
		this.coördinates = coördinates;
	}

	/**
	 * Variable registering the coördinates of this 3Dvector.
	 */
	private double[] coördinates;

}
