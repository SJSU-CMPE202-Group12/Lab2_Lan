

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class UnitTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class UnitTest
{
    //private GumballMachineStub m1;
    private GumballMachine m1;
    private GumballMachine m2;

    /**
     * Default constructor for test class UnitTest
     */
    public UnitTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        //m1 = new GumballMachineStub(3);
        m1 = new GumballMachine(3);
        m2 = new GumballMachine(0);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void NoCoin()
    {
        System.out.println("\nTC: No coin in the machine");
        assertEquals(false, m1.isGumballInSlot());
    }

    @Test
    public void NeedCoin1()
    {
        System.out.println("\nTC: Not enough coin in the machine");
        m1.insertDime();
        assertEquals(false, m1.isGumballInSlot());
    }

    @Test
    public void NeedCoin2()
    {
        System.out.println("\nTC: Not enough coin in the machine and we turn the crank");
        m1.insertNickel();
        m1.turnCrank();
        assertEquals(false, m1.isGumballInSlot());
    }

    @Test
    public void NeedCoin4()
    {
        System.out.println("\nTC: Not enough coin in the machine");
        m1.insertDime();
        m1.insertNickel();
        m1.insertQuarter();
        m1.turnCrank();
        assertEquals(false, m1.isGumballInSlot());
    }

    @Test
    public void EnoughCoinWithoutChange()
    {
        System.out.println("\nTC: Enough coin in the machine and we get a gumball without change");
        m1.insertDime();
        m1.insertDime();
        m1.turnCrank();
        m1.insertQuarter();
        m1.insertNickel();
        m1.turnCrank();
        assertEquals(true, m1.isGumballInSlot());
    }
    
    @Test
    public void EnoughCoinWithChange()
    {
        System.out.println("\nTC: Enough coin in the machine and we get a gumball with change");
        m1.insertDime();
        m1.insertDime();
        m1.turnCrank();
        assertEquals(false, m1.isGumballInSlot());
        m1.insertQuarter();
        m1.insertDime();
        m1.turnCrank();
        assertEquals(true, m1.isGumballInSlot());
    }

    @Test
    public void TakeGumball1()
    {
        System.out.println("\nTC: get the gumball and return the change, take a gumball away");
        m1.insertQuarter();
        m1.insertQuarter();
        m1.insertQuarter();
        m1.turnCrank();
        assertEquals(true, m1.isGumballInSlot());        
        m1.takeGumballFromSlot();
        m1.insertQuarter();
        m1.turnCrank();        
        assertEquals(false, m1.isGumballInSlot());   
    }
    
    @Test    
    public void TakeGumball2()
    {
        System.out.println("\nTC: turn the crank twice, get one gumball, and take the gumball away");
        m1.insertQuarter();
        m1.insertQuarter();
        m1.turnCrank();        
        assertEquals(true, m1.isGumballInSlot());
        m1.takeGumballFromSlot();
        assertEquals(false, m1.isGumballInSlot()); 
		m1.turnCrank();
		assertEquals(false, m1.isGumballInSlot()); 
    }

    @Test    
    public void SoldOut1()
    {
        System.out.println("\nTC: machine is initialized with 0 gumball");
        m2.insertQuarter();
        m2.insertQuarter();
        m2.turnCrank();
        assertEquals(false, m2.isGumballInSlot());
    }
    
    @Test    
    public void SoldOut2()
    {
        System.out.println("\nTC: insert coin, turn the crank, get the gumball and change, keep doing until the gumball sold out");
        m1.insertQuarter();
        m1.insertQuarter();
        m1.insertQuarter();
        m1.insertQuarter();
        m1.turnCrank();
        m1.insertQuarter();
        m1.insertQuarter();
        m1.insertDime();
        m1.turnCrank();
        assertEquals(true, m1.isGumballInSlot());
        m1.takeGumballFromSlot();
        assertEquals(false, m1.isGumballInSlot());
        m1.insertQuarter();
        m1.insertQuarter();
        m1.turnCrank();
        assertEquals(true, m1.isGumballInSlot());
        m1.takeGumballFromSlot();
        assertEquals(false, m1.isGumballInSlot());
        
        m1.insertQuarter();
        m1.insertDime();
        m1.insertNickel();
        m1.insertQuarter();
        m1.turnCrank();
        assertEquals(false, m1.isGumballInSlot());
    }
}







