package hillbillies.model;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class UnitTest {
	
	private Unit testingUnit;
	
	@Before
	public void setUp(){
		double[] position;
		position = new double[3];
		position[0] = 25d;
		position[1] = 25d;
		position[2] = 25d;
		testingUnit = new Unit("TestSubject", position, 50, 50, 50, 50);
	}
	
	@Test
	public void testConstructor$LegalCase(){
		double[] position;
		position = new double[3];
		position[0] = 12d;
		position[1] = 15d;
		position[2] = 2d;
		Unit unit = new Unit("TestSubject", position, 50, 50, 50, 50);
		
		assertEquals(unit.getPosition(), position);
		assertEquals(unit.getStrength(), 50);
		assertEquals(unit.getAgility(), 50);
		assertEquals(unit.getWeight(), 50);
		assertEquals(unit.getToughness(), 50);
		assertEquals(unit.getName(), "TestSubject");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConstructor$IllegalPositionCase()
			throws IllegalArgumentException{
		double[] position;
		position = new double[3];
		position[0] = 51d;
		position[1] = 51d;
		position[2] = 51d;
		Unit unit = new Unit("TestSubject", position, 50, 50, 50, 50);
		fail("Exception Expected!");
	}
	
	@Test
	public void testConstructor$IllegalStrengthCase()
			throws IllegalArgumentException{
		double[] position;
		position = new double[3];
		position[0] = 40d;
		position[1] = 40d;
		position[2] = 40d;
		Unit unit = new Unit("TestSubject", position, 50, 24, 50, 50);
		assertEquals(unit.getStrength(), 25);
	}
	
	@Test
	public void testConstructor$IllegalAgilityCase()
			throws IllegalArgumentException{
		double[] position;
		position = new double[3];
		position[0] = 40d;
		position[1] = 40d;
		position[2] = 40d;
		Unit unit = new Unit("TestSubject", position, 50, 50, 150, 50);
		assertEquals(unit.getAgility(), 25);
	}
	
	@Test
	public void testConstructor$IllegalToughnessCase()
			throws IllegalArgumentException{
		double[] position;
		position = new double[3];
		position[0] = 40d;
		position[1] = 40d;
		position[2] = 40d;
		Unit unit = new Unit("TestSubject", position, 50, 50, 50, 250);
		assertEquals(unit.getToughness(), 25);
	}
	
	@Test
	public void testConstructor$IllegalWeightCase(){
		double[] position;
		position = new double[3];
		position[0] = 40d;
		position[1] = 40d;
		position[2] = 40d;
		Unit unit = new Unit("TestSubject", position, 30, 50, 50, 50);
		assertEquals(unit.getWeight(), 50);
	}
	
	
	@Test
	public void testSetGetPosition$LegalCase(){
		double[] position;
		position = new double[3];
		position[0] = 40.5d;
		position[1] = 40.75d;
		position[2] = 40.49d;
		testingUnit.setPosition(position);
		assertEquals(testingUnit.getPosition(), position);
	}
	
	@Test
	public void testGetCubePosition(){
		double[] position;
		position = new double[3];
		position[0] = 40.5d;
		position[1] = 40.75d;
		position[2] = 40.49d;
		testingUnit.setPosition(position);
		int[] cubePosition = {40,40,40};
		assertArrayEquals(testingUnit.getCubePosition(), cubePosition);
	}
	
	
	
	@Test (expected = IllegalArgumentException.class)
	public void testSetPosition$IllegalXCase() throws IllegalArgumentException{
		double[] position;
		position = new double[3];
		position[0] = 100d;
		position[1] = 40d;
		position[2] = 40d;
		testingUnit.setPosition(position);
		fail("Exception Expected!");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testSetPosition$IllegalYCase() throws IllegalArgumentException{
		double[] position;
		position = new double[3];
		position[0] = 40d;
		position[1] = 100d;
		position[2] = 40d;
		testingUnit.setPosition(position);
		fail("Exception Expected!");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testSetPosition$IllegalZCase() throws IllegalArgumentException{
		double[] position;
		position = new double[3];
		position[0] = 40d;
		position[1] = 40d;
		position[2] = -10d;
		testingUnit.setPosition(position);
		fail("Exception Expected!");
	}
	
	@Test
	public void testIsValidPosition$TrueCase(){
		double[] position = {1.58d, 49.89d, 35.45875d};
		assertTrue(Unit.isValidPosition(position));
	}
	
	@Test
	public void testIsValidPosition$NegativeCase(){
		double[] position = {-5.54d, 5.4785d, 6.69d};
		assertFalse(Unit.isValidPosition(position));
	}
	
	@Test
	public void testIsValidPosition$ToHighCase(){
		double[] position = {55.54d, 5.4785d, 6.69d};
		assertFalse(Unit.isValidPosition(position));
	}
	
	@Test
	public void testGetSetName$LegalCase(){
		testingUnit.setName("GLaDOS Kills");
		assertEquals(testingUnit.getName(), "GLaDOS Kills");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testSetName$NullCase(){
		testingUnit.setName(null);
		fail("Exception Expected!");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testSetName$IllegalCharCase(){
		testingUnit.setName("De$sdfgs");
		fail("Exception Expected!");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testSetName$IllegalFirstCharCase(){
		testingUnit.setName("lowerCase");
		fail("Exception Expected!");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testSetName$IllegalLengthCase(){
		testingUnit.setName("N");
		fail("Exception Expected!");
	}
	
	
	
}
