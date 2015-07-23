
package goldsmithfinal;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Data {
    public static Scanner input = new Scanner(System.in);
    public static Random idGenerator = new Random();
    public static ArrayList<Customer> customers = new ArrayList<>();
    public static Plan planA = new Plan(175.00);
    public static Plan planB = new Plan(198.00);
    public static Plan planC = new Plan(225.00);

    public static boolean loop = true;
    public static int arrayCount = 0;
    public static double totalChgs = 0.0;
}
