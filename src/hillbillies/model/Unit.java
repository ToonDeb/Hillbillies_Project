package hillbillies.model;

import hillbillies.model.UnitStatus;



import java.util.Random;

import javax.vecmath.*;

import be.kuleuven.cs.som.annotate.*;
import ogp.framework.util.Util;

/**TODO declare variables for boundary and other constant values

/**
 * @authors Toon, Nathan
 * A class for Units
 *
 * @invar  The position of each Unit must be a valid position for any
 *         Unit.
 *       | isValidPosition(getPosition())
 *
 * @invar  The weight of each Unit must be a valid weight for any
 *        	Unit.
 *	  		| isValidWeight(getWeight())
 * @invar  The strength of each Unit must be a valid strength for any
 *			Unit.
 *      	| isValidUnitAttribute(getStrength())
 * @invar  The agility of each Unit must be a valid agility for any
 * 			Unit.
 * 			| isValidUnitAttribute(getAgility())
 * @invar  The toughness of each Unit must be a valid toughness for any
 *         Unit.
 *       	| isValidUnitAttribute(getToughness())
 *
 * @invar  The hitpoints of each Unit must be a valid hitpoints for this
 *         Unit.
 *       	| isValidHP(getHP())
 * @invar  The stamina of each Unit must be a valid stamina for any
 *         Unit.
 *       	| isValidStamina(getStamina())
 *
 * @invar  The workTime of each Unit must be a valid workTime for any
 *         Unit.
 *       | isValidWorkTime(getWorkTime())
 *
 * @invar  The attackCountDown of each Unit must be a valid attackCountDown for any
 *         Unit.
 *       | isValidAttackCountDown(getAttackCountDown())
 *
 * @invar  The status of each Unit must be a valid status for any
 *         Unit.
 *        | isValidStatus(getStatus())
 *
 * @invar  The restTime of each Unit must be a valid restTime for any
 *         Unit.
 *       | isValidRestTime(getRestTime())
 * 
 * @invar  The name of each unit must be a valid name for any
 *         unit.
 *       | isValidName(getName())
 *
 * @invar  The defaultBoolean of each Unit must be a valid defaultBoolean for any
 *         Unit.
 *       | isValidDefaultBoolean(getDefaultBoolean())
 * @invar  The orientation of each unit must be a valid orientation for any
 *         unit.
 *       | isValidOrientation(getOrientation())
 * @invar  The destination of each unit must be a valid destination for any
 *         unit.
 *       | isValidDestination(getDestination())
 *
 * @version 0.1
 */
public class Unit {


	/**
	 * Initialize this new Unit with given position, strength, agility, weight and toughness.
	 *
	 *
	 *
	 * @param  position
	 *         The position for this new Unit.
	 * @effect The position of this new Unit is set to
	 *         the given position.
	 *       | this.setPosition(position)
	 *
	 * @param  strength
	 *         The strength for this new Unit.
	 * @post   If the given strength is a valid strength for any starting Unit,
	 *         the strength of this new Unit is equal to the given
	 *         strength. Otherwise, the strength of this new Unit is equal
	 *         to 25.
	 *       | if (isValidStartAttribute(strength))
	 *       |   then new.getStrength() == strength
	 *       |   else new.getStrength() == 25
	 *
	 * @param  agility
	 *         The agility for this new Unit.
	 * @post   If the given agility is a valid agility for any starting Unit,
	 *         the agility of this new Unit is equal to the given
	 *         agility. Otherwise, the agility of this new Unit is equal
	 *         to 25.
	 *       | if (isValidStartAttribute(agility))
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
	 *       | if (isValidStartAttribute(toughness))
	 *       |   then new.getToughness() == toughness
	 *       |   else new.getToughness() == 25
	 *       
	 * @post	the orientation of this new Unit is PI/2
	 * 			| new.getOrientation == PI/2
	 * xxxxxxxxxxONNODIGxxxxxxxxx
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
	 *
	 * @param  name
	 *         The name for this new unit.
	 * @effect The name of this new unit is set to
	 *         the given name.
	 *       | this.setName(name)
	 * @throws 	IllegalArgumentException
	 * 	
	 * @param  destination
	 *         The destination for this new unit.
	 * @effect The destination of this new unit is set to
	 *         the given destination.
	 *       | this.setDestination(destination)
	 * xxxxxxxxxxONNODIGxxxxxxxxx
	 */
	public Unit(String name, Vector3d position, int weight, int strength, int agility, int toughness)
			throws IllegalArgumentException {

		if (! isValidStartAttribute(strength))
			strength = 25;
		setStrength(strength);
		if (! isValidStartAttribute(agility))
			agility = 25;
		setAgility(agility);
		if (! isValidStartWeight(weight))
			weight = (this.getStrength() + this.getAgility())/2;
		setWeight(weight);
		if (! isValidStartAttribute(toughness))
			toughness = 25;
		setToughness(toughness);
		this.setHP(this.getMaxHP());
		this.setStamina(this.getMaxStamina());
		this.setPosition(position);

		this.setName(name);

		this.setStatus(UnitStatus.IDLE);
	}

	/* Position */
	/**
	 * Return the position of this Unit.
	 */
	@Basic @Raw
	public Vector3d getPosition() {
		return this.position;
	}
	
	/**
	 * Return the position of the cube occupied by this Unit.
	 */
	public int[] getCubePosition() {
		int cubeX = (int) Math.floor(position.x);
		int cubeY = (int) Math.floor(position.y);
		int cubeZ = (int) Math.floor(position.z);
		int []cubePosition = {cubeX, cubeY, cubeZ};
		return cubePosition;
	}
	
	/**
	 * Check whether the given position is a valid position for
	 * any Unit.
	 *
	 * @param  position
	 *         The position to check.
	 * @return	False if the given position is not effective.
	 *		|	if (position == null)
	 *		|		then result == false
	 *			Otherwise, true if all three coordinates are within the boundaries of the map
	 *		|	else if
	 *		|		(position.x >= 0) && (position.x < 50) &&
	 *		|		(position.y >= 0) && (position.y < 50) &&
	 *		|		(position.z >= 0) && (position.z < 50)
	 *		|			then result == true
	 */
	public static boolean isValidPosition(Vector3d position) {
		return position != null &&
				(position.x >= 0) && (position.x < 50) &&
				 (position.y >= 0) && (position.y < 50) &&
				  (position.z >= 0) && (position.z < 50);
	}

	/**
	 * Set the position of this Unit to the given position.
	 *
	 * @param  position
	 *         The new position for this Unit.
	 * @post   The position of this Unit is equal to the given position.
	 *       | new.getPosition() == position
	 * @throws IllegalArgumentException
	 *         The given position is not a valid position for any Unit.
	 *       | ! isValidPosition(this.getPosition())
	 */
	@Raw
	public void setPosition(Vector3d position) throws IllegalArgumentException {
		if (! isValidPosition(position))
			throw new IllegalArgumentException("the given position is not a valid position");
		this.position = position;
	}
	
	/**
	 * Variable registering the position of this Unit.
	 */
	private Vector3d position;

	/* END Position */
	
	/*Movement*/
	
	/**
	 * Returns a velocity vector that is used to update the units position in advanceTime
	 * as it goes to a neighbouring cube.
	 * 
	 * @param destination
	 * 			The neighbouring destination
	 * @return The velocity vector with as norm the speed of the vector, 
	 * 		   and the same direction as the difference between destination and the current position.
	 */
	public Vector3d moveToAdjacent(Vector3d destination) {
		double xDistance = destination.x - this.getPosition().x;
		double yDistance = destination.x - this.getPosition().y;
		double zDistance = destination.x - this.getPosition().z;
		
		float totalDistance = (float) Math.sqrt(Math.pow(xDistance, 2) +
										Math.pow(yDistance, 2)+ 
											Math.pow(zDistance, 2));
		float speed = this.getSpeed();
		
		Vector3d velocity = new Vector3d(speed*xDistance/totalDistance, 
				speed*yDistance/totalDistance, 
				speed*zDistance/totalDistance);
		return velocity;	
	}
	
	/*END movement*/
	/* Name*/
	/**
	 * Return the name of this unit.
	 */
	@Basic @Raw
	public String getName() {
		return this.name;
	}

	/**
	 * Check whether the given name is a valid name for
	 * any unit.
	 *
	 * @param  name
	 *         The name to check.
	 * @return False if the given name is not effective.
	 *       | if (name == null)
	 *       |	then result == false
	 *       Otherwise, false if the name is shorter than two characters
	 *       | else if (name.length < 2)
	 *       |	then result == false
	 *       Otherwise, false if the name doesn't begin with an uppercase letter
	 *       | else if (!name.substring(0,1).matches("A-Z"))
	 *       |	then result == false
	 *       Otherwise, true if the name after the first character only consists of letters
	 *       (upper case and lower case), quotes (singles and doubles) and spaces
	 *       | else if (name[1:].matches("[A-Za-z\'\" ]+"))
	 *       |	then result == true
	 *
	*/
	public static boolean isValidName(String name) {
		if (name == null)
			return false;
		if (name.length() < 2)
			return false;
		if (! Character.isUpperCase(name.charAt(0)))
			return false;
		return (name.matches("[A-Za-z\'\" ]+"));
		

	}

	/**
	 * Set the name of this unit to the given name.
	 *
	 * @param  name
	 *         The new name for this unit.
	 * @post   The name of this new unit is equal to
	 *         the given name.
	 *       | new.getName() == name
	 * @throws IllegalArgumentException
	 *         The given name is not a valid name for any
	 *         unit.
	 *       | ! isValidName(getName())
	 */
	@Raw
	public void setName(String name)
			throws IllegalArgumentException {
		if (! isValidName(name))
			throw new IllegalArgumentException();
		this.name = name;
	}

	/**
	 * Variable registering the name of this unit.
	 */
	private String name;

	/* END Name*/
	
	/*Orientation*/

	/**
	 * Return the orientation of this unit.
	 */
	@Basic @Raw
	public float getOrientation() {
		return this.orientation;
	}

	/**
	 * Check whether the given orientation is a valid orientation for
	 * any unit.
	 *  
	 * @param  orientation
	 *         The orientation to check.
	 * @return 
	 *		   The orientation of the unit is between 0 and 2*Math.PI 		 	
	 *       | orientation >= 0 && orientation < 2*Math.PI
	 *       
	*/
	public static boolean isValidOrientation(float orientation) {
		return orientation >= 0 && orientation < 2*Math.PI;
	}


	/**
	 * Set the orientation of this unit to the given orientation.
	 * 
	 * @param  orientation
	 *         The new orientation for this unit.
	 * @post   The orientation is set to the physically corresponding orientation between 0 and 2*Math.PI
	 *       | new.getOrientation() == correspondingOrientation
	 */
	@Raw
	public void setOrientation(float orientation) {
		if (orientation >= 0)
			this.orientation = (float) (orientation % 2*Math.PI);
		else 
			this.orientation = (float) (2*Math.PI - ( -orientation % 2*Math.PI));
	}

	/**
	 * Variable registering the orientation of this unit.
	 */
	private float orientation = (float) Math.PI/2;


	/**
	 * Set the orientation of THIS Unit to face the other Unit
	 *
	 * @param 	other
	 * 			the other unit, to which we will face
	 * @post	The orientation of this Unit is towards the other Unit.
	 * 			| new.getOrientation() == Math.atan2(y_other - y_this, x_other - x_this)
	 * @throws  IllegalArgumentException
	 * 			the given other unit is not in a valid position
	 * 			| ! this.canAttack(other)
	 */
	public void face(Unit other) throws IllegalArgumentException{
		if (! this.canAttack(other))
			throw new IllegalArgumentException("the other unit is not on a valid position");
		double x_this = this.getPosition().x;
		double y_this = this.getPosition().y;
		double x_other = other.getPosition().x;
		double y_other = other.getPosition().y;
		
		float this_orientation = (float) Math.atan2(y_other - y_this, x_other - x_this);
				
		this.setOrientation(this_orientation);

	}
	
	/* END orientation */

	/**TODO:implementatie
	 * The Unit moves instantaniously to a random position bordering its current position
	 * This new position is a valid position in the gameworld
	 *
	 * @post	the Unit is in a valid position
	 * 			| new.getPosition() == ...
	 *
	 */
	public void dodge() {

	}



	/** TODO:canAttack
	 * Check whether this Unit can attack the other Unit
	 *
	 * @param 	other
	 * 			the unit being attacked
	 * @return  True if and only if the other unit occupies a cube that, in regards to the cube this unit occupies
	 * 			has the  same z-coordinate, 
	 * 			an x-coordinate differing no more than 1 and 
	 * 			a y-coordinate differing no more than 1.
	 * 		  | return (this.getCubePosition.z == other.getCubePosition.z) &&
	 * 		  |  (abs(this.getCubePosition.x - other.getCubePosition.x) < 2) &&
	 * 		  |  (abs(this.getCubePosition.y - other.getCubePosition.y) < 2)
	 * @throws	IllegalArgumentException
	 * 			The other unit is not effective
	 * 		  | other == null
	 */
	public boolean canAttack(Unit other) throws IllegalArgumentException{ 
		if (other == null)
			throw new IllegalArgumentException("Non effective unit");
		return (this.getCubePosition()[2] == other.getCubePosition()[2]) &&
				(Math.abs(this.getCubePosition()[0] - other.getCubePosition()[0]) < 2) &&
				(Math.abs(this.getCubePosition()[1]- other.getCubePosition()[1]) < 2);
	}
	
	/**TODO: movetorandom expand documentation
	 * set a random destination in the gameworld
	 * @post	the status of this unit is "walking"
	 * 			| new.getStatus() == UnitStatus.WALKING
	 * 
	 */
	public void moveToRandom(){
		
	}
	
	
	
	
	
	/* Speed */
	/**
	 * Return the base speed of this unit.
	 */
	public float getBaseSpeed() {
		return (float) (1.5*(this.getStrength()+  this.getAgility())/
				(200*weight/100));
	}
	/**
	 * Return the speed of this unit.
	 */
	public float getSpeed() throws IllegalStateException{
		
		float vbase = this.getBaseSpeed();
		float v;
		UnitStatus status = this.getStatus();
		
		if (!(status == UnitStatus.WALKING) || !(status == UnitStatus.SPRINTING))
			throw new IllegalStateException("Unit not moving!");
		
		if (Util.fuzzyEquals(this.getPosition().z - this.getDestination().z, -1))
				v = (float) (0.5*vbase);
		else if (Util.fuzzyEquals(this.getPosition().z - this.getDestination().z, 1))
				v = (float) (1.2*vbase);
		else
			v = vbase;
		
		
		if (status == UnitStatus.SPRINTING)
				return (float) 2*v;
		return (float) v;		
	}
	
	/*END speed*/
	/* destination */
	
	/**
	 * Return the destination of this unit.
	 */
	@Basic @Raw
	public Vector3d getDestination() {
		return this.destination;
	}
	
	/**
	 * Check whether the given destination is a valid destination for
	 * this unit.
	 *  
	 * @param  destination
	 *         The destination to check.
	 * @return If the unit is walking, true if the destination is a valid position.
	 *       | if (this.getStatus == WALKING)
	 *       | 		then return isValidPosition(destination)
	 *         If the unit is not walking, true if the destination is null
	 *       | else
	 *       | 		return (destination == null)
	*/
	public boolean isValidDestination(Vector3d destination) {
		if (this.getStatus() == UnitStatus.WALKING)
			return isValidPosition(destination);
		return destination == null;
	}
	
	/**
	 * Set the destination of this unit to the given destination.
	 * 
	 * @param  destination
	 *         The new destination for this unit.
	 * @post   The destination of this new unit is equal to
	 *         the given destination.
	 *       | new.getDestination() == destination
	 * @throws IllegalArgumentException
	 *         The given destination is not a valid destination for any
	 *         unit.
	 *       | ! isValidDestination(getDestination())
	 */
	@Raw
	public void setDestination(Vector3d destination) 
			throws IllegalArgumentException {
		if (! isValidDestination(destination))
			throw new IllegalArgumentException();
		this.destination = destination;
	}
	
	/**
	 * Variable registering the destination of this unit.
	 */
	private Vector3d destination = null;
	
	/*END destination*/
	
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
	 *       | result == ((1 < weight) && (weight < 200))
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
	 *		| result == ((25 <= weight) && (weight <= 100)
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
	 *       |   	then new.getWeight() == weight
	 *       | else
	 *		 |		this.weight = (this.getStrength() + this.getAgility())/2
	 */
	@Raw
	public void setWeight(int weight) {
		if (isValidWeight(weight))
			this.weight = weight;
		else
			this.weight = (this.getStrength() + this.getAgility())/2;
	}

	/**
	 * Variable registering the weight of this Unit.
	 */
	private int weight;
	
	/* END Weight*/
	
	/* Attributes */
	/**
	 * Check whether the given attribute is a valid attribute for
	 * any Unit.
	 *
	 * @param  attribute
	 *         The attribute to check.
	 * @return
	 *       | result == ((1 <= attribute) && (attribute < 200))
	*/
	public static boolean isValidUnitAttribute(int attribute) {
		return ((1 <= attribute) && (attribute <= 200));
	}

	/**
	 * Check whether the given attribute is a valid attribute for
	 * the initialization of any Unit
	 *
	 * @param 	toughness
	 * 			The attribute to check
	 * @return
	 *		| result == ((25 <= attribute) && (attribute <= 100)
	 */
	public static boolean isValidStartAttribute(int attribute){
		return ((25 <= attribute) && (attribute <= 100));
	}
	
	/* Strength*/
	/**
	 * Return the strength of this Unit.
	 */
	@Basic @Raw
	public int getStrength() {
		return this.strength;
	}

	/**
	 * Set the strength of this Unit to the given strength.
	 *
	 * @param  strength
	 *         The new strength for this Unit.
	 * @post   If the given strength is a valid strength for any Unit,
	 *         the strength of this new Unit is equal to the given
	 *         strength.
	 *       | if (isValidUnitAttribute(strength))
	 *       |   	then new.getStrength() == strength
	 *       | else
	 *       		new.getStrength() == 25
	 */
	@Raw
	public void setStrength(int strength) {
		if (isValidUnitAttribute(strength))
			this.strength = strength;
		else
			this.strength = 25;
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
	 * Set the agility of this Unit to the given agility.
	 *
	 * @param  agility
	 *         The new agility for this Unit.
	 * @post   If the given agility is a valid agility for any Unit,
	 *         the agility of this new Unit is equal to the given
	 *         agility.
	 *       | if (isValidUnitAttribute(agility))
	 *       |   then new.getAgility() == agility
	 *       | else
	 *       |	 new.getAgility() == 25
	 */
	@Raw
	public void setAgility(int agility) {
		if (isValidUnitAttribute(agility))
			this.agility = agility;
		else
			this.agility = 25;
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
	 * Set the toughness of this Unit to the given toughness.
	 *
	 * @param  toughness
	 *         The new toughness for this Unit.
	 * @post   If the given toughness is a valid toughness for any Unit,
	 *         the toughness of this new Unit is equal to the given
	 *         toughness.
	 *       | if (isValidUnitAttribute(toughness))
	 *       |   then new.getToughness() == toughness
	 *		 | else
	 *		 | 	 new.getToughness() == 25
	 */
	@Raw
	public void setToughness(int toughness) {
		if (isValidUnitAttribute(toughness))
			this.toughness = toughness;
		else
			this.toughness = 25;
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
	 *       | result == ((0 <= hp) && (hp <= this.getMaxHP))
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
	 *       |  result == ((0 <= stamina) && (stamina <= this.getMaxStamina))
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
	
	/* END Attribute*/
	
	
	/* Work */
	/**
	 * Start the work-condition
	 * @throws IllegalArgumentException
	 *         The given workTime is not a valid workTime for any
	 *         Unit.
	 *       | ! isValidWorkTime(getWorkTime())
	 */
	public void work() throws IllegalArgumentException {
		this.setWorkTime(500.0d /strength);
		this.setStatus(UnitStatus.WORKING);
	}

	/**
	 * Return the workTime of this Unit.
	 */
	@Basic @Raw
	private double getWorkTime() {
		return this.worktime;
	}

	/**
	 * Check whether the given workTime is a valid workTime for
	 * any Unit.
	 *
	 * @param  workTime
	 *         The workTime to check.
	 * @return
	 *       | result == (worktime >= 0)
	*/
	private static boolean isValidWorkTime(double worktime) {
		return Util.fuzzyGreaterThanOrEqualTo(worktime, 0);
	}

	/**
	 * Set the workTime of this Unit to the given workTime.
	 *
	 * @param  worktime
	 *         The new workTime for this Unit.
	 * @post   The workTime of this new Unit is equal to
	 *         the given workTime.
	 *       | new.getWorkTime() == worktime
	 * @throws IllegalArgumentException
	 *         The given workTime is not a valid workTime for any
	 *         Unit.
	 *       | ! isValidWorkTime(getWorkTime())
	 */
	@Raw
	private void setWorkTime(double worktime) throws IllegalArgumentException {
		if (! isValidWorkTime(worktime))
			throw new IllegalArgumentException("the worktime is invalid");
		this.worktime = worktime;
	}

	/**
	 * Reduces the worktime with time
	 *
	 * @param 	time
	 * 			The time to be subtracted from worktime
	 * @throws 	IllegalArgumentException
	 * 			The given time is not a valid time for any Unit.
	 */
	private void advanceWorkTime(double time) throws IllegalArgumentException{
		if (! isValidTime(time))
				throw new IllegalArgumentException("The given time is not a valid time");

		double newWorkTime = this.getWorkTime() - time;
		if (Util.fuzzyLessThanOrEqualTo(newWorkTime , 0)){
			this.setWorkTime(0);
			this.setStatus(UnitStatus.IDLE);
		}
		else
			this.setWorkTime(newWorkTime);
	}

	/**
	 * Variable registering the workTime of this Unit. Default value 0.
	 */
	private double worktime = 0;
	
	/* END Work */
	
	
	/* Attack */
	/**
	 * This Unit attacks the Other Unit
	 *
	 * @param   other
	 * 			the Unit being attacked
	 * @throws	IllegalArgumentException
	 * 			The Unit being attacked is not a valid Unit
	 */
	public void attack(Unit other) throws IllegalArgumentException{
		if (! this.canAttack(other))
			throw new IllegalArgumentException("The other Unit cannot be attacked");
		this.setAttackCountDown(1d);
		this.setStatus(UnitStatus.ATTACKING);
		other.defend(this);
		this.face(other);

	}

	/**
	 * Return the attackCountDown of this Unit.
	 */
	@Basic @Raw
	private double getAttackCountDown() {
		return this.attackCountDown;
	}

	/**
	 * Check whether the given attackCountDown is a valid attackCountDown for
	 * any Unit.
	 *
	 * @param  attackCountDown
	 *         The attackCountDown to check.
	 * @return
	 *       | result == (0 <= attackCountDown <=1 )
	*/
	private static boolean isValidAttackCountDown(double attackCountDown) {
		return ((Util.fuzzyGreaterThanOrEqualTo(attackCountDown, 0)) &&
				(Util.fuzzyGreaterThanOrEqualTo(1, attackCountDown)));
	}

	/**
	 * Set the attackCountDown of this Unit to the given attackCountDown.
	 *
	 * @param  attackCountDown
	 *         The new attackCountDown for this Unit.
	 * @post   The attackCountDown of this Unit is equal to
	 *         the given attackCountDown.
	 *       | new.getAttackCountDown() == attackCountDown
	 * @throws IllegalArgumentException
	 *         The given attackCountDown is not a valid attackCountDown for any
	 *         Unit.
	 *       | ! isValidAttackCountDown(getAttackCountDown())
	 */
	@Raw
	private void setAttackCountDown(double attackCountDown) throws IllegalArgumentException {
		if (! isValidAttackCountDown(attackCountDown))
			throw new IllegalArgumentException("the given countdown is not valid");
		this.attackCountDown = attackCountDown;
	}

	/**
	 * Reduces the worktime with time
	 *
	 * @param 	time
	 * 			The time to be subtracted from attackcountdown
	 * @post	The attackCountDown of this Unit is reduced by the amount time
	 * 			| new.getAttackCountDown() == this.getAttackCountDown() - time
	 * @throws 	IllegalArgumentException
	 * 			The given time is not a valid time for any Unit.
	 * 			| ! isValidTime(time)
	 */
	private void advanceAttackTime(double time) throws IllegalArgumentException{
		if (! isValidTime(time))
				throw new IllegalArgumentException("The given time is not a valid time");

		double newAttackTime = this.getAttackCountDown() - time;
		if (Util.fuzzyLessThanOrEqualTo(newAttackTime , 0)){
			this.setAttackCountDown(0);
			this.setStatus(UnitStatus.IDLE);
		}
		else
			this.setAttackCountDown(newAttackTime);
	}

	/**
	 * Variable registering the attackCountDown of this Unit.
	 */
	private double attackCountDown = 0;
	/* END Attack */

	Random rnd = new Random();
	/* Defend */
	/** TODO:defend expand postcondition
	 * This Unit is attacked by the other Unit, and can take damage because of this
	 *
	 * @param 	other
	 * 			The Unit attacking this Unit.
	 * @post	If dodging and blocking failed, the hp of this unit is reduced by
	 * 			strength of the attacker divided by ten
	 * 			| if (
	 * @throws 	IllegalArgumentException
	 * 			This Unit cannot be attacked by  the other Unit
	 * 			| ! other.canAttack(this)
	 */
	public void defend(Unit other) throws IllegalArgumentException{
		if (! other.canAttack(this))
			throw new IllegalArgumentException("This Unit can not be attacked by the other unit");

		this.setStatus(UnitStatus.DEFENDING);
		this.face(other);

		double dodgeChance = (0.2d* this.getAgility())/other.getAgility();

		if (Util.fuzzyGreaterThanOrEqualTo(rnd.nextDouble(),dodgeChance)){ //nextDouble maakt random getal tussen 0 en 1
			this.dodge();
			//this.setStatus(UnitStatus.IDLE); //TODO:hier, of in advanceTime?
			return;
		}
		double blockChance = (0.25d* (this.getStrength() + this.getAgility()))
				/(other.getStrength()+other.getAgility());
		if (Util.fuzzyGreaterThanOrEqualTo(rnd.nextDouble(),blockChance)){
			//this.setStatus(UnitStatus.IDLE);
			return;
		}
		int newHP = this.getHP() - other.getStrength()/10;
		this.setHP(newHP);

 	}
	/* END Defend */
	
	
	/* Rest */
	// nominaal
	/**
	 * Initiate the rest status for this unit.
	 *
	 * @pre	The Unit is not attacking
	 * 		| this.status != UnitStatus.ATTACKING
	 * @pre The Unit is not being attacked
	 * 		| this.status != UnitStatus.DEFENDING
	 * @post	The status of this Unit is 'resting'
	 * 			| new.getStatus() == Unitstatus.RESTING
	 * @post	The restTime of this Unit is 0
	 * 			| new.getRestTime() == 0
	 */
	public void rest(){
		assert (this.getStatus() != UnitStatus.ATTACKING);
		assert (this.getStatus() != UnitStatus.DEFENDING);
		this.setRestTime(0);
		this.setStatus(UnitStatus.REST);
	}

	/**
	 * Update the hp and stamina of this resting Unit.
	 *
	 * @param 	time
	 * 			The amount of time passed
	 * @pre 	time is a valid time for any unit
	 * 			| isValidTime(time)
	 * @pre		This Unit is in RESTING or REST status
	 * 			| (this.getStatus() == UnitStatus.REST) || (this.getStatus() == UnitStatus.RESTING)
	 * @post	TODO: postcondities
	 */
	public void advanceRest(double time){
		assert isValidTime(time);
		assert (this.getStatus() == UnitStatus.REST) || (this.getStatus() == UnitStatus.RESTING);

		this.setRestTime(this.getRestTime() + time);
		double oneHPTime = this.getToughness()/(200d * 0.2d);
		double newTime = this.getRestTime() - oneHPTime;
		// check for rest-status
		if (Util.fuzzyGreaterThanOrEqualTo(newTime, 0) &&
				(this.getStatus() == UnitStatus.REST)){
			this.setStatus(UnitStatus.RESTING);
		}
		// check for hp
		if (this.getMaxHP() != this.getHP()){
			if (Util.fuzzyGreaterThanOrEqualTo(newTime, 0)){
				this.setRestTime(newTime);
				this.setHP(this.getHP() + 1);
			}
			return;
		}
		// check for stamina
		else if (this.getStamina() != this.getMaxStamina()){
			double oneStaminaTime = this.getToughness()/(100d * 0.2d);
			double newTimeT = this.getRestTime() - oneStaminaTime;
			if (Util.fuzzyGreaterThanOrEqualTo(newTimeT, 0)){
				this.setRestTime(newTimeT);
				this.setStamina(this.getStamina() + 1);
			}
			return;
		}
		// resting has ended
		else {
			this.setStatus(UnitStatus.IDLE);
		}
	}

	/**
	 * Return the restTime of this Unit.
	 */
	@Basic @Raw
	public double getRestTime() {
		return this.restTime;
	}

	/**
	 * Check whether the given restTime is a valid restTime for
	 * any Unit.
	 *
	 * @param  restTime
	 *         The restTime to check.
	 * @return
	 *       | result == (restTime >= 0))
	*/
	public static boolean isValidRestTime(double restTime) {
		return (Util.fuzzyGreaterThanOrEqualTo(restTime, 0));
	}

	/**
	 * Set the restTime of this Unit to the given restTime.
	 *
	 * @param  restTime
	 *         The new restTime for this Unit.
	 * @pre    The given restTime must be a valid restTime for any
	 *         Unit.
	 *       | isValidRestTime(restTime)
	 * @post   The restTime of this Unit is equal to the given
	 *         restTime.
	 *       | new.getRestTime() == restTime
	 */
	@Raw
	public void setRestTime(double restTime) {
		assert isValidRestTime(restTime);
		this.restTime = restTime;
	}

	/**
	 * Variable registering the restTime of this Unit.
	 */
	private double restTime = 0;
	/* END Rest */
	
	/* Status */
	/**
	 * Return the status of this Unit.
	 */
	@Basic @Raw
	public UnitStatus getStatus() {
		return this.status;
	}

	/**
	 * Check whether the given status is a valid status for
	 * any Unit.
	 *
	 * @param  status
	 *         The status to check.
	 * @return
	 *       | result == (status != null)
	*/
	public static boolean isValidStatus(UnitStatus status) {
		return (status != null);
	}

	/**
	 * Set the status of this Unit to the given status.
	 *
	 * @param  status
	 *         The new status for this Unit.
	 * @post   The status of this new Unit is equal to
	 *         the given status.
	 *       | new.getStatus() == status
	 * @throws IllegalArgumentException
	 *         The given status is not a valid status for any
	 *         Unit.
	 *       | ! isValidStatus(getStatus())
	 */
	@Raw
	private void setStatus(UnitStatus status) throws IllegalArgumentException {
		if (! isValidStatus(status))
			throw new IllegalArgumentException();
		this.status = status;
	}

	/**
	 * Variable registering the status of this Unit.
	 */
	private UnitStatus status;
	/* END Status */
	
	
	/* AdvanceTime */
	/** TODO: fuzzyequals gebruiken misschien
	 * Check whether the given time is valid for any Unit
	 *
	 * @param 	time
	 * 			The time to check.
	 * @return
	 * 			| result == ((time > 0) && (time < 0.2))
	 */
	public static boolean isValidTime(double time){
        return (time > 0) && (time < 0.2);
	}

	//TODO:advanceTime every unit rests automaticaly every 3 minutes
	
	/* END AdvanceTime */
	
	
	/* Terminate */
	/**
	 * Terminate this Unit.
	 *
	 * @post   This Unit  is terminated.
	 *       | new.isTerminated()
	 * @post   ...
	 *       | ...
	 */
	 public void terminate() {
		 this.isTerminated = true;
	 }

	 /**
	  * Return a boolean indicating whether or not this Unit
	  * is terminated.
	  */
	 @Basic @Raw
	 public boolean isTerminated() {
		 return this.isTerminated;
	 }

	 /**
	  * Variable registering whether this person is terminated.
	  */
	 private boolean isTerminated = false;
	 
	 /* END Terminate */
	 
	 
	 /* DefaultBehaviour*/
	 
	 /**TODO defaultdocumentatie
	  * The Unit is in default behaviour mode
	  * 
	  * @post	the defaultBoolean is true
	  * 		| new.getDefaultBoolean == true
	  * @effect	start the defaultBehaviour method
	  * 		| this.defaultBehaviour
	  */
	 public void startDefaultBehaviour(){
		 this.setDefaultBoolean(true);
		 this.defaultBehaviour();
	 }
	 
	 /**TODO defaultdocumentatie
	  * The Unit is no longer in default behavior mode
	  * 
	  * @post	the defaultBoolean is true
	  * 		| new.getDefaultBoolean == false
	  */
	 public void stopDefaultBehaviour(){
		 this.setDefaultBoolean(false);
	 }
	 
	 /**
	  * Determine the next behaviour 
	  * 
	  * @throws IllegalStateException
	  */
	 public void defaultBehaviour() throws IllegalStateException{
		if (! this.getDefaultBoolean())
			throw new IllegalStateException();
		 
		double chance = rnd.nextDouble();
		 
		if (Util.fuzzyLessThanOrEqualTo(chance, 0.333333d)){
			this.work() ;
			return;
		}
		else if (Util.fuzzyLessThanOrEqualTo(chance, 0.666666d)){
			this.rest();
			return;
		}
		else {
			this.moveToRandom();
		}
		
	 }
	
	/**
	 * Return the defaultBoolean of this Unit.
	 */
	@Basic @Raw
	public boolean getDefaultBoolean() {
		return this.defaultBoolean;
	}
	
	/**
	 * Check whether the given defaultBoolean is a valid defaultBoolean for
	 * any Unit.
	 *  
	 * @param  defaultBoolean
	 *         The defaultBoolean to check.
	 * @return 
	 *       | result == (defaultBoolean == true) || (defaultBoolean == false)
	*/
	public static boolean isValidDefaultBoolean(boolean defaultBoolean) {
		return (defaultBoolean == true) || (defaultBoolean == false);
	}
	
	/**
	 * Set the defaultBoolean of this Unit to the given defaultBoolean.
	 * 
	 * @param  defaultBoolean
	 *         The new defaultBoolean for this Unit.
	 * @post   The defaultBoolean of this new Unit is equal to
	 *         the given defaultBoolean.
	 *       | new.getDefaultBoolean() == defaultBoolean
	 * @throws IllegalArgumentException
	 *         The given defaultBoolean is not a valid defaultBoolean for any
	 *         Unit.
	 *       | ! isValidDefaultBoolean(getDefaultBoolean())
	 */
	@Raw
	public void setDefaultBoolean(boolean defaultBoolean) throws IllegalArgumentException {
		if (! isValidDefaultBoolean(defaultBoolean))
			throw new IllegalArgumentException();
		this.defaultBoolean = defaultBoolean;
	}
	
	/**
	 * Variable registering the defaultBoolean of this Unit.
	 */

	private boolean defaultBoolean = false;

}
