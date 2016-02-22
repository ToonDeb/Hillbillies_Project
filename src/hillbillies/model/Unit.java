package hillbillies.model;
/**
 * 
 */

import be.kuleuven.cs.som.annotate.*;

/**
 * @authors Toon, Nathan
 * @version 0.1
 */
public class Unit {

	private double[] position;

	/**
	 * 
	 * Returns the position of the unit.
	 * 
	 */
	@Basic
	public double[] getPosition() {
		return this.position;
	}
	
	/**
	 * 
	 * @param position
	 */
	public void setPosition(double[] position) {
		if (isValidPosition(position))
			this.position = position;
		else
			throw InvalidPositionException(position);
	}
	public boolean isValidPosition(double[] position) {
		return (position[1] >= 0 ) && (position[1] < 50)
				&& (position[2] >= 0 ) && (position[2] < 50)
				&& (position[3] >= 0 ) && (position[3] < 50);
	}
}