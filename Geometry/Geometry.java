
/**
 * Calculates the angle of the line of 2 points, the slope of 2 points, and the area and perimeter of an ellipse.
 * 
 * Justin Liang
 * 11/18/08
 * Period 1
 */

import java.awt.geom.*;

public class Geometry
{
    /**
     * Calculates the angle of the line connecting 2 points in respect to the x-axis.
     * @param p the first point.
     * @param q the second point.
     * @return returns the angle of the line with respect to the x-axis.
     * (Precondition:  p != q)
     */
    public static double angle(Point2D.Double p, Point2D.Double q)
    {
        double pX = p.getX();
        double pY = p.getY();
        double qX = q.getX();
        double qY = q.getY();
        
        double newX = qX - pX;
        double newY = qY - pY;
        double angle = Math.toDegrees(Math.atan(newY/newX));
        return Math.abs(angle);
    }
    
    /**
     * Calculates the slope of the line that intersects 2 points.
     * @param p the first point.
     * @param q the second point.
     * @return returns the slope of the two lines.
     * (Precondition:  p != q)
     */
    public static double slope(Point2D.Double p, Point2D.Double q)
    {
        double pX = p.getX();
        double pY = p.getY();
        double qX = q.getX();
        double qY = q.getY();
        
        if(qX - pX == 0)
        {
            return Double.NaN;
        }
        else
        {
            double slope = (qY - pY) / (qX - pX);
            return slope;
        }
    }
    
    /**
     * Finds the perimeter of an ellipse.
     * @param e the ellipse.
     * @return returns the perimeter of ellipse e.
     * (Precondition: the width and the length of the ellipse can not be negative.)
     * (Postcondition: per >= 0)
     */
    public static double perimeter(Ellipse2D.Double e)
    {
        double x = e.getWidth();
        double y = e.getHeight();
        double per = (Math.PI) * (Math.sqrt((x*x + y*y) / 2));
        return per;
    }
    
    /**
     * Finds the area of an ellipse.
     * @param e the ellipse.
     * @return returns the area of ellipse e.
     * (Precondition: The width and the length of the ellipse can not be negative.)
     * (Postcondition: area >= 0)
     */
    public static double area(Ellipse2D.Double e)
    {
        double x = e.getWidth();
        double y = e.getHeight();
        double area = Math.PI * (.5 * x) * (.5 * y);
        return area;
    }
}