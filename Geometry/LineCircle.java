
/**
 * Draws a circle and a line with the equation y=mx+b. If the line does not intersect the circle, prints out message instead.
 * 
 * Justin Liang
 * 11/21/08
 * Period 1
 * 
 * Started: 11/21/08, 2:31PM
 * Finished: 11/21/08, 10:15PM
 * 
 * Took around 4 1/2 hours to think up of the logic for calculateLine and paintComponent.
 */
import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Scanner;
import javax.swing.JFrame;
import java.awt.geom.*;
import java.awt.Rectangle;
import java.awt.Color;

public class LineCircle extends JComponent
{
    String slope1;
    String intercept;
    double rad;
    double newSlope;
    double newIntercept;
    double xCoord1 = 300;
    double yCoord1 = 300;
    double xCoord2 = 300;
    double yCoord2 = 300;
    double xCenter;
    double yCenter;
    
    /**
     * The user inputs a line in form y=mx+b.
     * Stores the y-intercept value, and the slope.
     */
    public void storeLine()
    {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Please enter the equations as y=mx+b format with no spaces.");
        System.out.println("Please enter the equation: ");
        String eq1 = input.next();
        
        int length = eq1.length();
        
        int check1 = 0;
        int check2 = 0;
        int check3 = 0;
        String stringCheck;
        String stringCheck2;
        
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
        
        for(int i = 0; i < length; i++)
        {
            stringCheck2 = eq1.substring(i,i+1);
            
            if(stringCheck2.equalsIgnoreCase("x"))
            {
                check3 = i;
            }
        }
                
        slope1 = eq1.substring(check1+1, check2);
        intercept = eq1.substring(check3+1, length);
    }
    
    /**
     * The user inputs the radius of the circle.
     */
    public void storeCircle()
    {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Please enter the radius of the circle:");
        rad = input.nextDouble();
        
        System.out.println("Please enter the x-coordinate of the circle:");
        xCenter = input.nextDouble();
        
        System.out.println("Please enter the y-coordinate of the circle:");
        yCenter = input.nextDouble();
        
    }
    
    /**
     * Calculates the x-coordinates and y-coordinates of the starting and ending points of the 2 lines.
     * The main line that the user inputs consist of 2 smaller lines, each starting at the y-intercept,
     * but heading in opposite directions, therefore forming the bigger line.
     */
    public void calculateLine()
    {
        newSlope = Double.parseDouble(slope1);
        newIntercept = Double.parseDouble(intercept);
        
        if(newSlope > -1 && newSlope < 1)
        {
            if(newSlope > 0)
            {     
                while(xCoord1 < 600)
                {
                    while(yCoord1 > 0)
                    {
                        yCoord1 = yCoord1 - newSlope;
                        xCoord1 = xCoord1 + 1;
                    }
                }
        
                xCoord1 = xCoord1;
                yCoord1 = yCoord1-newIntercept;
            
                while(xCoord2 > 0)
                {
                    while(yCoord2 < 600)
                    {   
                        yCoord2 = yCoord2 + newSlope; 
                        xCoord2 = xCoord2 - 1;   
                    }
                }
        
                xCoord2 = xCoord2;
                yCoord2 = yCoord2-newIntercept;
            }
            
            if(newSlope < 0)
            {
                newSlope = Math.abs(newSlope);            
                while(xCoord1 > 0)
                {
                    while(yCoord1 > 0)
                    {
                        yCoord1 = yCoord1 - newSlope;
                        xCoord1 = xCoord1 - 1;
                    }
                }
        
                xCoord1 = xCoord1;
                yCoord1 = yCoord1-newIntercept;
            
                while(xCoord2 < 600)
                {   
                    while(yCoord2 < 600)
                    {
                        yCoord2 = yCoord2 + newSlope;
                        xCoord2 = xCoord2 + 1;
                    }
                }
        
                xCoord2 = xCoord2;
                yCoord2 = yCoord2-newIntercept;      
            }
        }
        
        if(newSlope <= -1 || newSlope >= 1)
        {
            if(newSlope > 0)
            {
                while(yCoord1 > 0)
                {
                    while(xCoord1 < 600)
                    {
                        yCoord1 = yCoord1 - newSlope;
                        xCoord1 = xCoord1 + 1;
                    }
                }
        
                xCoord1 = xCoord1;
                yCoord1 = yCoord1-newIntercept;
            
                while(yCoord2 < 600)
                {
                    while(xCoord2 > 0)
                    {   
                        yCoord2 = yCoord2 + newSlope; 
                        xCoord2 = xCoord2 - 1;   
                    }
                }
        
                xCoord2 = xCoord2;
                yCoord2 = yCoord2-newIntercept;
            }
            
            if(newSlope < 0)
            {
                newSlope = Math.abs(newSlope);            
                while(yCoord1 > 0)
                {
                    while(xCoord1 > 0)
                    {
                        yCoord1 = yCoord1 - newSlope;
                        xCoord1 = xCoord1 - 1;
                    }
                }
        
                xCoord1 = xCoord1;
                yCoord1 = yCoord1-newIntercept;
            
                while(yCoord2 < 600)
                {   
                    while(xCoord2 < 600)
                    {
                        yCoord2 = yCoord2 + newSlope;
                        xCoord2 = xCoord2 + 1;
                    }
                }
        
                xCoord2 = xCoord2;
                yCoord2 = yCoord2-newIntercept;        
            }
        }
    }
    
    /**
     * 
     * Determines whether the line intersects the circle or not.
     * If it intersects, the program will draw the y-axis, x-axis, the circle, and the 2 smaller lines that make up the main line.
     * If not, it will display a message.
     */
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        int checker = 0;
        
        double xCoord3 = 300;
        double yCoord3 = 300;
        double xCoord4 = 300;
        double yCoord4 = 300;
        
        Ellipse2D.Double ellipse = new Ellipse2D.Double(300-rad+xCenter,300-rad-yCenter,rad*2,rad*2);
        
        if(newSlope > -1 && newSlope < 1)
        {
            if(newSlope > 0)
            {
                while(xCoord3 < 600)
                {
                    while(yCoord3 > 0)
                    {
                        yCoord3 = yCoord3 - newSlope;
                        xCoord3 = xCoord3 + 1;
                        if(ellipse.contains(xCoord3, yCoord3-newIntercept))
                        {
                            checker = 1;
                            break;
                        }
                    }
                }
            
                while(xCoord4 > 0)
                {
                    while(yCoord4 < 600)
                    {   
                        yCoord4 = yCoord4 + newSlope; 
                        xCoord4 = xCoord4 - 1;
                        if(ellipse.contains(xCoord4, yCoord4-newIntercept))
                        {
                            checker = 1;
                            break;
                        }
                    }
                }
            }
            
            if(newSlope < 0)
            {
                newSlope = Math.abs(newSlope);            
                while(xCoord3 > 0)
                {
                    while(yCoord3 > 0)
                    {
                        yCoord3 = yCoord3 - newSlope;
                        xCoord3 = xCoord3 - 1;
                        if(ellipse.contains(xCoord3, yCoord3-newIntercept))
                        {
                            checker = 1;
                            break;
                        }
                    }
                }
            
                while(xCoord4 < 600)
                {   
                    while(yCoord4 < 600)
                    {
                        yCoord4 = yCoord4 + newSlope;
                        xCoord4 = xCoord4 + 1;
                        if(ellipse.contains(xCoord4, yCoord4-newIntercept))
                        {
                            checker = 1;
                            break;
                        }
                    }
                }   
            }
        }
        
        if(newSlope <= -1 || newSlope >= 1)
        {
            if(newSlope > 0)
            {
                while(yCoord3 > 0)
                {
                    while(xCoord3 < 600)
                    {
                        yCoord3 = yCoord3 - newSlope;
                        xCoord3 = xCoord3 + 1;
                        if(ellipse.contains(xCoord3, yCoord3-newIntercept))
                        {
                            checker = 1;
                            break;
                        }
                    }
                }
            
                while(yCoord4 < 600)
                {
                    while(xCoord4 > 0)
                    {   
                        yCoord4 = yCoord4 + newSlope; 
                        xCoord4 = xCoord4 - 1;
                        if(ellipse.contains(xCoord4, yCoord4-newIntercept))
                        {
                            checker = 1;
                            break;
                        }
                    }
                }
            }
            
            if(newSlope < 0)
            {
                newSlope = Math.abs(newSlope);            
                while(yCoord3 > 0)
                {
                    while(xCoord3 > 0)
                    {
                        yCoord3 = yCoord3 - newSlope;
                        xCoord3 = xCoord3 - 1;
                        if(ellipse.contains(xCoord3, yCoord3-newIntercept))
                        {
                            checker = 1;
                            break;
                        }
                    }
                }
            
                while(yCoord4 < 600)
                {   
                    while(xCoord4 < 600)
                    {
                        yCoord4 = yCoord4 + newSlope;
                        xCoord4 = xCoord4 + 1;
                        if(ellipse.contains(xCoord4, yCoord4-newIntercept))
                        {
                            checker = 1;
                            break;
                        }
                    }
                }     
            }
        }
        
        if(checker == 1)
        {
            Rectangle2D.Double xAxis = new Rectangle2D.Double(0,300,600,0);        
            g2.draw(xAxis);
        
            Rectangle2D.Double yAxis = new Rectangle2D.Double(300,0,0,600);
            g2.draw(yAxis);
            
            int i = 0;
            
            while(i <= 600)
            {
                Rectangle2D.Double xTick = new Rectangle2D.Double(i,295,0,10);
                g2.draw(xTick);
                
                Rectangle2D.Double yTick = new Rectangle2D.Double(295,i,10,0);
                g2.draw(yTick);
                
                i = i+50;
            }
            
            g2.setColor(Color.RED);
            g2.draw(ellipse);
        
            Line2D.Double line1 = new Line2D.Double(300,300-newIntercept,xCoord1,yCoord1);
            g2.setColor(Color.BLUE);
            g2.draw(line1);
        
            Line2D.Double line2 = new Line2D.Double(300,300-newIntercept,xCoord2,yCoord2);
            g2.setColor(Color.BLUE);
            g2.draw(line2);
            
            g2.setColor(Color.BLACK);
            
            double m = newSlope;
            double y = newIntercept;
            double h = xCenter;
            double k = yCenter;
            
            double a = 1+m*m;
            double d = -2*(h-m*y+m*k);
            double c = h*h+k*k+y*y-rad*rad-2*k*y;
            
            double xInt1 = (-1*d + Math.sqrt((d*d)-(4*a*c))) / (2*a);
            double xInt2 = (-1*d - Math.sqrt((d*d)-(4*a*c))) / (2*a);
            
            double yInt1 = newSlope*xInt1 + newIntercept;
            double yInt2 = newSlope*xInt2 + newIntercept;
            
            g2.drawString("Intersection at points:", 20, 30);
            g2.drawString("( " + xInt1 + " , " + yInt1 + " ) and ( " + xInt2 + " , " + yInt2 + " )", 20, 50);
        }
        
        else if(checker == 0)
        {
            Rectangle2D.Double xAxis = new Rectangle2D.Double(0,300,600,0);        
            g2.draw(xAxis);
        
            Rectangle2D.Double yAxis = new Rectangle2D.Double(300,0,0,600);
            g2.draw(yAxis);
            
            int i = 0;
            
            while(i <= 600)
            {
                Rectangle2D.Double xTick = new Rectangle2D.Double(i,295,0,10);
                g2.draw(xTick);
                
                Rectangle2D.Double yTick = new Rectangle2D.Double(295,i,10,0);
                g2.draw(yTick);
                
                i = i+50;
            }
            
            g2.setColor(Color.RED);
            g2.draw(ellipse);
        
            Line2D.Double line1 = new Line2D.Double(300,300-newIntercept,xCoord1,yCoord1);
            g2.setColor(Color.BLUE);
            g2.draw(line1);
        
            Line2D.Double line2 = new Line2D.Double(300,300-newIntercept,xCoord2,yCoord2);
            g2.setColor(Color.BLUE);
            g2.draw(line2);
            
            g2.setColor(Color.BLACK);
            g2.drawString("Does not intersect", 20,30);
        }
    }
    
    /**
     * Runs the program.
     */
    
    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        frame.setSize(610, 635);
        
        LineCircle test = new LineCircle();
        
        test.storeLine();
        test.storeCircle();
        test.calculateLine();
        
        frame.add(test);        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}