/**
 * @FILENAME Data.java
 * 
 * @PURPOSE  A container for all data objects and variables including loop
 *           and iterator variables.
 *
 * @author Justin Goldsmith
 */

package goldsmithfinal;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Data {
    
    // I/O objects used globally
    // idGenerator used only in Actions.getInput()
    public static Scanner input = new Scanner(System.in);
    public static Random idGenerator = new Random();
    
    // Data container objects - Customer objects are created
    // dynamically in Actions.getInput()
    public static ArrayList<Customer> customers = new ArrayList<>();
    public static Plan planA = new Plan(175.00);
    public static Plan planB = new Plan(198.00);
    public static Plan planC = new Plan(225.00);
    
    // iterator and loop variables - used in Actions.getInput()
    public static boolean stopLoop = false;
    public static int arrayCount = 0;
    public static int whileCount = 0;
    public static String name;
    public static char plan;
    public static String smoker;
    public static String disabled;
    public static String ltc;
    
    
    //Math variables - used in Actions.indivEstimate()
    public static double estimate;
    public static int index = 0;
    
    // Math variables - used in Actions.calcCharge()
    // totalChgs is return value but is currently returning 0.0
    public static double baseChg = 0.0;
    public static double total = 0.0;
    public static double totalChgs = 0.0;
    
}
