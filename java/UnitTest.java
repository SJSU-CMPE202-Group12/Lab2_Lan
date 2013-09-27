

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
        System.out.println("\nTC: NoCoin");
        assertEquals(false, m1.isGumballInSlot());
    }

    @Test
    public void NeedCoin1()
    {
        System.out.println("\nTC: NeedCoin1");
        m1.insertDime();
        m1.turnCrank();
        assertEquals(false, m1.isGumballInSlot());
    }

    @Test
    public void NeedCoin2()
    {
        System.out.println("\nTC: NeedCoin2");
        m1.insertNickel();
        m1.turnCrank();
        assertEquals(false, m1.isGumballInSlot());
    }

    @Test
    public void NeedCoin3()
    {
        System.out.println("\nTC: NeedCoin3");
        m1.insertQuarter();
        assertEquals(false, m1.isGumballInSlot());
    }

    @Test
    public void NeedCoin4()
    {
        System.out.println("\nTC: NeedCoin4");
        m1.insertDime();
        m1.insertNickel();
        m1.insertQuarter();
        m1.turnCrank();
        assertEquals(false, m1.isGumballInSlot());
    }

    @Test
    public void EnoughCoin1()
    {
        System.out.println("\nTC: EnoughCoin1");
        m1.insertDime();
        m1.insertDime();
        m1.turnCrank();
        m1.insertQuarter();
        m1.insertNickel();
        m1.turnCrank();
        assertEquals(true, m1.isGumballInSlot());
    }
    
    @Test
    public void EnoughCoin2()
    {
        System.out.println("\nTC: EnoughCoin2");
        m1.insertDime();
        m1.insertDime();
        m1.turnCrank();
        m1.insertQuarter();
        m1.insertDime();
        m1.turnCrank();
        assertEquals(true, m1.isGumballInSlot());
    }

    @Test
    public void TakeGumball1()
    {
        System.out.println("\nTC: TakeGumball1");
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
        System.out.println("\nTC: TakeGumball2");
        m1.insertQuarter();
        m1.insertQuarter();
        m1.turnCrank();
        m1.turnCrank();
        assertEquals(true, m1.isGumballInSlot());
        m1.takeGumballFromSlot();
        assertEquals(false, m1.isGumballInSlot()); 
    }
    
    @Test    
    public void SoldOut()
    {
        System.out.println("\nTC: SoldOut");
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
        m1.turnCrank();
        assertEquals(false, m1.isGumballInSlot());
    }
}







