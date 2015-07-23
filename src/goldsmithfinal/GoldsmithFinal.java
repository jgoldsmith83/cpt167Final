/**
 * @FILENAME GoldsmithMidterm.java
 * 
 * @PURPOSE  Calculate and provide an estimate for life insurance based on
 *           customer conditions.
 *
 * @author Justin Goldsmith
 */


package goldsmithfinal;

public class GoldsmithFinal {

    public static void main(String[] args) {
        
        Actions.getInput(Data.customers, Data.input, Data.idGenerator, Data.loop);
        
        Actions.calcCharge(Data.customers, Data.planA, Data.planB, Data.planC, Data.totalChgs);
        
        Actions.displayResults(Data.customers, Data.totalChgs, Data.planA, Data.planB, Data.planC);
    }
    
    
    
}
