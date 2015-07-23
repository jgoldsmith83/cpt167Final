/**
 * @FILENAME Actions.java
 * 
 * @PURPOSE  A container for all methods called in GoldsmithFinal.java.
 *
 * @author Justin Goldsmith
 */

package goldsmithfinal;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;


public class Actions {
    
    // Data input method - used to collect user input, creates Customer objects,
    // assigns object values, and puts customer object into customers ArrayList.
    // No issues with logic, compilation, or runtime.
    public static void getInput(){
        
        while (!Data.loop == false){
            System.out.print("Name: ");
            String name = Data.input.nextLine();
            
            int id = Data.idGenerator.nextInt(1000);
            
            System.out.print("Age: ");
            int age = Data.input.nextInt();
            Data.input.nextLine();
            
            System.out.print("Chosen plan: ");
            char plan = Data.input.nextLine().charAt(0);
            Character.toUpperCase(plan);
            
            System.out.print("Smoker?(y/n) ");
            String smoker = Data.input.nextLine();
            
            System.out.print("Disability?(y/n) ");
            String disabled = Data.input.nextLine();
            
            System.out.print("Long-Term Healthcare?(y/n) ");
            String ltc = Data.input.nextLine();
            

            
            for (int i = Data.whileCount; i == Data.whileCount; i++){
                Data.customers.add(i, new Customer());
                
                Data.customers.get(i).setName(name);
                Data.customers.get(i).setId(id);
                Data.customers.get(i).setAge(age);
                Data.customers.get(i).setPlan(plan);
                if ("y".equals(disabled))
                    Data.customers.get(i).setDisability(true);
                if ("y".equals(smoker))
                    Data.customers.get(i).setSmoker(true);
                if ("y".equals(ltc))
                    Data.customers.get(i).setLtcare(true);
            }
            
            System.out.print("New customer?(y/n) ");
            String in = Data.input.nextLine();
            
            if("y".equals(in))
                Data.loop = true;
            if("n".equals(in))
                Data.loop = false;
        }
        
    }
    
    // Calculation method - used to calculate the customer's charges based on
    // user input from getInput().
    // totalChgs is currently returning 0.0 - debugging logic error in process.
    public static Double calcCharge(){
        
        for(Customer customer : Data.customers){
            Data.total = Data.baseChg;
            
            switch(customer.getPlan()){
                case 'A':
                    Data.baseChg = Data.planA.getCost();
                    Data.planA.setPlanCusts();
                    break;
                case 'B':
                    Data.baseChg = Data.planB.getCost();
                    Data.planB.setPlanCusts();
                    break;
                case 'C':
                    Data.baseChg = Data.planC.getCost();
                    Data.planC.setPlanCusts();
                    break;
                default:
                    System.out.println("Plan code \""+customer.getPlan()+"\" is invalid.");
                    break;
                    
            }
            
            if(customer.isSmoker())
                Data.total += (Data.baseChg * .05);
            
            if(customer.isDisability())
                Data.total += 76;
            
            if(customer.isLtcare())
                Data.total += 110;
            
            customer.setEstimate(Data.total);
            Data.totalChgs += Data.total;
            
        }
        
        return Data.totalChgs;
    }
    
    // Output method - used to display object values for each object in the
    // ArrayList of customer objects.
    // No issues with logic, compliation, or runtime
    public static void displayResults(){
        System.out.println();
        System.out.println();
        System.out.println("Customers:");
        System.out.println("----------------------------------------------------------------");
        System.out.printf("%8s %12s %7s %8s %13s\n", "Name", "Cust ID", "Age", "Plan", "Estimate");
        System.out.println("----------------------------------------------------------------");

        for (Customer customer : Data.customers) {
            System.out.printf("%9s %10d %8d %7c %7s%.2f\n", customer.getName(), customer.getId(), customer.getAge(), Character.toUpperCase(customer.getPlan()), "$", customer.getEstimate());
            
        }
        System.out.println("----------------------------------------------------------------");
        System.out.printf("%s: %f\n", "Total Charges", Data.totalChgs);
        System.out.printf("%s\n", "Plan Totals...");
        System.out.printf("%s: %d\n", "Plan A", Data.planA.getPlanCusts());
        System.out.printf("%s: %d\n", "Plan B", Data.planB.getPlanCusts());
        System.out.printf("%s: %d\n", "Plan C", Data.planC.getPlanCusts());
    }
    
}
