
/**
 * Write a description of class GumballMachineStub here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GumballMachineStub implements IGumballMachine
{
    
    /**
     * Constructor for objects of class GumballMachineStub
     */
    int count = 0;
    public GumballMachineStub(int count)
    {
       this.count = count;
    }

    public void insertQuarter( ) {}
    public void insertDime( ) {}
    public void insertNickel( ) {}
    public void turnCrank( ) {}
    public boolean isGumballInSlot( ) {return false;}
    public void takeGumballFromSlot( ) {}
}
