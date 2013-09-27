
/**
 * Write a description of class EnoughCoinState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnoughCoinState implements State
{
    GumballMachine gumballMachine;
    
    public EnoughCoinState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    public void insertQuarter() {
        System.out.println("You inserted a quarter. You already inserted enough coin, please turn the crank to get gumball");
        gumballMachine.cents += 25;
    }
    
    public void insertDime() {
        System.out.println("You inserted a dime. You already inserted enough coin, please turn the crank to get gumball");
        gumballMachine.cents += 10;
    }
    
    public void insertNickel() {
        System.out.println("You inserted a nickel. You already inserted enough coin, please turn the crank to get gumball");
        gumballMachine.cents += 5;
    }
    
    public void turnCrank() {
		System.out.println("You turned...");
		gumballMachine.setState(gumballMachine.getSoldState());		
	}
	
    public void dispense() {
        System.out.println("No gumball dispensed");
    }
    
    public String toString() {
		return "waiting for turn of crank";
	}
}
