/**
 * @FILENAME Plan.java
 * 
 * @PURPOSE  A class container for Plan object constructor, setters, and getters.
 *           Provides objects as containers to store life insurance plan data 
 *           as values. 
 *
 * @author Justin Goldsmith
 */

package goldsmithfinal;


public class Plan {
    
    private int planCusts;
    private double cost;

    public Plan(double cost){
        this.planCusts = 0;
        this.cost = cost;
    }
    
    public int getPlanCusts(){
        return this.planCusts;
    }
    
    public void setPlanCusts(){
        this.planCusts += 1;
    }
    
    public double getCost(){
        return this.cost;
    }
    
    public void setCost(double cost){
        this.cost = cost;
    }
}
