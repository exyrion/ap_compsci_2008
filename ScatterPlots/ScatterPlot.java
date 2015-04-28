
/**
 * Write a description of class ScatterPlot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.Line2D;
import java.util.Scanner;
import javax.swing.JFrame;
import java.util.ArrayList;

public class ScatterPlot extends JComponent
{
    private ArrayList<Integer> data;
    
    /**
     * Constructor. Initializes the array list data.
     */
    
    public ScatterPlot()
    {
        data = new ArrayList<Integer>();
    }
    
    /**
     * Reads user input
     */
    
    public void readInput()
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter all the values: ");
        while(in.hasNext())
        {
            String value = in.next();
            int realValue = Integer.parseInt(value);
            data.add(realValue);
        }
        
        System.out.println("Thes are all the values you've entered: ");
        for(int i = 0; i < data.size(); i++)
        {
            System.out.print(data.get(i) + " ");
        }
    }
    
    /**
     * Draws the component such as line and points.
     * @param g drawing tool.
     */
    public void paintComponent (Graphics g)
    {
        
    }
    
    public static void main(String[] args)
    {
        ScatterPlot monkeyCharlie = new ScatterPlot();
        monkeyCharlie.readInput();
    }
}