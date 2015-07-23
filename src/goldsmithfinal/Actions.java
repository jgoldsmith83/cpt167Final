/**
 * @FILENAME Actions.java
 * 
 * @PURPOSE  A container for all methods called in GoldsmithFinal.java.
 *
 * @author Justin Goldsmith
 */

package goldsmithfinal;

public class Actions {
    
    // Data input method - used to collect user input, creates Customer objects,
    // assigns object values, and puts customer object into customers ArrayList.
    // No issues with logic, compilation, or runtime.
    public static void getInput(){
        
        while (!Data.stopLoop == true){
            System.out.print("Name: ");
            Data.name = Data.input.nextLine();
            
            Data.id = Data.idGenerator.nextInt(1000);
            
            System.out.print("Age: ");
            Data.age = Data.input.nextInt();
            Data.input.nextLine();
            
            while(!Data.stopLoop == true){
                System.out.print("Chosen plan: ");
                Data.plan = Data.input.nextLine().charAt(0);
                Data.plan = Character.toUpperCase(Data.plan);
                if(Data.plan == 'A' || Data.plan == 'B' || Data.plan == 'C')
                    Data.stopLoop = true;
                else
                    System.out.println("\nInvalid Plan option. Plan choices are A, B, or C.\n");
            }
            
            Data.stopLoop = false;

            System.out.print("Smoker?(y/n) ");
            Data.smoker = Data.input.nextLine().toUpperCase();

            System.out.print("Disability?(y/n) ");
            Data.disabled = Data.input.nextLine().toUpperCase();

            System.out.print("Long-Term Care?(y/n) ");
            Data.ltc = Data.input.nextLine().toUpperCase();

            
            for (int i = Data.whileCount; i == Data.whileCount; i++){
                Data.customers.add(i, new Customer());
                
                Data.customers.get(i).setName(Data.name);
                Data.customers.get(i).setId(Data.id);
                Data.customers.get(i).setAge(Data.age);
                Data.customers.get(i).setPlan(Data.plan);
                if ("Y".equals(Data.disabled))
                    Data.customers.get(i).setDisability(true);
                if ("Y".equals(Data.smoker))
                    Data.customers.get(i).setSmoker(true);
                if ("Y".equals(Data.ltc))
                    Data.customers.get(i).setLtcare(true);
            }
            
            System.out.println();
            System.out.println();
            singleEstimate();
            System.out.println();
            System.out.println();
            
            System.out.print("New customer?(y/n) ");
            String in = Data.input.nextLine().toUpperCase();
            
            
            if("N".equals(in))
                Data.stopLoop = true;
            
        }
        
    }
    
    // Data display method - used for displaying individual input as each user
    // enters their estimate data
    public static void singleEstimate(){
        
            if(Data.customers.get(Data.index).getPlan() == 'A')
                Data.estimate = 175.00;
            else if(Data.customers.get(Data.index).getPlan() == 'B')
                Data.estimate = 198.00;
            else
                Data.estimate = 225.00;
            
            for(int i=Data.index; i==Data.index; i++){
                System.out.printf("%22s%s\n", " ", "|----------------------------");
                System.out.printf("%22s%s\n", " ", "|Name: "+Data.customers.get(Data.index).getName());
                System.out.printf("%22s%s\n", " ", "|Plan: "+Data.customers.get(Data.index).getPlan());

                if(Data.customers.get(Data.index).isSmoker()){
                    System.out.printf("%22s%s\n", " ", "|Smoker: Yes (+5%)");
                    Data.estimate += (Data.estimate * .05);
                } else {
                    System.out.printf("%22s%s\n", " ", "|Smoker: No");
                }

                if(Data.customers.get(Data.index).isDisability()){
                    System.out.printf("%22s%s\n", " ", "|Disability: Yes (+$76)");
                    Data.estimate += 76.00;
                } else {
                    System.out.printf("%22s%s\n", " ", "|Disability: No");
                }

                if(Data.customers.get(Data.index).isLtcare()){
                    System.out.printf("%22s%s\n", " ", "|Long-term Care: Yes (+$110)");
                    Data.estimate += 110.00;
                } else {
                    System.out.printf("%22s%s\n", " ", "|Long-term Care: No");
                }
                
                System.out.printf("%22s%s\n", " ", "|----------------------------");
                System.out.printf("%22s%s $%.2f\n", " ", "|Estimate:", Data.estimate);
                System.out.printf("%22s%s\n", " ", "|----------------------------");
            
        }
        
        
    }
    
    // Calculation method - used to calculate the customer's charges based on
    // user input from getInput().
    // totalChgs is currently returning 0.0 - debugging logic error in process.
    public static double calcCharge(){
        
        
        for(Customer customer : Data.customers){
            
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
            
            Data.total = Data.baseChg;
            
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
        System.out.println("Summary of Estimates:");
        System.out.println("-------------------------------------------------");
        System.out.printf("%12s %7s %8s %13s\n", "Cust ID", "Age", "Plan", "Estimate");
        System.out.println("-------------------------------------------------");

        for (Customer customer : Data.customers) {
            System.out.printf("%10d %8d %7c %8s%.2f\n", customer.getId(), customer.getAge(), Character.toUpperCase(customer.getPlan()), "$", customer.getEstimate());
        }
        
        System.out.println("-------------------------------------------------");
        System.out.printf("%39s: $%.2f\n\n", "Total of Estimates", Data.totalChgs);
        System.out.printf("%47s\n%48s\n", "Plan Totals...", "---------------");
        System.out.printf("%44s: %d\n", "Plan A", Data.planA.getPlanCusts());
        System.out.printf("%44s: %d\n", "Plan B", Data.planB.getPlanCusts());
        System.out.printf("%44s: %d\n", "Plan C", Data.planC.getPlanCusts());
        
        System.out.println();
        
    }
    
    
    // Simple method to clear the screen for subsequent estimates
    public static void clrScn(){
        for(int i=0; i<20; i++){
            System.out.println();
        }
    }
    
}
