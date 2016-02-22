package hillbillies.model;

import be.kuleuven.cs.som.annotate.*;

/**
 * A class for Units
 * 
 * @invar  The weight of each Unit must be a valid weight for any
 *        	Unit.
 *	  		| isValidWeight(getWeight())
 * @invar  The strength of each Unit must be a valid strength for any
 *			Unit.
 *      	| isValidStrength(getStrength())
 * @invar  The agility of each Unit must be a valid agility for any
 * 			Unit.
 * 			| isValidAgility(getAgility())
 * @invar  The toughness of each Unit must be a valid toughness for any
 *         Unit.
 *       	| isValidToughness(getToughness())	 
 * 
 * @author Toon
 * @version 0.1
 */
public class Unit {
	
	/**
	 * Initialize this new Unit with given strength, agility, weight and .
	 * 
	 * @param  strength
	 *         The strength for this new Unit.
	 * @post   If the given strength is a valid strength for any Unit,
	 *         the strength of this new Unit is equal to the given
	 *         strength. Otherwise, the strength of this new Unit is equal
	 *         to 25.
	 *       | if (isValidStartStrength(strength))
	 *       |   then new.getStrength() == strength
	 *       |   else new.getStrength() == 25
	 * 
	 * @param  agility
	 *         The agility for this new Unit.
	 * @post   If the given agility is a valid agility for any Unit,
	 *         the agility of this new Unit is equal to the given
	 *         agility. Otherwise, the agility of this new Unit is equal
	 *         to 25.
	 *       | if (isValidStartAgility(agility))
	 *       |   then new.getAgility() == agility
	 *       |   else new.getAgility() == 25
	 *       
	 * @param  weight
	 *         The weight for this new Unit.
	 * @post   If the given weight is a valid weight for any Unit,
	 *         the weight of this new Unit is equal to the given
	 *         weight. Otherwise, the weight of this new Unit is equal
	 *         to 25.
	 *       | if (isValidStartWeight(weight))
	 *       |   then new.getWeight() == weight
	 *       |   else new.getWeight() == 25
	 *       
	 * @param  toughness
	 *         The toughness for this new Unit.
	 * @post   If the given toughness is a valid toughness for any Unit,
	 *         the toughness of this new Unit is equal to the given
	 *         toughness. Otherwise, the toughness of this new Unit is equal
	 *         to 25.
	 *       | if (isValidStartToughness(toughness))
	 *       |   then new.getToughness() == toughness
	 *       |   else new.getToughness() == 25
	 */
	public Unit(int strength, int agility, int weight, int toughness) {
		if (! isValidStartStrength(strength))
			strength = 25;
		setStrength(strength);
		if (! isValidStartAgility(agility))
			agility = 25;
		setAgility(agility);
		if (! isValidStartWeight(weight))
			weight = 25;
		setAgility(weight);
		if (! isValidStartToughness(toughness))
			toughness = 25;
		setToughness(toughness);
	}
	
	/* Weight */
	/**
	 * Return the weight of this Unit.
	 */
	@Basic @Raw
	public int getWeight() {
		return this.weight;
	}
	
	/**
	 * Check whether the given weight is a valid weight for
	 * any Unit.
	 *  
	 * @param  weight
	 *         The weight to check.
	 * @return 
	 *       | ((1 < weight) && (weight < 200))
	 *       && (weight >= (this.getStrength() + this.getAgility())/2))
	 */
	public boolean isValidWeight(int weight) {
		return ((1 < weight) && (weight < 200)
				&& (weight >= (this.getStrength() + this.getAgility())/2));
	}
	
	/**
	 * Check whether the given weight is a valid weight for
	 * the initialization of any Unit
	 * 
	 * @param 	weight
	 * 			The weight to check
	 * @return 
	 *		|((25 <= weight) && (weight <= 100) 
	 * 		&& (weight >= (this.getStrength() + this.getAgility())/2))
	 */
	public boolean isValidStartWeight(int weight){
		return ((25 <= weight) && (weight <= 100) 
				&& (weight >= (this.getStrength() + this.getAgility())/2));
	}
	
	/**
	 * Set the weight of this Unit to the given weight.
	 * 
	 * @param  weight
	 *         The new weight for this Unit.
	 * @post   If the given weight is a valid weight for any Unit,
	 *         the weight of this new Unit is equal to the given
	 *         weight.
	 *       | if (isValidWeight(weight))
	 *       |   then new.getWeight() == weight
	 */
	@Raw
	public void setWeight(int weight) {
		if (isValidWeight(weight))
			this.weight = weight;
	}
	
	/**
	 * Variable registering the weight of this Unit.
	 */
	private int weight;
	
	/* END Weight*/
	
	
	/* Strength*/
	/**
	 * Return the strength of this Unit.
	 */
	@Basic @Raw
	public int getStrength() {
		return this.strength;
	}
	
	/**
	 * Check whether the given strength is a valid strength for
	 * any Unit.
	 *  
	 * @param  strength
	 *         The strength to check.
	 * @return 
	 *       | ((1 < strength) && (strength < 200))
	*/
	public static boolean isValidStrength(int strength) {
		return ((0 < strength) && (strength <= 200));
	}
	
	/**
	 * Check whether the given strength is a valid strength for
	 * the initialization of any Unit
	 * 
	 * @param 	strength
	 * 			The strength to check
	 * @return ((25 <= strength) && (strength <= 100))
	 */
	public static boolean isValidStartStrength(int strength){
		return ((25 <= strength) && (strength <= 100));
	}
	
	/**
	 * Set the strength of this Unit to the given strength.
	 * 
	 * @param  strength
	 *         The new strength for this Unit.
	 * @post   If the given strength is a valid strength for any Unit,
	 *         the strength of this new Unit is equal to the given
	 *         strength.
	 *       | if (isValidStrength(strength))
	 *       |   then new.getStrength() == strength
	 */
	@Raw
	public void setStrength(int strength) {
		if (isValidStrength(strength))
			this.strength = strength;
	}
	
	/**
	 * Variable registering the strength of this Unit.
	 */
	private int strength;
	
	/*END Strength*/

	
	/* Agility*/
	/**
	 * Return the agility of this Unit.
	 */
	@Basic @Raw
	public int getAgility() {
		return this.agility;
	}
	
	/**
	 * Check whether the given agility is a valid agility for
	 * any Unit.
	 *  
	 * @param  agility
	 *         The agility to check.
	 * @return 
	 *       | ((1 < agility) && (agility < 200))
	*/
	public static boolean isValidAgility(int agility) {
		return ((0 < agility) && (agility <= 200));
	}
	
	/**
	 * Check whether the given agility is a valid agility for
	 * the initialization of any Unit
	 * 
	 * @param 	strength
	 * 			The strength to check
	 * @return ((25 <= strength) && (strength <= 100))
	 */
	public static boolean isValidStartAgility(int agility){
		return ((25 <= agility) && (agility <= 100));
	}
	
	/**
	 * Set the agility of this Unit to the given agility.
	 * 
	 * @param  agility
	 *         The new agility for this Unit.
	 * @post   If the given agility is a valid agility for any Unit,
	 *         the agility of this new Unit is equal to the given
	 *         agility.
	 *       | if (isValidAgility(agility))
	 *       |   then new.getAgility() == agility
	 */
	@Raw
	public void setAgility(int agility) {
		if (isValidAgility(agility))
			this.agility = agility;
	}
	
	/**
	 * Variable registering the agility of this Unit.
	 */
	private int agility;
	
	/* END Agility */
	
	/*Toughness*/

	/**
	 * Return the toughness of this Unit.
	 */
	@Basic @Raw
	public int getToughness() {
		return this.toughness;
	}
	
	/**
	 * Check whether the given toughness is a valid toughness for
	 * any Unit.
	 *  
	 * @param  toughness
	 *         The toughness to check.
	 * @return 
	 *       | result == 
	*/
	public static boolean isValidToughness(int toughness) {
		return false;
	}
	
	/**
	 * Check whether the given toughness is a valid toughness for
	 * the initialization of any Unit
	 * 
	 * @param 	toughness
	 * 			The weight to check
	 * @return 
	 *		|((25 <= weight) && (weight <= 100) 
	 */
	public boolean isValidStartToughness(int toughness){
		return ((25 <= toughness) && (toughness <= 100));
	}
	
	/**
	 * Set the toughness of this Unit to the given toughness.
	 * 
	 * @param  toughness
	 *         The new toughness for this Unit.
	 * @post   If the given toughness is a valid toughness for any Unit,
	 *         the toughness of this new Unit is equal to the given
	 *         toughness.
	 *       | if (isValidToughness(toughness))
	 *       |   then new.getToughness() == toughness
	 */
	@Raw
	public void setToughness(int toughness) {
		if (isValidToughness(toughness))
			this.toughness = toughness;
	}
	
	/**
	 * Variable registering the toughness of this Unit.
	 */
	private int toughness;
	
	/* END Toughness*/

}
