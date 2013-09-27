

public class NeedCoinState implements State {
    GumballMachine gumballMachine;
 
    public NeedCoinState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }
 
    public void insertQuarter() {
        System.out.println("You inserted a quarter");
        gumballMachine.cents += 25;        
        updateState();
    }
    
    public void insertDime() {
        System.out.println("You inserted a dime");
        gumballMachine.cents += 10;
        updateState();
    }
    
    public void insertNickel() {
        System.out.println("You inserted a nickel");
        gumballMachine.cents += 5;
        updateState();        
    }
 
    public void turnCrank() {
        System.out.println("You turned, but there's not enough coin");
     }
 
    public void dispense() {
        System.out.println("You still need to pay " + (gumballMachine.cost - gumballMachine.cents) + " cents to get a gumball");
    } 
    
    public void updateState() {
        if(gumballMachine.cents >= gumballMachine.cost) {
            gumballMachine.setState(gumballMachine.getEnoughCoinState());
        }
    }
 
    public String toString() {
        return "waiting for coin";
    }
}
