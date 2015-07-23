
package goldsmithfinal;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;


public class Actions {
    
    
    public static void getInput(ArrayList<Customer> customers, Scanner input, Random idGenerator, boolean loop){
        
        while (!loop == false){
            int whileCount = 0;
            
            System.out.print("Name: ");
            String name = input.nextLine();
            
            int id = idGenerator.nextInt(1000);
            
            System.out.print("Age: ");
            int age = input.nextInt();
            input.nextLine();
            
            System.out.print("Chosen plan: ");
            char plan = input.nextLine().charAt(0);
            
            System.out.print("Smoker?(y/n) ");
            String smoker = input.nextLine();
            
            System.out.print("Disability?(y/n) ");
            String disabled = input.nextLine();
            
            System.out.print("Long-Term Healthcare?(y/n) ");
            String ltc = input.nextLine();
            

            
            for (int i = whileCount; i == whileCount; i++){
                customers.add(i, new Customer());
                
                customers.get(i).setName(name);
                customers.get(i).setId(id);
                customers.get(i).setAge(age);
                customers.get(i).setPlan(plan);
                if ("y".equals(disabled))
                    customers.get(i).setDisability(true);
                if ("y".equals(smoker))
                    customers.get(i).setSmoker(true);
                if ("y".equals(ltc))
                    customers.get(i).setLtcare(true);
            }
            
            System.out.print("New customer?(y/n) ");
            String in = input.nextLine();
            
            if("y".equals(in))
                loop = true;
            if("n".equals(in))
                loop = false;
        }
        
    }
    
    public static Double calcCharge(ArrayList<Customer> customers, Plan planA, Plan planB, Plan planC, double totalChgs){
        
        double baseChg = 0.0;
        double total = 0.0;
        total = baseChg;
        
        for(Customer customer : customers){
            
            switch(customer.getPlan()){
                case 'A':
                case 'a':
                    baseChg = planA.getCost();
                    planA.setPlanCusts();
                    break;
                case 'B':
                case 'b':
                    baseChg = planB.getCost();
                    planB.setPlanCusts();
                    break;
                case 'C':
                case 'c':
                    baseChg = planC.getCost();
                    planC.setPlanCusts();
                    break;
                default:
                    System.out.println("Plan code \""+customer.getPlan()+"\" is invalid.");
                    break;
                    
            }
            
            if(customer.isSmoker())
                total += (baseChg * .05);
            
            if(customer.isDisability())
                total += 76;
            
            if(customer.isLtcare())
                total += 110;
            
            customer.setEstimate(total);
            totalChgs += total;
            
        }
        
        return totalChgs;
    }
    
    
    public static void displayResults(ArrayList<Customer> customers, double totalChgs, Plan planA, Plan planB, Plan planC){
        System.out.println();
        System.out.println();
        System.out.println("Customers:");
        System.out.println("----------------------------------------------------------------");
        System.out.printf("%8s %12s %7s %8s %13s\n", "Name", "Cust ID", "Age", "Plan", "Estimate");
        System.out.println("----------------------------------------------------------------");

        for (Customer customer : customers) {
            System.out.printf("%9s %10d %8d %7c %7s%.2f\n", customer.getName(), customer.getId(), customer.getAge(), Character.toUpperCase(customer.getPlan()), "$", customer.getEstimate());
            
        }
        System.out.println("----------------------------------------------------------------");
        System.out.printf("%s: %f\n", "Total Charges", totalChgs);
        System.out.printf("%s\n", "Plan Totals...");
        System.out.printf("%s: %d\n", "Plan A", planA.getPlanCusts());
        System.out.printf("%s: %d\n", "Plan B", planB.getPlanCusts());
        System.out.printf("%s: %d\n", "Plan C", planC.getPlanCusts());
    }
    
}
