package hillbillies.model;

import be.kuleuven.cs.som.annotate.*;
/**
 * A class of Vector3Ds involving co�rdinates. 
 * @author Nathan
 * @version 1.0
 */

public class Vector3D {


	/** TO BE ADDED TO CLASS HEADING
	 * @invar  The co�rdinates of each Vector3D must be a valid co�rdinates for any
	 *         Vector3D.
	 *       | isValidCo�rdinates(getCo�rdinates())
	 */


	/**
	 * Initialize this new Vector3D with given co�rdinates.
	 *
	 * @param  co�rdinates
	 *         The co�rdinates for this new Vector3D.
	 * @effect The co�rdinates of this new Vector3D is set to
	 *         the given co�rdinates.
	 *       | this.setCo�rdinates(co�rdinates)
	 */
	public Vector3D(double[] co�rdinates)
			throws IllegalArgumentException {
		this.setCo�rdinates(co�rdinates);
	}


	/**
	 * Return the co�rdinates of this Vector3D.
	 */
	@Basic @Raw
	public double[] getCo�rdinates() {
		return this.co�rdinates;
	}

	/**
	 * Check whether the given co�rdinates is a valid co�rdinates for
	 * any vector3D.
	 *  
	 * @param  co�rdinates
	 *         The co�rdinates to check.
	 * @return 
	 *       | result == 
	*/
	public static boolean isValidCo�rdinates(double[] co�rdinates) {
		return false;
	}
	/**
	 * Set the co�rdinates of this 3Dvector to the given co�rdinates.
	 * 
	 * @param  co�rdinates
	 *         The new co�rdinates for this 3Dvector.
	 * @post   The co�rdinates of this new 3Dvector is equal to
	 *         the given co�rdinates.
	 *       | new.getCo�rdinates() == co�rdinates
	 * @throws IllegalArgumentException
	 *         The given co�rdinates is not a valid co�rdinates for any
	 *         3Dvector.
	 *       | ! isValidCo�rdinates(getCo�rdinates())
	 */
	@Raw
	public void setCo�rdinates(double[] co�rdinates) 
			throws IllegalArgumentException {
		if (! isValidCo�rdinates(co�rdinates))
			throw new IllegalArgumentException();
		this.co�rdinates = co�rdinates;
	}

	/**
	 * Variable registering the co�rdinates of this 3Dvector.
	 */
	private double[] co�rdinates;

}
