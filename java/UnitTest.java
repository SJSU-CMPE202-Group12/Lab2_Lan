import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UnitTest {
	// private GumballMachineStub machineWithGumball;
	private GumballMachine machineWithGumball;
	private GumballMachine machineWithoutGumball;

	public UnitTest() {
	}

	@Before
	public void setUp() {
		// machineWithGumball = new GumballMachineStub(3);
		machineWithGumball = new GumballMachine(3);
		machineWithoutGumball = new GumballMachine(0);
	}

	@After
	public void tearDown() {
	}

	@Test
	public void testNoCoin() {
		assertEquals(false, machineWithGumball.isGumballInSlot());
	}

	@Test
	public void testInsertOneCoin() {
		machineWithGumball.insertDime();
		assertEquals(false, machineWithGumball.isGumballInSlot());
	}

	@Test
	public void testInsertOneCoinAndCrank() {
		machineWithGumball.insertNickel();
		machineWithGumball.turnCrank();
		assertEquals(false, machineWithGumball.isGumballInSlot());
	}

	@Test
	public void testInsertInsufficientSeveralCoinsAndCrank() {
		machineWithGumball.insertDime();
		machineWithGumball.insertNickel();
		machineWithGumball.insertQuarter();
		machineWithGumball.turnCrank();
		assertEquals(false, machineWithGumball.isGumballInSlot());
	}

	@Test
	public void testInsertFiftyCentsAndCrank() {
		System.out.println("\nTC: 50 cents are inserted and we get a gumball without change");
		machineWithGumball.insertDime();
		machineWithGumball.insertDime();
		machineWithGumball.turnCrank();
		machineWithGumball.insertQuarter();
		machineWithGumball.insertNickel();
		machineWithGumball.turnCrank();
		assertEquals(true, machineWithGumball.isGumballInSlot());
	}

	@Test
	public void testInsertMoreThanFiftyCentsAndCrank() {
		System.out.println("\nTC: More than 50 cents are inserted and we get a gumball with change");
		machineWithGumball.insertDime();
		machineWithGumball.insertDime();
		machineWithGumball.turnCrank();
		assertEquals(false, machineWithGumball.isGumballInSlot());
		machineWithGumball.insertQuarter();
		machineWithGumball.insertDime();
		machineWithGumball.turnCrank();
		assertEquals(true, machineWithGumball.isGumballInSlot());
	}

	@Test
	public void testTakeGumball() {
		machineWithGumball.insertQuarter();
		machineWithGumball.insertQuarter();
		machineWithGumball.insertQuarter();
		machineWithGumball.turnCrank();
		assertEquals(true, machineWithGumball.isGumballInSlot());
		machineWithGumball.takeGumballFromSlot();
		assertEquals(false, machineWithGumball.isGumballInSlot());
		machineWithGumball.insertQuarter();
		machineWithGumball.turnCrank();
		assertEquals(false, machineWithGumball.isGumballInSlot());
	}

	@Test
	public void testCrankAfterTakenGumball() {
		machineWithGumball.insertQuarter();
		machineWithGumball.insertQuarter();
		machineWithGumball.turnCrank();
		assertEquals(true, machineWithGumball.isGumballInSlot());
		machineWithGumball.takeGumballFromSlot();
		assertEquals(false, machineWithGumball.isGumballInSlot());
		machineWithGumball.turnCrank();
		assertEquals(false, machineWithGumball.isGumballInSlot());
	}

	@Test
	public void testSoldOutOnAMachineWithoutGumball() {
		machineWithoutGumball.insertQuarter();
		machineWithoutGumball.insertQuarter();
		machineWithoutGumball.turnCrank();
		assertEquals(false, machineWithoutGumball.isGumballInSlot());
	}

	@Test
	public void testSoldOutOnAMachineWithGumball() {
		machineWithGumball.insertQuarter();
		machineWithGumball.insertQuarter();
		machineWithGumball.insertQuarter();
		machineWithGumball.insertQuarter();
		machineWithGumball.turnCrank();
		machineWithGumball.insertQuarter();
		machineWithGumball.insertQuarter();
		machineWithGumball.insertDime();
		machineWithGumball.turnCrank();
		assertEquals(true, machineWithGumball.isGumballInSlot());
		machineWithGumball.takeGumballFromSlot();
		assertEquals(false, machineWithGumball.isGumballInSlot());
		machineWithGumball.insertQuarter();
		machineWithGumball.insertQuarter();
		machineWithGumball.turnCrank();
		assertEquals(true, machineWithGumball.isGumballInSlot());
		machineWithGumball.takeGumballFromSlot();
		assertEquals(false, machineWithGumball.isGumballInSlot());

		machineWithGumball.insertQuarter();
		machineWithGumball.insertDime();
		machineWithGumball.insertNickel();
		machineWithGumball.insertQuarter();
		machineWithGumball.turnCrank();
		assertEquals(false, machineWithGumball.isGumballInSlot());
	}
}
