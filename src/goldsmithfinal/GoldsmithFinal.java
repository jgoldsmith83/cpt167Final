/**
 * FILENAME GoldsmithMidterm.java
 * PURPOSE  Fulfill the midterm requirements
 *
 * @author Justin Goldsmith
 */

/**
 *PSEUDOCODE
 * 
 * 
 *
 */

//System.out.println();
//System.out.printf();


package goldsmithfinal;

public class GoldsmithFinal {

    public static void main(String[] args) {
        
        Actions.getInput(Data.customers, Data.input, Data.idGenerator, Data.loop);
        
        Actions.calcCharge(Data.customers, Data.planA, Data.planB, Data.planC, Data.totalChgs);
        
        Actions.displayResults(Data.customers, Data.totalChgs, Data.planA, Data.planB, Data.planC);
    }
    
    
    
}
