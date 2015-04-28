
/**
 * Determines whether two equations of lines are parallel or perpendicular.
 * 
 * Justin Liang
 * 11/8/08
 * Period 1
 */

import java.util.Scanner;

public class LinesEquation
{
    String slope1;
    String slope2;
    
    /**
     * Find the value of the slope of the first equation.
     */
    public void storeLine1()
    {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Please enter the equations as y=mx+b format with no spaces.");
        System.out.println("");
        System.out.println("Please enter the first equation: ");
        String eq1 = input.next();
        
        int length = eq1.length();
        
        int check1 = 0;
        int check2 = 0;
        String stringCheck;
        
        for(int i = 0; i < length; i++)
        {            
            stringCheck = eq1.substring(i,i+1);
            
            if(stringCheck.equalsIgnoreCase("="))
            {
                check1 = i;
            }
            
            else if(stringCheck.equalsIgnoreCase("x"))
            {
                check2 = i;
            }
        }
                
        slope1 = eq1.substring(check1+1, check2);
    }
    
    /**
     * Find the value of the slope of the second equation.
     */
    public void storeLine2()
    {
        Scanner input = new Scanner(System.in);
        
        System.out.println("");
        System.out.println("Please enter the second equation: ");
        String eq2 = input.next();
        
        int length = eq2.length();
        
        int check1 = 0;
        int check2 = 0;
        String stringCheck;
        
        for(int i = 0; i < length; i++)
        {            
            stringCheck = eq2.substring(i,i+1);
            
            if(stringCheck.equalsIgnoreCase("="))
            {
                check1 = i;
            }
            
            else if(stringCheck.equalsIgnoreCase("x"))
            {
                check2 = i;
            }
        }
                
        slope2 = eq2.substring(check1+1, check2);
    }
    
    /**
     * Takes the slopes of the 2 equations and calculates if the slopes are parallel or perpendicular.
     */
    public void calculate()
    {
        double newSlope1;
        newSlope1 = Double.parseDouble(slope1);
        double newSlope2;
        newSlope2 = Double.parseDouble(slope2);
        
        if(newSlope1 == newSlope2)
        {
            System.out.println("");
            System.out.println("The lines are parallel.");
            System.out.println("");
        }
        
        else if(newSlope1 == -1/newSlope2)
        {
            System.out.println("");
            System.out.println("The lines are perpendicular.");
            System.out.println("");
        }
        
        else
        {
            System.out.println("");
            System.out.println("These lines are not parallel or perpendicular.");
            System.out.println("");
        }
    }
    
    /**
     * Runs the line program that determines whether two lines are parallel or perpendicular.
     */
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        boolean done = true;
        
        while(done)
        {
            System.out.println("Would you like to continue? Yes/no?");
            String response = in.next();
            
            if(response.equalsIgnoreCase("no"))
            {
                break;
            }
            
            else
            {
                LinesEquation hello = new LinesEquation();
                System.out.println("");
                hello.storeLine1();
                hello.storeLine2();
                hello.calculate();
            }
        }        
    }      
}