/**
 * FILENAME Plan.java
 * PURPOSE  Hold and maintain plan objects
 *
 * @author Justin Goldsmith
 */

//System.out.println();
//System.out.printf();
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
