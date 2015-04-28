
/**
 * Creates a scatter plot diagram from user inputs.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.Line2D;
import java.awt.geom.Ellipse2D;
import java.util.Scanner;
import javax.swing.JFrame;
import java.util.ArrayList;

public class PlatterScot extends JComponent
{
    private double[] data;
    private final int MAX_SIZE = 1000;
    private int count;
    private final int FRAME_HEIGHT = 600;
    private final int FRAME_WIDTH = 800;
    
    /**
     * Constructs the object and initializes data.
     */
    public PlatterScot()
    {
        data = new double[MAX_SIZE]; //stores up to 1000 values
        count = 0; //no values yet
    }
    
    /**
     * Reads user inputs and store them in data array
     */
    public void readInput()
    {
        Scanner in = new Scanner(System.in);
        boolean done = false;
        System.out.println("Enter values ['n' to quit]");
        while(!done)
        {
            String value = in.next();
            if (value.equals("n"))
            {
                done = true;
            }
            else
            {
                double realValue = Double.parseDouble(value);
                data [count] = realValue;
                count++;
            }
        }
    }
    
    /**
     * Draws the points and lines.
     */
    
        public void paintComponent(Graphics g)
        {
        
        Graphics2D g2 = (Graphics2D) g;
        for(int i = 0; i < count; i++)
        {
            double yCoord = FRAME_HEIGHT - data[i];
            double xCoord = 50 * (i + 1); //50 pixel spacing
            Ellipse2D.Double dot = new Ellipse2D.Double(xCoord, yCoord, 20, 20);
            g2.draw(dot);
        }
    }
    
    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        frame.setSize(800, 600);
        
        PlatterScot p = new PlatterScot();
        p.readInput();
        
        frame.add(p);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}