

public class GumballMachine implements IGumballMachine {
 
    State soldOutState;
    State needCoinState;
    State enoughCoinState;
    State soldState; 
    State state;
    
    int count = 0;  // the number of gumballs in machine
    int cents;  // the amount of cents in machine
    int ballsInSlot = 0; // the number of gumballs in slot
    final int cost = 50; // the cost for a gumball
 
    public GumballMachine(int numberGumballs) {
        soldOutState = new SoldOutState(this);
        needCoinState = new NeedCoinState(this);
        enoughCoinState = new EnoughCoinState(this);
        soldState = new SoldState(this);        

        this.count = numberGumballs;
        this.cents = 0;
        if (numberGumballs > 0) {
            state = needCoinState;
        } 
        else {
            state = soldOutState;
        }
    }
    
    public void insertQuarter( ) {
        state.insertQuarter();        
    }
    
    public void insertDime( ) {
        state.insertDime();        
    }
    
    public void insertNickel( ) {
        state.insertNickel();        
    }
           
    public void turnCrank( ) {
        state.turnCrank();
        state.dispense();
    }
    
    public boolean isGumballInSlot( ) {
        return (ballsInSlot > 0);        
    }
    
    public void takeGumballFromSlot( ) {
        if (isGumballInSlot()) {
            if (ballsInSlot == 1)
                System.out.println("A gumball is taken away.");
            else
                System.out.println(ballsInSlot + " gumballs are taken away.");
                
            ballsInSlot = 0;
        }
        else System.out.println("There are no gumballs in the slot.");
    }
 
    void setState(State state) {
        this.state = state;
    }
 
    void releaseBall() {
        System.out.println("A gumball comes rolling out the slot...");
        if (count != 0) {
            count = count - 1;
            ballsInSlot = ballsInSlot + 1;
        }
    }
    
    public void returnChange() {
        System.out.println((this.cents - this.cost) + " cents are returned");
        this.cents = 0;
    }
 
    int getCount() {
        return count;
    }
 
    void refill(int count) {
        this.count = count;
        state = needCoinState;
    }

    public State getState() {
        return state;
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public State getNeedCoinState() {
        return needCoinState;
    }
    
    public State getEnoughCoinState() {
        return enoughCoinState;
    }

    public State getSoldState() {
        return soldState;
    }
 
    public String toString() {
        StringBuffer result = new StringBuffer();
        result.append("\nMighty Gumball, Inc.");
        result.append("\nJava-enabled Standing Gumball Model #2004");
        result.append("\nInventory: " + count + " gumball");
        if (count != 1) {
            result.append("s");
        }
        result.append("\n");
        result.append("Machine is " + state + "\n");
        return result.toString();
    }
}
