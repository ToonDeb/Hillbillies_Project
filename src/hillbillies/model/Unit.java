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
 * @invar  The hitpoints of each Unit must be a valid hitpoints for this
 *         Unit.
 *       	| isValidHP(getHP())
 * @invar  The stamina of each Unit must be a valid stamina for any
 *         Unit.
 *       	| isValidStamina(getStamina())
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
	 * @post   If the given strength is a valid strength for any starting Unit,
	 *         the strength of this new Unit is equal to the given
	 *         strength. Otherwise, the strength of this new Unit is equal
	 *         to 25.
	 *       | if (isValidStartStrength(strength))
	 *       |   then new.getStrength() == strength
	 *       |   else new.getStrength() == 25
	 * 
	 * @param  agility
	 *         The agility for this new Unit.
	 * @post   If the given agility is a valid agility for any starting Unit,
	 *         the agility of this new Unit is equal to the given
	 *         agility. Otherwise, the agility of this new Unit is equal
	 *         to 25.
	 *       | if (isValidStartAgility(agility))
	 *       |   then new.getAgility() == agility
	 *       |   else new.getAgility() == 25
	 *       
	 * @param  weight
	 *         The weight for this new Unit.
	 * @post   If the given weight is a valid weight for any starting Unit,
	 *         the weight of this new Unit is equal to the given
	 *         weight. Otherwise, the weight of this new Unit is equal
	 *         to 25.
	 *       | if (isValidStartWeight(weight))
	 *       |   then new.getWeight() == weight
	 *       |   else new.getWeight() == 25
	 *       
	 * @param  toughness
	 *         The toughness for this new Unit.
	 * @post   If the given toughness is a valid toughness for any starting Unit,
	 *         the toughness of this new Unit is equal to the given
	 *         toughness. Otherwise, the toughness of this new Unit is equal
	 *         to 25.
	 *       | if (isValidStartToughness(toughness))
	 *       |   then new.getToughness() == toughness
	 *       |   else new.getToughness() == 25
	 *       
	 * @param  stamina
 	 *         The stamina for this new Unit.
 	 * @pre    toughness and weight are valid.
	 * 		 | isValidToughness(toughness) && isValidWeight(weight)  
 	 * @post   The stamina of this new Unit is equal to the given
	 *         stamina.
	 *       | new.getStamina() == 200*(weight()/100)*(toughness()/100)
	 *       
	 * @param  hp
	 *         The hitpoints for this new Unit.
	 * @pre    toughness and weight are valid.
	 * 		 | isValidToughness(toughness) && isValidWeight(weight)       
	 * @post   The hitpoints of this new Unit is equal to the given
	 *         hitpoints.
	 *       | new.getHP() == 200*(weight/100)*(toughness/100)
	 */
	public Unit(int weight, int strength, int agility, int toughness) {
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
		this.setHP(this.getMaxHP());
		this.setStamina(this.getMaxStamina());
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
	 * this Unit.
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
	 * the initialization of this Unit
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
	
	/* END Toughness */
	
	
	/* HP */
	/**
	 * Return the hitpoints of this Unit.
	 */
	@Basic @Raw
	public int getHP() {
		return this.hp;
	}
	
	/**
	 * Return the maximum hitpoints of this Unit.
	 */
	public int getMaxHP(){
		return (int) Math.ceil(200*(this.getWeight()/100.0)*(this.getToughness()/100.0));
	}

	/**
	 * Check whether the given hitpoints is a valid hitpoints for
	 * this Unit.
	 *  
	 * @param  hitpoints
	 *         The hitpoints to check.
	 * @return 
	 *       | ((0 <= hp) && (hp <= this.getMaxHP))
	*/
	public boolean isValidHP(int hp) {
		return (0 <= hp) && (hp <= this.getMaxHP());
	}

	/**
	 * Set the hitpoints of this Unit to the given hitpoints.
	 * 
	 * @param  hp
	 *         The new hitpoints for this Unit.
	 * @pre    The given hitpoints must be a valid hitpoints for this
	 *         Unit.
	 *       | isValidHP(hp)
	 * @post   The hitpoints of this Unit is equal to the given
	 *         hitpoints.
	 *       | new.getHP() == hp
	 */
	@Raw
	public void setHP(int hp) {
		assert isValidHP(hp);
		this.hp = hp;
	}

	/**
	 * Variable registering the hitpoints of this Unit.
	 */
	private int hp;
	
	/* END HP */
	
	
	/* Stamina */
	/**
	 * Return the stamina of this Unit.
	 */
	@Basic @Raw
	public int getStamina() {
		return this.stamina;
	}
	
	/**
	 * Return the maximum stamina of this Unit
	 */
	public int getMaxStamina() {
		return this.getMaxHP();
	}
	
	/**
	 * Check whether the given stamina is a valid stamina for
	 * this Unit.
	 *  
	 * @param  stamina
	 *         The stamina to check.
	 * @return 
	 *       |  ((0 <= stamina) && (stamina <= this.getMaxStamina))
	*/
	public boolean isValidStamina(int stamina) {
		return ((0 <= stamina) && (stamina <= this.getMaxStamina()));
	}
	
	/**
	 * Set the stamina of this Unit to the given stamina.
	 * 
	 * @param  stamina
	 *         The new stamina for this Unit.
	 * @pre    The given stamina must be a valid stamina for any
	 *         Unit.
	 *       | isValidStamina(stamina)
	 * @post   The stamina of this Unit is equal to the given
	 *         stamina.
	 *       | new.getStamina() == stamina
	 */
	@Raw
	public void setStamina(int stamina) {
		assert isValidStamina(stamina);
		this.stamina = stamina;
	}
	
	/**
	 * Variable registering the stamina of this Unit.
	 */
	private int stamina;
	
	/* END Stamina */
	
	
	
}
