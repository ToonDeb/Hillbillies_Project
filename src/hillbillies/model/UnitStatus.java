package hillbillies.model;

/**
 * A class of ...
 *
 * @author  ...
 * @version 1.0
 */
public enum UnitStatus {
	WALKING,
	
	WORKING,
	
	ATTACKING,
	
	DEFENDING,
	
	RESTING,
	
	REST,		// initiating the rest-status. when 1 HP is added, go to RESTING status 
	
	IDLE
}
